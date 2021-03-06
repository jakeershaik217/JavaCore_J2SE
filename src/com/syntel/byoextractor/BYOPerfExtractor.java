package com.syntel.byoextractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BYOPerfExtractor {
	int rowCount = 0;
	Element ksfs,optPkgs,facInstOpt,acc;
	Element ksfsTblcontent, optPkgsTblcontent,optFactInstTblContent,accTblContent;
	private Row rowHeader;
	private Cell cell = null;
	List<String> pkgNames = new ArrayList<String>();

	public void tblIterator(XSSFWorkbook wb, XSSFSheet sheet,String title, Element tbl){
		//Set Header Style
		XSSFCellStyle headerStyle = wb.createCellStyle();
		headerStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(22, 54, 92)));
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

		//Set Sub-Header Style
		XSSFCellStyle subHeaderStyle = wb.createCellStyle();
		subHeaderStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(197, 217, 241)));
		subHeaderStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

		//Set Header font color
		Font headerFont = wb.createFont();
		headerFont.setFontName("Calibri");
		headerFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		headerStyle.setFont(headerFont);
		headerFont.setColor(IndexedColors.WHITE.getIndex());
		headerStyle.setFont(headerFont);

		rowHeader = sheet.createRow(rowCount);
		cell = rowHeader.createCell(0);
		cell.setCellValue(title.toLowerCase());
		cell.setCellStyle(headerStyle);
		sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 0, 4));
		rowCount++;
		for (Element row : tbl.select("tr")) {
			rowHeader = sheet.createRow(rowCount);
			// loop through all
			Elements ths = row.select("th");
			int count = 0;
			for (Element thContent : ths) {
				// set header style
				cell = rowHeader.createCell(count);
				cell.setCellValue(thContent.text());
				cell.setCellStyle(subHeaderStyle);
				count++;
			}
			Elements tds = row.select("td:not([rowspan])");
			count = 0;
			for (Element tdContent : tds) {
				// create cell for each
				cell = rowHeader.createCell(count);
				cell.setCellValue(tdContent.text());
				if(title=="Options (Packages)"){
					if(!pkgNames.contains(tdContent.firstElementSibling().text())){
						pkgNames.add(tdContent.firstElementSibling().text());
					}
				}
				count++;
			}
			rowCount++;
			// set auto size column for excel sheet
			sheet = wb.getSheetAt(3);
			for (int j = 0; j < row.select("th").size(); j++) {
				sheet.setColumnWidth(j, 8000);
				//sheet.autoSizeColumn(j);
			}
		}

	}


	public void BYOPerfExterior(XSSFWorkbook wb) {
		Connection.Response res;
		try {
			//Local Constants
			res = BYOExtractorConfig.confluenceConfig();
			Map<String, String> loginCookies  = res.cookies();
			XSSFSheet performanceSheet = wb.createSheet("performance");

			//performanceSheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
			//Performance & Safety section
			//System.out.println("Performance & Safety section Started");
			Document perfPage = Jsoup.connect(BYOExtractorUtils.perfNdSafetyUrl).cookies(loginCookies).timeout(60000).get();

			/****************************Key Standard Features********************************/
			ksfs = perfPage.select("h1:contains(Key Standard Features)").first();
			//System.out.println(ksfs);
			ksfsTblcontent = ksfs.nextElementSibling();
			//System.out.println(wheelsTblContent);
			tblIterator(wb, performanceSheet, "Key Standard Features", ksfsTblcontent);

			/****************************(Options (Packages))********************************/
			optPkgs = perfPage.select("h1:contains(Options (Packages))").first();
			//System.out.println(optPkgs);
			optPkgsTblcontent = optPkgs.nextElementSibling();
			//System.out.println(optPkgsTblcontent);
			tblIterator(wb, performanceSheet, "Options (Packages)", optPkgsTblcontent);

			for(String pkgNm : pkgNames){
				cell = performanceSheet.createRow(rowCount).createCell(0);
				cell.setCellValue(pkgNm);
				if(optPkgsTblcontent.tagName().contains("h1") || optPkgsTblcontent.tagName().contains("p")){
					//System.out.println(optPkgsTblcontent.nextElementSibling());
					Element nextsib =   perfPage.select("h1:contains("+pkgNm+")").first();
					Element iteratePkgTblContent = nextsib.nextElementSibling();
					tblIterator(wb, performanceSheet, pkgNm , iteratePkgTblContent);
				}else{
					System.out.println("No package content");
				}
				optPkgsTblcontent = optPkgsTblcontent.nextElementSibling();
			}




			/****************************Options (Factory Installed)********************************/
			facInstOpt = perfPage.select("h1:contains(Options (Factory Installed))").first();
			//System.out.println(facInstOpt);


			if(BYOExtractorUtils.verticalTable[0]){
				rowHeader = performanceSheet.createRow(rowCount);
				cell = rowHeader.createCell(0);
				cell.setCellValue("Options (Factory Installed)".toLowerCase());
				rowCount++;
				String[] headers = new String[] { "Name", "Image", "Image / Filename", "Copy", "Disclaimer", "Price", "Notes" };
				int count =0;
				System.out.println(rowCount);
				//Row tempHeader = exteriorSheet.createRow(rowCount);
				for (String value : headers) {
					cell =  rowHeader.createCell(count);
					cell.setCellValue(value);
					count++;
				}
				int l=0;
				optFactInstTblContent = facInstOpt.nextElementSibling();
				while(l<25){
					optFactInstTblContent = optFactInstTblContent.nextElementSibling();
					if(!optFactInstTblContent.tagName().contains("h1")){
						//System.out.println();
						if(!optFactInstTblContent.tagName().contains("p")){
							//	System.out.println(optFactInstTblContent);
							count = 0;
							Row optInstHeader = performanceSheet.createRow(rowCount);

							for (Element row : optFactInstTblContent.select("td")) {
								Elements tds = row.select("td:not([rowspan])");
								for (Element tdContent : tds) {
									cell = optInstHeader.createCell(count);
									cell.setCellValue(tdContent.text());
									count++;
								}
								performanceSheet = wb.getSheetAt(3);
							}
							rowCount++;
						}else{
							continue;
						}
					}else{
						break;
					}
				}
			}else{
				tblIterator(wb, performanceSheet, "Options (Factory Installed)", optPkgsTblcontent);
			}


			/****************************Accessories********************************/
			acc = perfPage.select("h1:contains(Accessories)").first();
			//System.out.println(acc);

			if(BYOExtractorUtils.verticalTable[0]){
				String title = "accessories";
				rowCount++;
				performanceSheet.addMergedRegion(new CellRangeAddress(rowCount-1, rowCount-1, 0, 4));
				rowHeader = performanceSheet.createRow(rowCount);
				cell = rowHeader.createCell(0);
				cell.setCellValue(title);

				rowCount++;
				String[] headers = new String[] { "Name", "Image", "Image / Filename", "Copy", "Disclaimer", "Price", "Notes" };
				int count =0;
				for (String value : headers) {
					cell = rowHeader.createCell(count);
					cell.setCellValue(value);
					count++;
				}
				int l=0;
				accTblContent = acc.nextElementSibling();
				while(l<25){
					accTblContent = accTblContent.nextElementSibling();
					if(!accTblContent.id().contains("likes-and-labels-container") && accTblContent != null){
						if(!accTblContent.tagName().contains("p")){
							//System.out.println(accTblContent);
							count = 0;
							Row accHeader = performanceSheet.createRow(rowCount);
							for (Element row : accTblContent.select("td")) {
								Elements tds = row.select("td:not([rowspan])");
								for (Element tdContent : tds) {
									cell = accHeader.createCell(count);
									cell.setCellValue(tdContent.text());
									count++;
								}
								performanceSheet = wb.getSheetAt(3);
							}
							rowCount++;
						}else{
							continue;
						}
					}else{
						break;
					}
				}
			}else{
				tblIterator(wb, performanceSheet, "Accessories", accTblContent);
			}

		}catch(Exception e){
			e.printStackTrace();

		}
	}
}
