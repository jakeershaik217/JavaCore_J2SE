package com.syntel.classextractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputReader {


	public static void main(String[] args) {
		try {
			FileInputStream inputFile = new FileInputStream(new File("Input/ConfluenceToExcelInputs.xlsx"));
			Workbook wb = new XSSFWorkbook(inputFile);
			Sheet sheet = wb.getSheetAt(0);
			int i=0;
			while(true){
				Row row = sheet.getRow(i);
				if(row != null){
					Cell cell = row.getCell(0);
					String className = cell.toString();
					System.out.println(className);
					cell = row.getCell(1);
					//ClassExtractorUtils.setUrl(cell.toString());
					//System.out.println(URL);
					cell = row.getCell(2);
					String fileName = cell.toString();
					System.out.println(fileName);
					ClassExtractor.OUTPUT_FILE = "output/" + fileName + ".xlsx";
					//ClassExtractor.mainMethod();					
					inputFile.close();
					ClassContentExtractor classcontentextractor = null;
					i++;
				} 
				
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
			}
}
