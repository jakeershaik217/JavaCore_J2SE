package com.syntel.classextractor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.syntel.byoextractor.BYOExtractorUtils;

public class ClassExtractor {
	
	public static String OUTPUT_FILE="output/" +ClassExtractorUtils.fileName;
	private static XSSFWorkbook wb = new XSSFWorkbook();
	
	public static void main(String[] args) {
		
		ClassContentExtractor classcontentextractor = new ClassContentExtractor();	
		classcontentextractor.classContentExtractor(wb); 
		
		
		try {
			FileOutputStream outputStream = new FileOutputStream(OUTPUT_FILE);
			wb.write(outputStream);	
			outputStream.close();	
			
			System.out.println("Class sheet Extracted successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
