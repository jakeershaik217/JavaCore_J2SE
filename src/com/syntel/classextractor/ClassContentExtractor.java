package com.syntel.classextractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFBorderFormatting;
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

import com.syntel.byoextractor.BYOExtractorConfig;
import com.syntel.byoextractor.BYOExtractorUtils;

public class ClassContentExtractor {

	int rowCount = 0,l=0,count=0;
	Element herocarousel,design,performance,innovation,technology,models,siteshare;
	Element galleryexterior,galleryinterior,gallerymedia,galleryaccessories;
	Element herocarouselTblcontent,designTblcontent,performanceTblContent,innovationTblContent,technologyTblContent,modelsTblContent,siteshareTblContent;
	Element galleryexteriorTblcontent,galleryinteriorTblcontent,gallerymediaTblcontent,galleryaccessoriesTblcontent;
	//XSSFWorkbook wb;
	private Row rowHeader,row,urlRow;
	private Cell cell = null,urlCell =null;
	List<String> pkgNames = new ArrayList<String>();




	public void classContentExtractor(XSSFWorkbook wb) {
		Connection.Response res;
		try {

			res =ClassExtractorConfig.confluenceConfig();	
			Map<String, String> loginCookies  = res.cookies();
			Document classPage = Jsoup.connect(ClassExtractorUtils.url).cookies(loginCookies).timeout(60000).get();
			XSSFSheet heroSheet = null,categorieSheet = null,modelSheet = null,siteshareSheet = null,gallerySheet = null,urlSheet = null;
			if(ClassExtractorUtils.content){
				heroSheet = wb.createSheet("Hero");
				categorieSheet = wb.createSheet("Categories");
				modelSheet = wb.createSheet("Model");
				siteshareSheet = wb.createSheet("Site Share");
				urlSheet = wb.createSheet("URL");
			}

			if(ClassExtractorUtils.gallery){
				gallerySheet = wb.createSheet("Gallery");
				System.out.println("gallery");
				urlSheet = wb.createSheet("URL");
			}		

			//Content
			herocarousel = classPage.select("h1:contains(Hero Carousel)").first();
			design = classPage.select("h1:contains(Design)").first();
			performance = classPage.select("h1:contains(Performance)").first();
			innovation = classPage.select("h1:contains(Innovation)").first();
			technology = classPage.select("h1:contains(Technology)").first();
			models = classPage.select("h1:contains(Models)").first();
			siteshare = classPage.select("h1:contains(Site share)").first();
			//Gallery
			galleryexterior = classPage.select("h1:contains(Exterior)").first();
			galleryinterior = classPage.select("h1:contains(Interior)").first();
			gallerymedia = classPage.select("h1:contains(Media)").first();
			galleryaccessories = classPage.select("h1:contains(Accessories)").first();

			if(ClassExtractorUtils.content){
				/***************************************hero carousel*************************************************/
				if(herocarousel!=null ) {
					heroCarouselContentMethod(wb, herocarousel,heroSheet); 
					System.out.println("hero table is  present");
				}else{
					System.out.println("hero table is not present");
				}


				/***************************************design*************************************************/
				if(design!=null) {
					designContentMethod(wb, design,categorieSheet);
					System.out.println("design table is  present");
				}else{
					System.out.println("design table is not present");
				}

				/***************************************performance*************************************************/
				if(performance!=null) {
					performanceContentMethod(wb, performance,categorieSheet);
					System.out.println("performance table is  present");
				}else{
					System.out.println("performance table is not present");
				}


				/***************************************innovation*************************************************/
				if(innovation!=null) {
					innovationContentMethod(wb, innovation,categorieSheet);
					System.out.println("innovation table is not present");
				}else{
					System.out.println("innovation table is  present");
				}

				/***************************************technology*************************************************/
				if(technology!=null) {
					technologyContentMethod(wb, technology,categorieSheet);
					System.out.println("technology table is  present");
				}else{
					System.out.println("technology table is not present");
				}

				/***************************************models*************************************************/
				if(models!=null) {
					modelContentMethod(wb, models,modelSheet);
					System.out.println("models table is  present");
				}else{
					System.out.println("models table is not present");
				}
				/***************************************siteshare*************************************************/
				if(siteshare!=null) {
					siteShareContentMethod(wb, siteshare,siteshareSheet);
					System.out.println("siteshare table is  present");
				}else{
					System.out.println("siteshare table is not present");
				}
				
				String[] urlContent= ClassExtractorUtils.url.split("https://confluence.usfdc.corpintra.net/display");				
				System.out.println(urlContent[1]);
				urlRow = urlSheet.createRow(0);
				urlCell=urlRow.createCell(0);
				urlCell.setCellValue(urlContent[1]);
				urlCell.setCellStyle(contentStyleMethod(wb));
				urlSheet = wb.getSheetAt(4);
				//cell.setCellValue(tdContent.text());
			}

			if(ClassExtractorUtils.gallery){
				
				/***************************************Gallery Exterior*************************************************/
				if(galleryexterior!=null) {
					galleryexteriorContentMethod(wb, galleryexterior,gallerySheet);
				}else{
					System.out.println("Gallery Exterior table is not present");
				}
				/***************************************Gallery Interior*************************************************/
				if(galleryinterior!=null) {
					galleryinteriorContentMethod(wb, galleryinterior,gallerySheet);
				}else{
					System.out.println("Gallery Interio table is not present");
				}
				/***************************************Gallery Media*************************************************/
				if(gallerymedia!=null) {
					gallerymediaContentMethod(wb, gallerymedia,gallerySheet);
				}else{
					System.out.println("Gallery Media table is not present");
				}
				/***************************************Gallery Accessories*************************************************/
				if(galleryaccessories!=null) {
					galleryaccessoriesContentMethod(wb, galleryaccessories,gallerySheet);
				}else{
					System.out.println("Gallery Accessories table is not present");
				}
			}

		}catch(Exception e){
			e.printStackTrace();

		}
	}

	//Set Header Style
	public static XSSFCellStyle headerStyleMethod(XSSFWorkbook wb){

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
	public static XSSFCellStyle contentStyleMethod(XSSFWorkbook wb){
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





	public void heroCarouselContentMethod(XSSFWorkbook wb, Element herocarousel,XSSFSheet heroSheet){
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

						heroSheet = wb.getSheetAt(0);
					}
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
	public void designContentMethod(XSSFWorkbook wb, Element design,XSSFSheet categorieSheet){
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

	public void performanceContentMethod(XSSFWorkbook wb, Element performance,XSSFSheet categorieSheet){
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

	public void innovationContentMethod(XSSFWorkbook wb, Element classPage,XSSFSheet categorieSheet){
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


	public void technologyContentMethod(XSSFWorkbook wb,Element technology,XSSFSheet categorieSheet){
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

	public void modelContentMethod(XSSFWorkbook wb, Element classPage,XSSFSheet modelSheet){
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
				System.out.println(thContent.toString());
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
					System.out.println(((Element) columnContent).text());
					cell.setCellValue(((Element) columnContent).text());
					cell.setCellStyle(ContentStyle);
				}else{
					for(int j=0;j<i;j++){					
						columnContent = columnContent.nextSibling();
					}
					cell = rowHeader.createCell(1);
					System.out.println(((Element) columnContent).text());
					cell.setCellValue(((Element) columnContent).text());
					cell.setCellStyle(ContentStyle);			
				}
				modelSheet = wb.getSheetAt(2);
				for (int j = 0; j < totalModels; j++) {
					modelSheet.setColumnWidth(j, 8000);
					//sheet.autoSizeColumn(j);
				}
			}
			l++;
			rowCount++;
			System.out.println("______________________________________________________________");
		}

	}

	public void siteShareContentMethod(XSSFWorkbook wb, Element classPage,XSSFSheet siteshareSheet){
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
					siteshareSheet = wb.getSheetAt(3);
				}
				rowCount++;
				siteshareSheet = wb.getSheetAt(3);
				for (int j = 0; j < siteshareTblContentths.size(); j++) {
					siteshareSheet.setColumnWidth(j, 8000);
					//sheet.autoSizeColumn(j);
				}
			}
		}
	}
	public void galleryexteriorContentMethod(XSSFWorkbook wb, Element classPage,XSSFSheet gallerySheet){

		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);
		galleryexteriorTblcontent= galleryexterior.nextElementSibling();			
		Elements exteriorths= galleryexteriorTblcontent.select("th");
		rowCount= 0;
		count = 1;
		rowCount++;
		rowHeader = gallerySheet.createRow(0);
		//Design headers
		for (Element thContent : exteriorths) {
			// set header style
			cell = rowHeader.createCell(0);
			cell.setCellValue("Section");
			cell.setCellStyle(HeaderStyle);
			cell = rowHeader.createCell(count);
			cell.setCellValue(thContent.text());
			cell.setCellStyle(HeaderStyle);				
			count++;
			gallerySheet = wb.getSheetAt(0);
			for (int j = 0; j < exteriorths.size()+1; j++) {
				gallerySheet.setColumnWidth(j, 8000);
				//sheet.autoSizeColumn(j);
			}
		}			
		rowCount++;		
		l=0;
		rowCount=1;
		while(l<50){
			if(l==0){
				galleryexteriorTblcontent= galleryexterior.nextElementSibling();	
			}else{
				galleryexteriorTblcontent= galleryexteriorTblcontent.nextElementSibling();
			}
			if(!galleryexteriorTblcontent.tagName().contains("h1")){					
				if(!galleryexteriorTblcontent.tagName().contains("p")){						
					count =1;
					Row exteriorcontent = gallerySheet.createRow(rowCount);
					for (Element row : galleryexteriorTblcontent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");
						for(int i=0;i<=rowCount;i++)	{
							cell = exteriorcontent.createCell(0);
							cell.setCellValue("Exterior");
							cell.setCellStyle(ContentStyle);
						}
						for (Element tdContent : tds) {								
							cell = exteriorcontent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}

						gallerySheet = wb.getSheetAt(0);
					}
					rowCount++;
					l++;
					gallerySheet = wb.getSheetAt(0);
					for (int j = 0; j < exteriorths.size()+1; j++) {
						gallerySheet.setColumnWidth(j, 8000);
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


	public void galleryinteriorContentMethod(XSSFWorkbook wb, Element classPage,XSSFSheet gallerySheet){
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);		
		galleryinteriorTblcontent= galleryinterior.nextElementSibling();			
		Elements interiorths= galleryinteriorTblcontent.select("th");		
		count = 1;
		rowCount++;
		rowHeader = gallerySheet.createRow(rowCount);
		//Design headers
		for (Element thContent : interiorths) {
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
				galleryinteriorTblcontent= galleryinterior.nextElementSibling();	
			}else{
				galleryinteriorTblcontent= galleryinteriorTblcontent.nextElementSibling();
			}
			if(!galleryinteriorTblcontent.tagName().contains("h1")){					
				if(!galleryinteriorTblcontent.tagName().contains("p")){						
					count =1;
					Row interiorContent = gallerySheet.createRow(rowCount);
					for (Element row : galleryinteriorTblcontent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");
						for(int i=0;i<=rowCount;i++)	{
							cell = interiorContent.createCell(0);
							cell.setCellValue("Interior");
							cell.setCellStyle(ContentStyle);
						}
						for (Element tdContent : tds) {
							cell = interiorContent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}
						gallerySheet = wb.getSheetAt(0);
					}
					rowCount++;
					l++;
					gallerySheet = wb.getSheetAt(0);
					for (int j = 0; j < interiorths.size(); j++) {
						gallerySheet.setColumnWidth(j, 8000);
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
	public void gallerymediaContentMethod(XSSFWorkbook wb, Element classPage,XSSFSheet gallerySheet){
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);		
		gallerymediaTblcontent= gallerymedia.nextElementSibling();			
		Elements mediaths= gallerymediaTblcontent.select("th");		
		count = 1;
		rowCount++;
		rowHeader = gallerySheet.createRow(rowCount);
		//Design headers
		for (Element thContent : mediaths) {
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
		while(l<50 && gallerymediaTblcontent!=null){
			if(l==0){
				gallerymediaTblcontent= gallerymedia.nextElementSibling();	
			}else{
				while(gallerymediaTblcontent!=null){
					gallerymediaTblcontent= gallerymediaTblcontent.nextElementSibling();
				}

			}
			if(gallerymediaTblcontent!=null && !gallerymediaTblcontent.tagName().contains("h1")){					
				if(!gallerymediaTblcontent.tagName().contains("p")){						
					count =1;
					Row mediaContent = gallerySheet.createRow(rowCount);
					for (Element row : gallerymediaTblcontent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");
						for(int i=0;i<=rowCount;i++)	{
							cell = mediaContent.createCell(0);
							cell.setCellValue("Media");
							cell.setCellStyle(ContentStyle);
						}
						for (Element tdContent : tds) {
							cell = mediaContent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}
						gallerySheet = wb.getSheetAt(0);
					}
					rowCount++;
					l++;
					gallerySheet = wb.getSheetAt(0);
					for (int j = 0; j < mediaths.size(); j++) {
						gallerySheet.setColumnWidth(j, 8000);
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
	public void galleryaccessoriesContentMethod(XSSFWorkbook wb, Element classPage,XSSFSheet gallerySheet){
		XSSFCellStyle HeaderStyle = headerStyleMethod(wb);
		XSSFCellStyle ContentStyle = contentStyleMethod(wb);		
		galleryaccessoriesTblcontent= galleryaccessories.nextElementSibling();			
		Elements accessoriesths= galleryaccessoriesTblcontent.select("th");		
		count = 1;
		rowCount++;
		rowHeader = gallerySheet.createRow(rowCount);
		//Design headers
		for (Element thContent : accessoriesths) {
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
		while(l<50 && galleryaccessoriesTblcontent!=null){
			if(l==0 && galleryaccessoriesTblcontent!=null){
				galleryaccessoriesTblcontent= galleryaccessories.nextElementSibling();	
			}else{
				while(galleryaccessoriesTblcontent!=null){

					galleryaccessoriesTblcontent= galleryaccessoriesTblcontent.nextElementSibling();
				}
			}
			if(galleryaccessoriesTblcontent!=null && !galleryaccessoriesTblcontent.tagName().contains("h1")){					
				if(!galleryaccessoriesTblcontent.tagName().contains("p")){						
					count =1;
					Row accessoriesContent = gallerySheet.createRow(rowCount);
					for (Element row : galleryaccessoriesTblcontent.select("td")) {
						Elements tds = row.select("td:not([rowspan])");
						for(int i=0;i<=rowCount;i++)	{
							cell = accessoriesContent.createCell(0);
							cell.setCellValue("Accessories");
							cell.setCellStyle(ContentStyle);
						}
						for (Element tdContent : tds) {
							cell = accessoriesContent.createCell(count);
							cell.setCellValue(tdContent.text());
							cell.setCellStyle(ContentStyle);
							count++;							
						}
						gallerySheet = wb.getSheetAt(0);
					}
					rowCount++;
					l++;
					gallerySheet = wb.getSheetAt(0);
					for (int j = 0; j < accessoriesths.size(); j++) {
						gallerySheet.setColumnWidth(j, 8000);
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

}




