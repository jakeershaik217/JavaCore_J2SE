package com.syntel.AMGclassextractor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.syntel.classextractor.ClassContentExtractor;
import com.syntel.classextractor.ClassExtractorUtils;

public class AMGClassExtractor {

	public static String OUTPUT_FILE="output/" +AMGClassExtractorUtils.fileName;
	private static XSSFWorkbook wb = new XSSFWorkbook();
	public static void main(String[] args) {
		AMGContentExtractor amgclasscontentextractor = new AMGContentExtractor();	
		amgclasscontentextractor.classContentExtractor(wb); 
		
		
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
