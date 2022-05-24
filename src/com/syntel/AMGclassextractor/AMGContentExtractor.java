package com.syntel.AMGclassextractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.syntel.classextractor.ClassExtractorConfig;
import com.syntel.classextractor.ClassExtractorUtils;

public class AMGContentExtractor {
	int rowCount = 0,l=0,count=0;
	Element herocarousel,design,introduction,performance,technology,innovation,matic,amg,models,siteshare;
	Element galleryexterior,galleryinterior,gallerymedia,galleryaccessories;
	Element herocarouselTblcontent,designTblcontent,introductionTblcontent,performanceTblContent,technologyTblContent,innovationTblContent,maticTblContent,amgTblContent,modelsTblContent,siteshareTblContent;
	Element galleryexteriorTblcontent,galleryinteriorTblcontent,gallerymediaTblcontent,galleryaccessoriesTblcontent;
	//XSSFWorkbook wb;
	private Row rowHeader,row;
	private Cell cell = null;
	List<String> pkgNames = new ArrayList<String>();
	public void classContentExtractor(XSSFWorkbook wb) {
		Connection.Response res;
		try {
			res =ClassExtractorConfig.confluenceConfig();	
			Map<String, String> loginCookies  = res.cookies();
			Document classPage = Jsoup.connect(AMGClassExtractorUtils.url).cookies(loginCookies).timeout(90000).get();
			XSSFSheet heroSheet = null,categorieSheet = null,modelSheet = null,amgSheet =null,siteshareSheet = null,gallerySheet = null;
			if(!AMGClassExtractorUtils.gallery){
				heroSheet = wb.createSheet("Hero");
				categorieSheet = wb.createSheet("Categories");
				amgSheet = wb.createSheet("AMG");
				modelSheet = wb.createSheet("Model");
				siteshareSheet = wb.createSheet("Site Share");
			}

			if(AMGClassExtractorUtils.gallery){
				gallerySheet = wb.createSheet("Gallery");
				System.out.println("gallery");
			}		

			/*Elements header=classPage.select("h1");
			ArrayList headers = new ArrayList<>();
			headers.add(header);
			for (Object object : headers) {
				System.out.println(object);
			}*/


			//Content
			herocarousel = classPage.select("h1:contains(Hero Carousel)").first();
			design = classPage.select("h1:contains(Design)").first();
			introduction=classPage.select("h1:contains(Introduction)").first();
			performance = classPage.select("h1:contains(Performance)").first();
			technology = classPage.select("h1:contains(Technology)").first();
			innovation = classPage.select("h1:contains(Innovation)").first();
			matic = classPage.select("h1:contains(4MATIC)").first();
			amg = classPage.select("h1:contains(AMG)").last();
			models = classPage.select("h1:contains(Models)").first();
			siteshare = classPage.select("h1:contains(Site share)").first();

			//Gallery
			galleryexterior = classPage.select("h1:contains(Exterior)").first();
			galleryinterior = classPage.select("h1:contains(Interior)").first();
			gallerymedia = classPage.select("h1:contains(Media)").first();
			galleryaccessories = classPage.select("h1:contains(Accessories)").first();

			if(!AMGClassExtractorUtils.gallery){
				/***************************************hero carousel*************************************************/
				if(herocarousel!=null ) {
					heroCarouselContentMethod(wb, herocarousel,heroSheet); 
				}else{
					System.out.println("hero table is not present");
				}


				/***************************************design*************************************************/
				if(design!=null) {
					designContentMethod(wb, design,categorieSheet);
				}else{
					System.out.println("design table is not present");
				}


				/***************************************performance*************************************************/
				if(performance!=null) {
					performanceContentMethod(wb, performance,categorieSheet);
				}else{
					System.out.println("performance table is not present");
				}
				
				/***************************************Innovation*************************************************/
				if(innovation!=null) {
					innovationContentMethod(wb, innovation,categorieSheet);
				}else{
					System.out.println("innovation table is not present");
				}

				/***************************************technology*************************************************/
				if(technology!=null) {
					technologyContentMethod(wb, technology,categorieSheet);
				}else{
					System.out.println("performance table is not present");
				}
				/***************************************Intoduction*************************************************/
				if(introduction!=null) {
					introductionContentMethod(wb, introduction,categorieSheet);
				}else{
					System.out.println("Introduction table is not present");
				}

				/***************************************4Matic*************************************************/
				if(matic!=null) {
					maticContentMethod(wb, matic,categorieSheet);
				}else{
					System.out.println("4matic table is not present");
				}

				/***************************************AMG*************************************************/
				if(amg!=null) {
					amgContentMethod(wb, amg,amgSheet);
				}else{
					System.out.println("AMG table is not present");
				}
				/***************************************models*************************************************/
				if(models!=null) {
					modelContentMethod(wb, models,modelSheet);
				}else{
					System.out.println("models table is not present");
				}
				/***************************************siteshare*************************************************/
				if(siteshare!=null) {
					siteShareContentMethod(wb, siteshare,siteshareSheet);
				}else{
					System.out.println("siteshare table is not present");
				}
			}


			/*	*//***************************************Gallery Exterior*************************************************//*
			if(galleryexterior!=null) {
				galleryexteriorContentMethod(wb, siteshare,gallerySheet);
			}else{
				System.out.println("Gallery Exterior table is not present");
			}
			 *//***************************************Gallery Interior*************************************************//*
			if(galleryinterior!=null) {
				galleryinteriorContentMethod(wb, siteshare,gallerySheet);
			}else{
				System.out.println("Gallery Interio table is not present");
			}
			  *//***************************************Gallery Media*************************************************//*
			if(gallerymedia!=null) {
				gallerymediaContentMethod(wb, siteshare,gallerySheet);
			}else{
				System.out.println("Gallery Media table is not present");
			}
			   *//***************************************Gallery Accessories*************************************************//*
			if(galleryaccessories!=null) {
				galleryaccessoriesContentMethod(wb, siteshare,gallerySheet);
			}else{
				System.out.println("Gallery Accessories table is not present");
			}*/
		}catch(Exception e){
			e.printStackTrace();

		}
	}
	
	private void technologyContentMethod(XSSFWorkbook wb, Element technology, XSSFSheet categorieSheet) {
		System.out.println("performance");
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);		
		technologyTblContent= technology.nextElementSibling();			
		Elements technologyths= technologyTblContent.select("th");		
		count = 1;
		rowCount++;
		rowHeader = categorieSheet.createRow(rowCount);
		//Design headers
		for (Element thContent : technologyths) {
			// set header style
			cell = rowHeader.createCell(0);
			cell.setCellValue("Section");
			cell.setCellStyle(HeaderStyle);
			cell = rowHeader.createCell(count);
			cell.setCellValue(thContent.text());
			cell.setCellStyle(HeaderStyle);
			count++;
		}			
		rowCount++;		
		l=0;			
		while(l<50){
			if(l==0){
				technologyTblContent= technology.nextElementSibling();	
			}else{
				technologyTblContent= technologyTblContent.nextElementSibling();
			}
			if(!technologyTblContent.tagName().contains("h1")){					
				if(!technologyTblContent.tagName().contains("p")){						
					count =1;
					Row technologyContent = categorieSheet.createRow(rowCount);
					for (Element row : technologyTblContent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");
						for(int i=0;i<=rowCount;i++)	{
							cell = technologyContent.createCell(0);
							cell.setCellValue("Technology");
							cell.setCellStyle(ContentStyle);
						}
						for (Element tdContent : tds) {
							cell = technologyContent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}
						categorieSheet = wb.getSheetAt(1);
					}
					rowCount++;
					l++;
					categorieSheet = wb.getSheetAt(1);
					for (int j = 0; j < technologyths.size(); j++) {
						categorieSheet.setColumnWidth(j, 8000);
						//sheet.autoSizeColumn(j);
					}
				}else{
					continue;
				}
			}else{
				break;
			}
		}

	}
	private void siteShareContentMethod(XSSFWorkbook wb, Element siteshare, XSSFSheet siteshareSheet) {
		System.out.println("site share");
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);		
		siteshareTblContent = siteshare.nextElementSibling();			
		Elements siteshareTblContentths= siteshareTblContent.select("th");	
		rowCount=0;
		count = 0;
		rowCount++;
		rowHeader = siteshareSheet.createRow(0);
		//Design headers
		for (Element thContent : siteshareTblContentths) {
			// set header style

			cell = rowHeader.createCell(count);
			cell.setCellValue(thContent.text());
			cell.setCellStyle(HeaderStyle);
			count++;
		}			
		rowCount++;				
		if(!siteshareTblContent.tagName().contains("h1")){
			if(!siteshareTblContent.tagName().contains("p")){
				count =0;
				Row siteshareContent = siteshareSheet.createRow(rowCount);

				for (Element row : siteshareTblContent.select("td")) {
					Elements tds = row.select("td:not([rowspan])");
					for (Element tdContent : tds) {
						cell = siteshareContent.createCell(count);
						cell.setCellValue(tdContent.text());
						cell.setCellStyle(ContentStyle);
						cell.setCellStyle(ContentStyle);
						count++;
					}
					siteshareSheet = wb.getSheetAt(4);
				}
				rowCount++;
				siteshareSheet = wb.getSheetAt(4);
				for (int j = 0; j < siteshareTblContentths.size(); j++) {
					siteshareSheet.setColumnWidth(j, 8000);
					//sheet.autoSizeColumn(j);
				}
			}
		}

	}

	private void modelContentMethod(XSSFWorkbook wb, Element models, XSSFSheet modelSheet) {
		System.out.println("model");
		ArrayList Headers = new ArrayList<>();
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);		
		modelsTblContent = models.nextElementSibling();					
		// structure of model table is different from other tables, selecting tr tag
		Elements modelsTblContenttrs= modelsTblContent.select("tr");	
		Element modelsTblHeaders = modelsTblContenttrs.first();
		List<String> modelTblModels = modelsTblHeaders.select("th").eachText();		
		int totalModels = modelTblModels.size() - 1;			
		rowCount=0;
		l=0;
		/*//for(int i=0;i<totalModels;i++){
			for (Element trs : modelsTblContenttrs) {
				Element contentTR=trs.nextElementSibling();
				Elements contenttd=contentTR.select("th");
				System.out.println(contenttd);
			}
		//}
		 */
		for(int i=0;i<totalModels;i++){			
			for (Element trs : modelsTblContenttrs) {
				Element thContent = trs.select("th").first();
				//System.out.println(thContent.toString());
				rowHeader = modelSheet.createRow(rowCount);
				cell = rowHeader.createCell(0);	
				cell.setCellValue(thContent.text());
				cell.setCellStyle(HeaderStyle);				
				//count++;
				rowCount++;
				Node columnContent = thContent.nextSibling();
				if(l==0){
					columnContent =   thContent.nextSibling();
					cell = rowHeader.createCell(1);
					//System.out.println(((Element) columnContent).text());
					cell.setCellValue(((Element) columnContent).text());
					cell.setCellStyle(ContentStyle);
				}else{
					for(int j=0;j<i;j++){					
						columnContent = columnContent.nextSibling();
					}
					cell = rowHeader.createCell(1);
					//System.out.println(((Element) columnContent).text());
					cell.setCellValue(((Element) columnContent).text());
					cell.setCellStyle(ContentStyle);			
				}
				modelSheet = wb.getSheetAt(3);
				for (int j = 0; j < totalModels; j++) {
					modelSheet.setColumnWidth(j, 8000);
					//sheet.autoSizeColumn(j);
				}
			}
			l++;
			rowCount++;			
		}

	}
	private void amgContentMethod(XSSFWorkbook wb, Element amg, XSSFSheet amgSheet) {
		System.out.println("amg");
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);
		amgTblContent = amg.nextElementSibling();			
		Elements amgTblcontentths= amgTblContent.select("th");		
		count = 0;
		rowCount=0;
		rowHeader = amgSheet.createRow(rowCount);
		//Design headers
		for (Element thContent : amgTblcontentths) {
			// set header style
			cell = rowHeader.createCell(count);
			cell.setCellValue(thContent.text());			
			cell.setCellStyle(HeaderStyle);
			count++;
			amgSheet = wb.getSheetAt(2);
			for (int j = 0; j < amgTblcontentths.size(); j++) {
				amgSheet.setColumnWidth(j, 8000);
				//sheet.autoSizeColumn(j);
			}
		}			
		rowCount++;		
		l=0;
		rowCount=1;
		while(l<50){
			if(l==0){
				amgTblContent= amg.nextElementSibling();	
			}else{
				amgTblContent= amgTblContent.nextElementSibling();
			}
			if(!amgTblContent.tagName().contains("h1")){					
				if(!amgTblContent.tagName().contains("p")){						
					count =0;
					Row amgcontent = amgSheet.createRow(rowCount);
					for (Element row : amgTblContent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");						
						for (Element tdContent : tds) {								
							cell = amgcontent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}
						amgSheet = wb.getSheetAt(2);					}
					rowCount++;
					l++;
					amgSheet = wb.getSheetAt(2);
					for (int j = 0; j < amgTblcontentths.size()+1; j++) {
						amgSheet.setColumnWidth(j, 8000);
						//sheet.autoSizeColumn(j);
					}
				}else{
					continue;
				}
			}else{
				break;
			}
		}

	}
	private void introductionContentMethod(XSSFWorkbook wb, Element introduction, XSSFSheet categorieSheet) {
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);		
		introductionTblcontent= introduction.nextElementSibling();			
		Elements introductionths= introductionTblcontent.select("th");	
		if(design==null  || performance==null || technology==null|| matic==null){
			rowCount=0;
		}else{			
			rowCount++;
		}
		count = 1;
		rowHeader = categorieSheet.createRow(rowCount);
		//Design headers
		for (Element thContent : introductionths) {
			// set header style
			cell = rowHeader.createCell(0);
			cell.setCellValue("Section");
			cell.setCellStyle(HeaderStyle);
			cell = rowHeader.createCell(count);
			cell.setCellValue(thContent.text());
			cell.setCellStyle(HeaderStyle);
			count++;
		}			
		rowCount++;		
		l=0;			
		while(l<50){
			if(l==0){
				introductionTblcontent= introduction.nextElementSibling();	
			}else{
				introductionTblcontent= introductionTblcontent.nextElementSibling();
			}
			if(!introductionTblcontent.tagName().contains("h1")){					
				if(!introductionTblcontent.tagName().contains("p")){						
					count =1;
					Row introductionContent = categorieSheet.createRow(rowCount);
					for (Element row : introductionTblcontent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");
						for(int i=0;i<=rowCount;i++)	{
							cell = introductionContent.createCell(0);
							cell.setCellValue("Introduction");
							cell.setCellStyle(ContentStyle);
						}
						for (Element tdContent : tds) {
							cell = introductionContent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}
						categorieSheet = wb.getSheetAt(1);
					}
					rowCount++;
					l++;
					categorieSheet = wb.getSheetAt(1);
					for (int j = 0; j < introductionths.size(); j++) {
						categorieSheet.setColumnWidth(j, 8000);
						//sheet.autoSizeColumn(j);
					}
				}else{
					continue;
				}
			}else{
				break;
			}
		}

	}
	private void maticContentMethod(XSSFWorkbook wb, Element matic, XSSFSheet categorieSheet) {
		System.out.println("4matic");

		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);		
		maticTblContent= matic.nextElementSibling();			
		Elements maticths= maticTblContent.select("th");		
		count = 1;
		rowCount++;
		rowHeader = categorieSheet.createRow(rowCount);
		//Design headers
		for (Element thContent : maticths) {
			// set header style

			cell = rowHeader.createCell(0);
			cell.setCellValue("Section");
			cell.setCellStyle(HeaderStyle);
			cell = rowHeader.createCell(count);
			cell.setCellValue(thContent.text());
			cell.setCellStyle(HeaderStyle);
			count++;
		}			
		rowCount++;		
		l=0;			
		while(l<50){
			if(l==0){
				maticTblContent= matic.nextElementSibling();	
			}else{
				maticTblContent= maticTblContent.nextElementSibling();
			}
			if(!maticTblContent.tagName().contains("h1")){					
				if(!maticTblContent.tagName().contains("p")){						
					count =1;
					Row maticContent = categorieSheet.createRow(rowCount);
					for (Element row : maticTblContent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");
						for(int i=0;i<=rowCount;i++)	{
							cell = maticContent.createCell(0);
							cell.setCellValue("4Matic");
							cell.setCellStyle(ContentStyle);
						}
						for (Element tdContent : tds) {
							cell = maticContent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}
						categorieSheet = wb.getSheetAt(1);
					}
					rowCount++;
					l++;
					categorieSheet = wb.getSheetAt(1);
					for (int j = 0; j < maticths.size(); j++) {
						categorieSheet.setColumnWidth(j, 8000);
						//sheet.autoSizeColumn(j);
					}
				}else{
					continue;
				}
			}else{
				break;
			}
		}

	}
	private void performanceContentMethod(XSSFWorkbook wb, Element performance, XSSFSheet categorieSheet) {
		System.out.println("performance");
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);		
		performanceTblContent= performance.nextElementSibling();			
		Elements performanceths= performanceTblContent.select("th");		
		count = 1;
		rowCount++;
		rowHeader = categorieSheet.createRow(rowCount);
		//Design headers
		for (Element thContent : performanceths) {
			// set header style
			cell = rowHeader.createCell(0);
			cell.setCellValue("Section");
			cell.setCellStyle(HeaderStyle);
			cell = rowHeader.createCell(count);
			cell.setCellValue(thContent.text());
			cell.setCellStyle(HeaderStyle);
			count++;
		}			
		rowCount++;		
		l=0;			
		while(l<50){
			if(l==0){
				performanceTblContent= performance.nextElementSibling();	
			}else{
				performanceTblContent= performanceTblContent.nextElementSibling();
			}
			if(!performanceTblContent.tagName().contains("h1")){					
				if(!performanceTblContent.tagName().contains("p")){						
					count =1;
					Row performanceContent = categorieSheet.createRow(rowCount);
					for (Element row : performanceTblContent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");
						for(int i=0;i<=rowCount;i++)	{
							cell = performanceContent.createCell(0);
							cell.setCellValue("Performance");
							cell.setCellStyle(ContentStyle);
						}
						for (Element tdContent : tds) {
							cell = performanceContent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}
						categorieSheet = wb.getSheetAt(1);
					}
					rowCount++;
					l++;
					categorieSheet = wb.getSheetAt(1);
					for (int j = 0; j < performanceths.size(); j++) {
						categorieSheet.setColumnWidth(j, 8000);
						//sheet.autoSizeColumn(j);
					}
				}else{
					continue;
				}
			}else{
				break;
			}
		}

	}
	private void innovationContentMethod(XSSFWorkbook wb, Element innovationTblContent, XSSFSheet categorieSheet) {
		System.out.println("Innovation");
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);		
		innovationTblContent= innovation.nextElementSibling();			
		Elements innovationths= innovationTblContent.select("th");		
		count = 1;
		rowCount++;
		rowHeader = categorieSheet.createRow(rowCount);
		//Design headers
		for (Element thContent : innovationths) {
			// set header style
			cell = rowHeader.createCell(0);
			cell.setCellValue("Section");
			cell.setCellStyle(HeaderStyle);
			cell = rowHeader.createCell(count);
			cell.setCellValue(thContent.text());
			cell.setCellStyle(HeaderStyle);
			count++;
		}			
		rowCount++;		
		l=0;			
		while(l<50){
			if(l==0){
				innovationTblContent= innovation.nextElementSibling();	
			}else{
				innovationTblContent= innovationTblContent.nextElementSibling();
			}
			if(!innovationTblContent.tagName().contains("h1")){					
				if(!innovationTblContent.tagName().contains("p")){						
					count =1;
					Row innovationContent = categorieSheet.createRow(rowCount);
					for (Element row : innovationTblContent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");
						for(int i=0;i<=rowCount;i++)	{
							cell = innovationContent.createCell(0);
							cell.setCellValue("Innovation");
							cell.setCellStyle(ContentStyle);
						}
						for (Element tdContent : tds) {
							cell = innovationContent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}
						categorieSheet = wb.getSheetAt(1);
					}
					rowCount++;
					l++;
					categorieSheet = wb.getSheetAt(1);
					for (int j = 0; j < innovationths.size(); j++) {
						categorieSheet.setColumnWidth(j, 8000);
						//sheet.autoSizeColumn(j);
					}
				}else{
					continue;
				}
			}else{
				break;
			}
		}
		
	}
	private void designContentMethod(XSSFWorkbook wb, Element design, XSSFSheet categorieSheet) {
		System.out.println("design");
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);
		designTblcontent= design.nextElementSibling();			
		Elements designths= designTblcontent.select("th");
		rowCount= 0;
		count = 1;
		rowCount++;
		rowHeader = categorieSheet.createRow(0);
		//Design headers
		for (Element thContent : designths) {
			// set header style
			cell = rowHeader.createCell(0);
			cell.setCellValue("Section");
			cell.setCellStyle(HeaderStyle);
			cell = rowHeader.createCell(count);
			cell.setCellValue(thContent.text());
			cell.setCellStyle(HeaderStyle);				
			count++;
			categorieSheet = wb.getSheetAt(1);
			for (int j = 0; j < designths.size()+1; j++) {
				categorieSheet.setColumnWidth(j, 8000);
				//sheet.autoSizeColumn(j);
			}
		}			
		rowCount++;		
		l=0;
		rowCount=1;
		while(l<50){
			if(l==0){
				designTblcontent= design.nextElementSibling();	
			}else{
				designTblcontent= designTblcontent.nextElementSibling();
			}
			if(!designTblcontent.tagName().contains("h1")){					
				if(!designTblcontent.tagName().contains("p")){						
					count =1;
					Row designcontent = categorieSheet.createRow(rowCount);
					for (Element row : designTblcontent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");
						for(int i=0;i<=rowCount;i++)	{
							cell = designcontent.createCell(0);
							cell.setCellValue("Design");
							cell.setCellStyle(ContentStyle);
						}
						for (Element tdContent : tds) {								
							cell = designcontent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}

						categorieSheet = wb.getSheetAt(1);
					}
					rowCount++;
					l++;
					categorieSheet = wb.getSheetAt(1);
					for (int j = 0; j < designths.size()+1; j++) {
						categorieSheet.setColumnWidth(j, 8000);
						//sheet.autoSizeColumn(j);
					}
				}else{
					continue;
				}
			}else{
				break;
			}
		}		
	}
	private void heroCarouselContentMethod(XSSFWorkbook wb, Element herocarousel, XSSFSheet heroSheet) {
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);
		herocarouselTblcontent = herocarousel.nextElementSibling();			
		Elements herocarouselTblcontentths= herocarouselTblcontent.select("th");		
		//count = 0;
		//rowCount++;
		rowHeader = heroSheet.createRow(rowCount);
		//Design headers
		for (Element thContent : herocarouselTblcontentths) {
			// set header style
			cell = rowHeader.createCell(count);
			cell.setCellValue(thContent.text());			
			cell.setCellStyle(HeaderStyle);
			count++;
			heroSheet = wb.getSheetAt(0);
			for (int j = 0; j < herocarouselTblcontentths.size(); j++) {
				heroSheet.setColumnWidth(j, 8000);
				//sheet.autoSizeColumn(j);
			}
		}			
		rowCount++;		
		l=0;
		rowCount=1;
		while(l<50){
			if(l==0){
				herocarouselTblcontent= herocarousel.nextElementSibling();	
			}else{
				herocarouselTblcontent= herocarouselTblcontent.nextElementSibling();
			}
			if(!herocarouselTblcontent.tagName().contains("h1")){					
				if(!herocarouselTblcontent.tagName().contains("p")){						
					count =0;
					Row herocontent = heroSheet.createRow(rowCount);
					for (Element row : herocarouselTblcontent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");						
						for (Element tdContent : tds) {								
							cell = herocontent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}
						heroSheet = wb.getSheetAt(0);					}
					rowCount++;
					l++;
					heroSheet = wb.getSheetAt(0);
					for (int j = 0; j < herocarouselTblcontentths.size()+1; j++) {
						heroSheet.setColumnWidth(j, 8000);
						//sheet.autoSizeColumn(j);
					}
				}else{
					continue;
				}
			}else{
				break;
			}
		}

	}
	private XSSFCellStyle contentStyleMethod(XSSFWorkbook wb) {
		//Set content style.
		XSSFCellStyle ContentStyle = wb.createCellStyle();			
		Font contentFont = wb.createFont();
		ContentStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		ContentStyle.setAlignment(CellStyle.ALIGN_LEFT);
		contentFont.setFontName("Calibri");
		ContentStyle.setFont(contentFont);
		ContentStyle.setWrapText(true);
		return ContentStyle;
	}
	private XSSFCellStyle headerStyleMethod(XSSFWorkbook wb) {
		XSSFCellStyle HeaderStyle = wb.createCellStyle();
		//CellStyle HeaderCs = wb.createCellStyle();		
		HeaderStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(22, 54, 92)));
		HeaderStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		//HeaderCs.setWrapText(true);
		HeaderStyle.setWrapText(true);
		//HeaderStyle.setAlignment(CellStyle.ALIGN_CENTER);
		//Set Header font color
		Font headerFont = wb.createFont();
		headerFont.setFontName("Calibri");
		headerFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		headerFont.setColor(IndexedColors.WHITE.getIndex());
		HeaderStyle.setFont(headerFont);
		return HeaderStyle;	
	}
}
