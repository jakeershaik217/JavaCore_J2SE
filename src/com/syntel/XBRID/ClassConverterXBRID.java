package com.syntel.XBRID;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ClassConverterXBRID {

	private static final String FILE_NAME = "C-class-Coupe"; 
	private static final String OUTPUT_FILE = "output/"+FILE_NAME+".xml";
	private static final String INPUT_FILE = "input/"+FILE_NAME+".xlsx";
	private static final Boolean gallery = false;
	static Workbook  wb = null  ;
	static Sheet requestedSheet = null;
	private static StringBuilder constXmlKeyValues = new StringBuilder();
	static ArrayList<String> headercontent =new ArrayList<String>();
	static ArrayList content = new ArrayList();


	public static boolean isRowEmpty(Row row) {
		if(row != null){
			for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
				Cell cell = row.getCell(c);
				if (row.getCell(c) != null && row.getCell(c).getCellType() != Cell.CELL_TYPE_BLANK ){
					switch(cell.getCellType()){
					case Cell.CELL_TYPE_BOOLEAN:
						return false;
					case Cell.CELL_TYPE_STRING:
						if(!cell.getStringCellValue().trim().equalsIgnoreCase("") && cell.getStringCellValue() != null){
							return false;
						}else{
							return true;
						}
					case Cell.CELL_TYPE_NUMERIC:
						return false;
					}
				}else{
					return true;
				}
			}
		}else{
			return true;
		}
		return true;
	}

	public static void heroSheet(int rowItr,int colItr,int sheets){
		System.out.println("<!-- hero -->");
		System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNamehero"+"</key>"+"\n"+"<value>"+"Hero"+"</value>"+"\n"+"</entry>");
		constXmlKeyValues.append(System.getProperty("line.separator"));
		constXmlKeyValues.append("<!-- hero -->");
		constXmlKeyValues.append(System.getProperty("line.separator"));
		constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>sectionNamehero"+"</key>"+"\n"+"<value>"+"Hero"+"</value>"+"\n"+"</entry>");
		constXmlKeyValues.append(System.getProperty("line.separator"));
		for(int i=0;i<=colItr-1;i++){
			Cell header=requestedSheet.getRow(0).getCell(i);
			if(header.getStringCellValue().trim().equals(("Image / Filename").trim())){
				headercontent.add("ImgFile");
			}else{
				headercontent.add(header.getStringCellValue().toLowerCase().replaceAll(" ", ""));
			}
		}				

		for(int i=1;i<rowItr;i++){
			for(int j=0;j<=colItr-1;j++){
				Cell tableContent=requestedSheet.getRow(i).getCell(j);	
				if(tableContent != null){				
					/*switch (tableContent.getCellType()) {
					case Cell.CELL_TYPE_BLANK:
						//System.out.println("2");
						break;
					case Cell.CELL_TYPE_STRING:
						//System.out.println(tableContent.getStringCellValue().toString()+"3");
						//content.add(tableContent.getStringCellValue());		
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						//System.out.println(tableContent.getBooleanCellValue()+"4");
						//content.add(tableContent.getBooleanCellValue());	
						break;
					case Cell.CELL_TYPE_NUMERIC:
						//System.out.println(tableContent.getNumericCellValue()+"5");
						//content.add(tableContent.getNumericCellValue());	
						break;
					}*/
					content.add(tableContent);	
				}else{
					content.add("");
				}
			}
		}						
		int i=0,j=0,k=1;			
		while(i < headercontent.size()  || j<content.size() ){					
			if(i  < headercontent.size()  ){
				if(content.get(j).toString() == null || content.get(j).toString() == " " || content.get(j) == null || content.get(j) == " "){
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
						//notepad appending
						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;			
				}else{	
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;				
				}
			}else{
				i=0;
				k++;
				if( content.get(j) == null || content.get(j) == " "){
					if(i==0){						
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;					
				}else{	
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");	
						//notepad appending
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"hero"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}						
					i++;
					j++;					
				}
			}
		}		
	}

	public static void categorySheet(int rowItr,int colItr,int sheets){
		Cell section = null;
		Row row=null;
		ArrayList<Cell> desigContent = null, performanceContent= null,technologyContent= null,innovationContent= null;
		Boolean design = false,performance = false,technology = false,innovation = false;

		System.out.println("<!-- category -->");
		//header extraction
		for(int i=1;i<=colItr-1;i++){
			Cell header=requestedSheet.getRow(0).getCell(i);	
			if(header.getStringCellValue().trim().equals(("Image / Filename").trim())){
				headercontent.add("link");
			}else{
				headercontent.add(header.getStringCellValue().toLowerCase().replaceAll(" ", ""));
			}

		}	

		//category sheet content analysis
		for(int j=1;j<=rowItr+1;j++){				
			row=requestedSheet.getRow(j);
			if(!isRowEmpty(row)){
				section = requestedSheet.getRow(j).getCell(0);	
				if(section.getCellType() == Cell.CELL_TYPE_STRING || section.getCellType()==Cell.CELL_TYPE_BOOLEAN ||section.getCellType()==Cell.CELL_TYPE_BLANK || section!=null){
					if (section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Design")) {
						//System.out.println("Design is present");
						desigContent = new ArrayList();
						design=true;		
					}else if(section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Performance")){
						//System.out.println("Performance is present");
						performanceContent = new ArrayList();
						performance=true;
					}else if(section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Technology")){
						//System.out.println("Technology is present");
						technologyContent = new ArrayList();
						technology=true;
					}else if(section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Innovation")){
						//System.out.println("Innovation is present");
						innovationContent= new ArrayList();
						innovation=true;
					}
				}				
			}else{
				continue;
			}			
		}

		//design content extraction
		if(design){	
			System.out.println("<!-- design -->");
			System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNamedesign"+"</key>"+"\n"+"<value>"+"Design"+"</value>"+"\n"+"</entry>");

			//notepad appending
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<!-- design -->");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<entry>"+"\n"+"<key>sectionNamedesign"+"</key>"+"\n"+"<value>"+"Design"+"</value>"+"\n"+"</entry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			System.out.println("");
			for(int j=1;j<=rowItr+1;j++){				
				row=requestedSheet.getRow(j);
				if(!isRowEmpty(row)){
					section = requestedSheet.getRow(j).getCell(0);	
					if(section.getCellType() == Cell.CELL_TYPE_STRING || section.getCellType()==Cell.CELL_TYPE_BOOLEAN ||section.getCellType()==Cell.CELL_TYPE_BLANK || section!=null){
						if (section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Design")) {
							for(int i=1;i<=colItr-1;i++){
								//System.out.println(row.getCell(i));
								desigContent.add(row.getCell(i));
							}//System.out.println("******************************************************");
						}
					}

				}
			}
			//design xml construction
			int i=0,j=0,k=1;			
			while(i < headercontent.size()  || j<desigContent.size()){					
				if(i  < headercontent.size()  ){
					if(desigContent.get(j).toString() == null || desigContent.get(j).toString() == " " || desigContent.get(j) == null || desigContent.get(j).toString() == " "){
						//System.out.println("\n"+"<entry>"+"\n"+"<key>"+wb.getSheetName(sheets)+"design"+headercontent.get(i)+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							//notepad appending
							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));

						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							//notepad appending
							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}

						i++;
						j++;			
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+desigContent.get(j)+"</value>"+"\n"+"</entry>");	
							//notepad appending
							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+desigContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+desigContent.get(j)+"</value>"+"\n"+"</entry>");
							//notepad appending
							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+desigContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}

						i++;
						j++;				
					}
				}else{
					i=0;
					k++;
					if( desigContent.get(j) == null || desigContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							//notepad appending
							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							//notepad appending
							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}

						i++;
						j++;					
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+desigContent.get(j)+"</value>"+"\n"+"</entry>");
							//notepad appending
							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+desigContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+desigContent.get(j)+"</value>"+"\n"+"</entry>");
							//notepad appending
							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"design"+k+"</key>"+"\n"+"<value>"+desigContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}

						i++;
						j++;					
					}
				}
			}
		}else{
			System.out.println("design content is not available");
		}

		System.out.println("_______________________________________________________________________________________________");

		//performance content extraction
		if(performance){	
			System.out.println("<!-- performance -->");
			System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNameperformance"+"</key>"+"\n"+"<value>"+"Performance"+"</value>"+"\n"+"</entry>");

			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<!-- performance -->");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>sectionNameperformance"+"</key>"+"\n"+"<value>"+"Performance"+"</value>"+"\n"+"</entry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));

			for(int p=1;p<=rowItr+1;p++){				
				row=requestedSheet.getRow(p);
				if(!isRowEmpty(row)){
					section = requestedSheet.getRow(p).getCell(0);	
					if(section.getCellType() == Cell.CELL_TYPE_STRING || section.getCellType()==Cell.CELL_TYPE_BOOLEAN ||section.getCellType()==Cell.CELL_TYPE_BLANK || section!=null){
						if (section.getRichStringCellValue().getString().trim().equalsIgnoreCase("performance")) {
							for(int pc=1;pc<=colItr-1;pc++){
								//System.out.println(row.getCell(pc));
								performanceContent.add(row.getCell(pc));
							}//System.out.println("******************************************************");
						}
					}

				}
			}
			//performance xml construction
			int i=0,j=0,k=1;			
			while(i < headercontent.size()  || j<performanceContent.size()){					
				if(i  < headercontent.size()  ){
					if(performanceContent.get(j).toString() == null || performanceContent.get(j).toString() == " " || performanceContent.get(j) == null || performanceContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;			
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+performanceContent.get(j)+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+performanceContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+performanceContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+performanceContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;				
					}
				}else{
					i=0;
					k++;
					if(performanceContent.get(j) == null || performanceContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+performanceContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+performanceContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+performanceContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"performance"+k+"</key>"+"\n"+"<value>"+performanceContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}
				}
			}	
		}else{
			System.out.println("performance content is not available");
		}


		System.out.println("_______________________________________________________________________________________________");
		//Technology content extraction
		if(technology){		
			System.out.println("<!-- Technology -->");
			System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNametechnology"+"</key>"+"\n"+"<value>"+"Technology"+"</value>"+"\n"+"</entry>");

			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<!-- Technology -->");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>sectionNametechnology"+"</key>"+"\n"+"<value>"+"Technology"+"</value>"+"\n"+"</entry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));

			for(int t=1;t<=rowItr+1;t++){				
				row=requestedSheet.getRow(t);
				if(!isRowEmpty(row)){
					section = requestedSheet.getRow(t).getCell(0);	
					if(section.getCellType() == Cell.CELL_TYPE_STRING || section.getCellType()==Cell.CELL_TYPE_BOOLEAN ||section.getCellType()==Cell.CELL_TYPE_BLANK || section!=null){
						if (section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Technology")) {
							for(int tc=1;tc<=colItr-1;tc++){
								//System.out.println(row.getCell(tc));
								technologyContent.add(row.getCell(tc));
							}//System.out.println("******************************************************");
						}
					}

				}
			}
			//Technology xml construction
			int i=0,j=0,k=1;		
			while(i < headercontent.size()  || j<technologyContent.size()){					
				if(i  < headercontent.size()  ){
					if(technologyContent.get(j).toString() == null || technologyContent.get(j).toString() == " " || technologyContent.get(j) == null || technologyContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;			
					}else{
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+technologyContent.get(j)+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+technologyContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+technologyContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+technologyContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;				
					}
				}else{
					i=0;
					k++;
					if( technologyContent.get(j) == null || technologyContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+technologyContent.get(j)+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+technologyContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+technologyContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"technology"+k+"</key>"+"\n"+"<value>"+technologyContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}
				}
			}
		}else{
			System.out.println("Technology content is not available");
		}		



		System.out.println("_______________________________________________________________________________________________");
		//Innovation content extraction
		if(innovation){		
			System.out.println("<!-- innovation -->");
			System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNameInnovation"+"</key>"+"\n"+"<value>"+"Innovation"+"</value>"+"\n"+"</entry>");

			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<!-- innovation -->");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>sectionNameInnovation"+"</key>"+"\n"+"<value>"+"Innovation"+"</value>"+"\n"+"</entry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));

			for(int in=1;in<=rowItr+1;in++){				
				row=requestedSheet.getRow(in);
				if(!isRowEmpty(row)){
					section = requestedSheet.getRow(in).getCell(0);	
					if(section.getCellType() == Cell.CELL_TYPE_STRING || section.getCellType()==Cell.CELL_TYPE_BOOLEAN ||section.getCellType()==Cell.CELL_TYPE_BLANK || section!=null){
						if (section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Innovation")) {
							for(int ic=1;ic<=colItr-1;ic++){
								//System.out.println(row.getCell(ic));
								innovationContent.add(row.getCell(ic));
							}//System.out.println("******************************************************");
						}
					}

				}
			}
			//Innovation xml construction
			int i=0,j=0,k=1;			
			while(i < headercontent.size()  || j<innovationContent.size()){					
				if(i  < headercontent.size()  ){
					if(innovationContent.get(j).toString() == null || innovationContent.get(j).toString() == " " || innovationContent.get(j) == null || innovationContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}							
						i++;
						j++;			
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+innovationContent.get(j)+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+innovationContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+innovationContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+innovationContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}					
						i++;
						j++;				
					}
				}else{
					i=0;
					k++;
					if( innovationContent.get(j) == null || innovationContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}else{		
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+innovationContent.get(j)+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+innovationContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+innovationContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"innovation"+k+"</key>"+"\n"+"<value>"+innovationContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}
				}
			}	
		}else{
			System.out.println("Innovation content is not available");
		}
	}
	private static void amgSheet(int rowItr, int colItr, int sheets) {
		System.out.println("<!-- AMG -->");
		System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNamehero"+"</key>"+"\n"+"<value>"+"AMG"+"</value>"+"\n"+"</entry>");
		constXmlKeyValues.append(System.getProperty("line.separator"));
		constXmlKeyValues.append("<!-- AMG -->");
		constXmlKeyValues.append(System.getProperty("line.separator"));
		constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>sectionNamehero"+"</key>"+"\n"+"<value>"+"AMG"+"</value>"+"\n"+"</entry>");
		constXmlKeyValues.append(System.getProperty("line.separator"));
		for(int i=0;i<=colItr-1;i++){
			Cell header=requestedSheet.getRow(0).getCell(i);
			if(header.getStringCellValue().trim().equals(("Image / Filename").trim())){
				headercontent.add("link");
			}else{
				headercontent.add(header.getStringCellValue().toLowerCase().replaceAll(" ", ""));
			}
		}				

		for(int i=1;i<rowItr;i++){
			for(int j=0;j<=colItr-1;j++){
				Cell tableContent=requestedSheet.getRow(i).getCell(j);	
				if(tableContent != null){				
					/*switch (tableContent.getCellType()) {
					case Cell.CELL_TYPE_BLANK:
						//System.out.println("2");
						break;
					case Cell.CELL_TYPE_STRING:
						//System.out.println(tableContent.getStringCellValue().toString()+"3");
						//content.add(tableContent.getStringCellValue());		
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						//System.out.println(tableContent.getBooleanCellValue()+"4");
						//content.add(tableContent.getBooleanCellValue());	
						break;
					case Cell.CELL_TYPE_NUMERIC:
						//System.out.println(tableContent.getNumericCellValue()+"5");
						//content.add(tableContent.getNumericCellValue());	
						break;
					}*/
					content.add(tableContent);	
				}else{
					content.add("");
				}
			}
		}						
		int i=0,j=0,k=1;			
		while(i < headercontent.size()  || j<content.size() ){					
			if(i  < headercontent.size()  ){
				if(content.get(j).toString() == null || content.get(j).toString() == " " || content.get(j) == null || content.get(j) == " "){
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
						//notepad appending
						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;			
				}else{	
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;				
				}
			}else{
				i=0;
				k++;
				if( content.get(j) == null || content.get(j) == " "){
					if(i==0){						
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;					
				}else{	
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						//notepad appending
						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");	
						//notepad appending
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"AMG"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}						
					i++;
					j++;					
				}
			}
		}
		
	}
	private static void modelSheet(int rowItr, int colItr, int sheets) {
		System.out.println("<!-- model -->");
		System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNameModel"+"</key>"+"\n"+"<value>"+"Model"+"</value>"+"\n"+"</entry>");

		constXmlKeyValues.append(System.getProperty("line.separator"));
		constXmlKeyValues.append("<!-- model -->");
		constXmlKeyValues.append(System.getProperty("line.separator"));
		constXmlKeyValues.append(System.getProperty("line.separator"));
		constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>sectionNameModel"+"</key>"+"\n"+"<value>"+"Model"+"</value>"+"\n"+"</entry>");
		constXmlKeyValues.append(System.getProperty("line.separator"));

		Row row=null;
		for(int i=0;i<=rowItr-1;i++){
			row=requestedSheet.getRow(i);
			if(!isRowEmpty(row)){
				Cell header=row.getCell(0);	
				if(header.getStringCellValue().trim().equals(("Image / Filename").trim())){
					headercontent.add("link");
				}else{
					headercontent.add(header.getStringCellValue().toLowerCase().replaceAll(" ", ""));
				}				
			}else{
				break;
			}			
		}
		int contentSize=(rowItr/headercontent.size())*(headercontent.size()+1);		
		//content extraction
		for(int i=0;i<=contentSize;i++){	
			row=requestedSheet.getRow(i);			
			if(!isRowEmpty(row)){
				Cell tableContent=row.getCell(1);
				content.add(tableContent);
			}else{				
				continue;
			}
		}

		int i=0,j=0,k=1;			
		while(i < headercontent.size() || j<content.size()){	
			//if(!isRowEmpty(row)){
			if(i  < headercontent.size()  ){
				if( content.get(j).toString() == " " || content.get(j) == null ){
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;			
				}else{
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");	

						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");		
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");

						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;				
				}
			}else{
				i=0;
				k++;
				if( content.get(j) == null || content.get(j).toString() == " "){
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");			
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;					
				}else{	
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");	

						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");			
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");

						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"model"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;					
				}
			}
		}/*else{
				continue;
			}*/

	}	
	
	
	private static void siteShareSheet(int rowItr, int colItr, int sheets) {
		System.out.println("<!-- Site Share -->");	
		System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNameSiteShare"+"</key>"+"\n"+"<value>"+"SiteShare"+"</value>"+"\n"+"</entry>");

		constXmlKeyValues.append(System.getProperty("line.separator"));
		constXmlKeyValues.append("<!-- Site Share -->");	
		constXmlKeyValues.append(System.getProperty("line.separator"));
		constXmlKeyValues.append(System.getProperty("line.separator"));
		constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>sectionNameSiteShare"+"</key>"+"\n"+"<value>"+"SiteShare"+"</value>"+"\n"+"</entry>");
		constXmlKeyValues.append(System.getProperty("line.separator"));

		Row row=null;
		//header extraction
		for(int i=0;i<=colItr-1;i++){
			Cell header=requestedSheet.getRow(0).getCell(i);	
			if(header.getStringCellValue().trim().equals(("Image / Filename").trim())){
				headercontent.add("link");
			}else{
				headercontent.add(header.getStringCellValue().toLowerCase().replaceAll(" ", ""));
			}			
		}			
		for(int i=1;i<rowItr;i++){
			for(int j=0;j<=colItr-1;j++){
				row=requestedSheet.getRow(i);
				if(!isRowEmpty(row)){	
					Cell tableContent=requestedSheet.getRow(i).getCell(j);						
					content.add(tableContent);	
					/*switch (tableContent.getCellType()) {
					case Cell.CELL_TYPE_BLANK:
						//System.out.println("2");
						break;
					case Cell.CELL_TYPE_STRING:
						//System.out.println(tableContent.getStringCellValue().toString()+"3");
						//content.add(tableContent.getStringCellValue());		
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						//System.out.println(tableContent.getBooleanCellValue()+"4");
						//content.add(tableContent.getBooleanCellValue());	
						break;
					case Cell.CELL_TYPE_NUMERIC:
						//System.out.println(tableContent.getNumericCellValue()+"5");
						//content.add(tableContent.getNumericCellValue());	
						break;
					}*/

				}else{
					content.add(" ");
				}
			}
		}
		int i=0,j=0,k=1;		
		while(i < headercontent.size()  || j<content.size()){					
			if(i  < headercontent.size()  ){
				if(content.get(j).toString() == null || content.get(j).toString() == " " || content.get(j) == null || content.get(j).toString() == " "){
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");		
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;			
				}else{	
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");	

						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");			
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");

						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;				
				}
			}else{
				i=0;
				k++;
				if( content.get(j) == null || content.get(j).toString() == " "){
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");			
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}				
					i++;
					j++;					
				}else{	
					if(i==0){
						System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");	

						constXmlKeyValues.append(System.getProperty("line.separator"));
						constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");				
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}else{
						System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");

						constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"siteshare"+k+"</key>"+"\n"+"<value>"+content.get(j)+"</value>"+"\n"+"</entry>");
						constXmlKeyValues.append(System.getProperty("line.separator"));
					}					
					i++;
					j++;					
				}
			}
		}	

	}

	private static void gallerySheet(int rowItr, int colItr, int sheets) {
		Cell section = null;
		Row row=null;
		ArrayList<Cell> exteriorContent = null, interiorContent= null,accessoriesContent= null,mediaContent= null;
		Boolean exterior = false,interior = false,accessories = false,media = false;

		System.out.println("<!-- Gallery -->");
		//header extraction
		for(int i=1;i<=colItr-1;i++){
			Cell header=requestedSheet.getRow(0).getCell(i);	
			if(header.getStringCellValue().trim().equals(("Image / Filename").trim())){
				headercontent.add("ImgFile");
			}else{
				headercontent.add(header.getStringCellValue().toLowerCase().replaceAll(" ", ""));
			}

		}	

		//category sheet content analysis
		for(int j=1;j<=rowItr+2;j++){				
			row=requestedSheet.getRow(j);
			if(!isRowEmpty(row)){
				section = requestedSheet.getRow(j).getCell(0);	
				if(section.getCellType() == Cell.CELL_TYPE_STRING || section.getCellType()==Cell.CELL_TYPE_BOOLEAN ||section.getCellType()==Cell.CELL_TYPE_BLANK || section!=null){
					if (section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Exterior")) {
						//System.out.println("Design is present");
						exteriorContent = new ArrayList();
						exterior=true;		
					}else if(section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Interior")){
						//System.out.println("Performance is present");
						interiorContent = new ArrayList();
						interior=true;
					}else if(section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Media")){
						//System.out.println("Innovation is present");
						mediaContent= new ArrayList();
						media=true;
					}else if(section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Accessories")){
						System.out.println("Accessories is present");
						accessoriesContent = new ArrayList();
						accessories=true;
					}
				}				
			}else{
				continue;
			}			
		}

		//design content extraction
		if(exterior){	
			System.out.println("<!-- exterior -->");
			System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNameexterior"+"</key>"+"\n"+"<value>"+"Gallery exterior"+"</value>"+"\n"+"</entry>");

			//notepad appending
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<!-- exterior -->");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<entry>"+"\n"+"<key>sectionNameexterior"+"</key>"+"\n"+"<value>"+"Gallery exterior"+"</value>"+"\n"+"</entry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			System.out.println("");
			for(int j=1;j<=rowItr+1;j++){				
				row=requestedSheet.getRow(j);
				if(!isRowEmpty(row)){
					section = requestedSheet.getRow(j).getCell(0);	
					if(section.getCellType() == Cell.CELL_TYPE_STRING || section.getCellType()==Cell.CELL_TYPE_BOOLEAN ||section.getCellType()==Cell.CELL_TYPE_BLANK || section!=null){
						if (section.getRichStringCellValue().getString().trim().equalsIgnoreCase("exterior")) {
							for(int i=1;i<=colItr-1;i++){
								//System.out.println(row.getCell(i));
								exteriorContent.add(row.getCell(i));
							}//System.out.println("******************************************************");
						}
					}

				}
			}
			//design xml construction
			int i=0,j=0,k=1;			
			while(i < headercontent.size()  || j<exteriorContent.size()){					
				if(i  < headercontent.size()  ){
					if(exteriorContent.get(j).toString() == null || exteriorContent.get(j).toString() == " " || exteriorContent.get(j) == null || exteriorContent.get(j).toString() == " "){
						//System.out.println("\n"+"<entry>"+"\n"+"<key>"+wb.getSheetName(sheets)+"design"+headercontent.get(i)+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							//notepad appending
							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));

						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							//notepad appending
							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}

						i++;
						j++;			
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+exteriorContent.get(j)+"</value>"+"\n"+"</entry>");	
							//notepad appending
							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+exteriorContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+exteriorContent.get(j)+"</value>"+"\n"+"</entry>");
							//notepad appending
							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+exteriorContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}

						i++;
						j++;				
					}
				}else{
					i=0;
					k++;
					if( exteriorContent.get(j) == null || exteriorContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							//notepad appending
							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							//notepad appending
							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}

						i++;
						j++;					
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+exteriorContent.get(j)+"</value>"+"\n"+"</entry>");
							//notepad appending
							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+exteriorContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+exteriorContent.get(j)+"</value>"+"\n"+"</entry>");
							//notepad appending
							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"exterior"+k+"</key>"+"\n"+"<value>"+exteriorContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}

						i++;
						j++;					
					}
				}
			}
		}else{
			System.out.println("exterior content is not available");
		}

		System.out.println("_______________________________________________________________________________________________");

		//performance content extraction
		if(interior){	
			System.out.println("<!-- interior -->");
			System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNameinterior"+"</key>"+"\n"+"<value>"+"Gallery interior"+"</value>"+"\n"+"</entry>");

			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<!-- interior -->");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>sectionNameinterior"+"</key>"+"\n"+"<value>"+"interior"+"</value>"+"\n"+"</entry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));

			for(int p=1;p<=rowItr+1;p++){				
				row=requestedSheet.getRow(p);
				if(!isRowEmpty(row)){
					section = requestedSheet.getRow(p).getCell(0);	
					if(section.getCellType() == Cell.CELL_TYPE_STRING || section.getCellType()==Cell.CELL_TYPE_BOOLEAN ||section.getCellType()==Cell.CELL_TYPE_BLANK || section!=null){
						if (section.getRichStringCellValue().getString().trim().equalsIgnoreCase("interior")) {
							for(int pc=1;pc<=colItr-1;pc++){
								//System.out.println(row.getCell(pc));
								interiorContent.add(row.getCell(pc));
							}//System.out.println("******************************************************");
						}
					}

				}
			}
			//performance xml construction
			int i=0,j=0,k=1;			
			while(i < headercontent.size()  || j<interiorContent.size()){					
				if(i  < headercontent.size()  ){
					if(interiorContent.get(j).toString() == null || interiorContent.get(j).toString() == " " || interiorContent.get(j) == null || interiorContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;			
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+interiorContent.get(j)+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+interiorContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+interiorContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+interiorContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;				
					}
				}else{
					i=0;
					k++;
					if(interiorContent.get(j) == null || interiorContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+interiorContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+interiorContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+interiorContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"interior"+k+"</key>"+"\n"+"<value>"+interiorContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}
				}
			}	
		}else{
			System.out.println("interior content is not available");
		}


		

		System.out.println("_______________________________________________________________________________________________");
		//Innovation content extraction
		if(media){		
			System.out.println("<!-- media -->");
			System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNamemedia"+"</key>"+"\n"+"<value>"+"Gallery media"+"</value>"+"\n"+"</entry>");

			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<!-- media -->");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>sectionNamemedia"+"</key>"+"\n"+"<value>"+"media"+"</value>"+"\n"+"</entry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));

			for(int in=1;in<=rowItr+1;in++){				
				row=requestedSheet.getRow(in);
				if(!isRowEmpty(row)){
					section = requestedSheet.getRow(in).getCell(0);	
					if(section.getCellType() == Cell.CELL_TYPE_STRING || section.getCellType()==Cell.CELL_TYPE_BOOLEAN ||section.getCellType()==Cell.CELL_TYPE_BLANK || section!=null){
						if (section.getRichStringCellValue().getString().trim().equalsIgnoreCase("media")) {
							for(int ic=1;ic<=colItr-1;ic++){
								//System.out.println(row.getCell(ic));
								mediaContent.add(row.getCell(ic));
							}//System.out.println("******************************************************");
						}
					}

				}
			}
			//Innovation xml construction
			int i=0,j=0,k=1;			
			while(i < headercontent.size()  || j<mediaContent.size()){					
				if(i  < headercontent.size()  ){
					if(mediaContent.get(j).toString() == null || mediaContent.get(j).toString() == " " || mediaContent.get(j) == null || mediaContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}							
						i++;
						j++;			
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+mediaContent.get(j)+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+mediaContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+mediaContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+mediaContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}					
						i++;
						j++;				
					}
				}else{
					i=0;
					k++;
					if( mediaContent.get(j) == null || mediaContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}else{		
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+mediaContent.get(j)+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+mediaContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+mediaContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"media"+k+"</key>"+"\n"+"<value>"+mediaContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}
				}
			}	
		}else{
			System.out.println("media content is not available");
		}
		System.out.println("_______________________________________________________________________________________________");
		//Technology content extraction
		if(accessories){		
			System.out.println("<!-- accessories -->");
			System.out.println("\n"+"<entry>"+"\n"+"<key>sectionNameaccessories"+"</key>"+"\n"+"<value>"+"Gallery accessories"+"</value>"+"\n"+"</entry>");

			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<!-- accessories -->");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>sectionNameaccessories"+"</key>"+"\n"+"<value>"+"accessories"+"</value>"+"\n"+"</entry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));

			for(int t=1;t<=rowItr+2;t++){				
				row=requestedSheet.getRow(t);
				if(!isRowEmpty(row)){
					section = requestedSheet.getRow(t).getCell(0);	
					if(section.getCellType() == Cell.CELL_TYPE_STRING || section.getCellType()==Cell.CELL_TYPE_BOOLEAN ||section.getCellType()==Cell.CELL_TYPE_BLANK || section!=null){
						if (section.getRichStringCellValue().getString().trim().equalsIgnoreCase("Accessories")) {
							for(int tc=1;tc<=colItr-1;tc++){								
								//System.out.println(row.getCell(tc));
								accessoriesContent.add(row.getCell(tc));
							}//System.out.println("******************************************************");
						}
					}

				}
			}
			
			
			//Technology xml construction
			int i=0,j=0,k=1;		
			while(i < headercontent.size()  || j<accessoriesContent.size()){					
				if(i  < headercontent.size()  ){
					if(accessoriesContent.get(j).toString() == null || accessoriesContent.get(j).toString() == " " || accessoriesContent.get(j) == null || accessoriesContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;			
					}else{
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+accessoriesContent.get(j)+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+accessoriesContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+accessoriesContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+accessoriesContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;				
					}
				}else{
					i=0;
					k++;
					if( accessoriesContent.get(j) == null || accessoriesContent.get(j).toString() == " "){
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+""+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}else{	
						if(i==0){
							System.out.println("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+accessoriesContent.get(j)+"</value>"+"\n"+"</entry>");	

							constXmlKeyValues.append(System.getProperty("line.separator"));
							constXmlKeyValues.append("\n"+"<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+accessoriesContent.get(j)+"</value>"+"\n"+"</entry>");	
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}else{
							System.out.println("<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+accessoriesContent.get(j)+"</value>"+"\n"+"</entry>");

							constXmlKeyValues.append("<entry>"+"\n"+"<key>"+headercontent.get(i)+"accessories"+k+"</key>"+"\n"+"<value>"+accessoriesContent.get(j)+"</value>"+"\n"+"</entry>");
							constXmlKeyValues.append(System.getProperty("line.separator"));
						}						
						i++;
						j++;					
					}
				}
			}
		}else{
			System.out.println("accessories content is not available");
		}		


	}
	

	public static void main(String[] args) throws ClassNotFoundException {

		try {
			BufferedWriter txtFile = null;
			FileInputStream inputFile = new FileInputStream(new File(INPUT_FILE));
			wb = new XSSFWorkbook(inputFile);
			int sheetCount=wb.getNumberOfSheets();


			System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");	
			System.out.println("<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">");	
			System.out.println("<TestData>");
			System.out.println("<TestData>");
			System.out.println("<entry>");
			System.out.println("<key>class name</key>");
			System.out.println("<value>");
			System.out.println("<testSet>");
			System.out.println("<entry>");
			System.out.println("<key>class name</key>");
			System.out.println("<value>");
			System.out.println("<testDataEntry>");

	
			constXmlKeyValues.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>");
			
			//constXmlKeyValues.append("<!DOCTYPE properties SYSTEM \"http://java.sun.com/dtd/properties.dtd\">");	
			constXmlKeyValues.append(System.getProperty("line.separator"));	
			constXmlKeyValues.append("<TestData>");	
			constXmlKeyValues.append(System.getProperty("line.separator"));	
			constXmlKeyValues.append("<testdata>");	
			constXmlKeyValues.append(System.getProperty("line.separator"));	
			constXmlKeyValues.append("<entry>");	
			constXmlKeyValues.append(System.getProperty("line.separator"));	
			constXmlKeyValues.append("<key>class name</key>");	
			constXmlKeyValues.append(System.getProperty("line.separator"));	
			constXmlKeyValues.append("<value>");	
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<testSet>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<entry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<key>class name</key>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<value>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("<testDataEntry>");		
			constXmlKeyValues.append(System.getProperty("line.separator"));


			if(!gallery){
				for(int sheets=0;sheets<=sheetCount-1;sheets++){					
					requestedSheet = wb.getSheet(wb.getSheetName(sheets));
					int rowItr = requestedSheet.getPhysicalNumberOfRows();		//System.out.println(rowItr);
					int colItr = requestedSheet.getRow(0).getLastCellNum();		//System.out.println(colItr);

					//Hero sheet conversion
					if(wb.getSheetName(sheets).trim().equalsIgnoreCase("hero")){					
						System.out.println("Hero sheet is present");	
						heroSheet(rowItr,colItr,sheets);
						headercontent.clear();
						content.clear();
						continue;
						//Categories sheet conversion	
					}else if(wb.getSheetName(sheets).trim().equalsIgnoreCase("Categories")){								
						System.out.println("Categories sheet is present");					
						categorySheet(rowItr,colItr,sheets);
						headercontent.clear();
						continue;
					}else if(wb.getSheetName(sheets).trim().equalsIgnoreCase("AMG")){
						System.out.println("Categories sheet is present");					
						amgSheet(rowItr,colItr,sheets);
						headercontent.clear();
						content.clear();
						continue;
					}else if(wb.getSheetName(sheets).trim().equalsIgnoreCase("Model")){								
						System.out.println("Model sheet is present");					
						modelSheet(rowItr,colItr,sheets);
						headercontent.clear();
						content.clear();
						continue;
					}else if(wb.getSheetName(sheets).trim().equalsIgnoreCase("Site Share")){								
						System.out.println("Site Share sheet is present");						
						siteShareSheet(rowItr,colItr,sheets);
						headercontent.clear();
						content.clear();
						continue;
					}					
				}
			}else{
				for(int sheets=0;sheets<=sheetCount-1;sheets++){					
					requestedSheet = wb.getSheet(wb.getSheetName(sheets));
					int rowItr = requestedSheet.getPhysicalNumberOfRows();		//System.out.println(rowItr);
					int colItr = requestedSheet.getRow(0).getLastCellNum();
					
					//Hero sheet conversion
					if(wb.getSheetName(sheets).trim().equalsIgnoreCase("Gallery")){					
						System.out.println("Gallery sheet is present");	
						gallerySheet(rowItr,colItr,sheets);
						headercontent.clear();
						content.clear();
						continue;
						//Categories sheet conversion	
					}
					
					
					
				}
			}





	
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("</testDataEntry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("</value>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("</entry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("</testSet>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("</value>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("</entry>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("</testdata>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			constXmlKeyValues.append("</TestData>");
			constXmlKeyValues.append(System.getProperty("line.separator"));
			


			txtFile = new BufferedWriter(new FileWriter(OUTPUT_FILE));
			txtFile.write(constXmlKeyValues.toString());
			txtFile.close();   

			inputFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NoClassDefFoundError e){
			e.printStackTrace();
			System.out.println(e);
		}catch(IllegalArgumentException e){
			e.printStackTrace();
			System.out.println(e);
		}catch(NullPointerException e){
			e.printStackTrace();
			System.out.println(e);
		}catch(IllegalStateException e){
			e.printStackTrace();
			System.out.println(e);
		}

		System.out.println("Done");



	}

	


	
}
