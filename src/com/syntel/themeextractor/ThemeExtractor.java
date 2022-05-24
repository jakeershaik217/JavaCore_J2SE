package com.syntel.themeextractor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ThemeExtractor {
	
	public static String OUTPUT_FILE="output/" +ThemeExtractorUtils.fileName;
	private static XSSFWorkbook wb = new XSSFWorkbook();
	
	public static void main(String[] args) {

		ThemeContentExtractor themecontentextractor = new ThemeContentExtractor();	
		themecontentextractor.themeContentExtractor(wb); 
		try {
			FileOutputStream outputStream = new FileOutputStream(OUTPUT_FILE);
			wb.write(outputStream);	
			outputStream.close();	
			System.out.println(" sheet Extracted successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
