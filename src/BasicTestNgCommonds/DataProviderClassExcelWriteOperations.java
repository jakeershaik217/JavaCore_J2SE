package BasicTestNgCommonds;

import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DataProviderClassExcelWriteOperations {
 
	public static List<Object> Lst;
	@DataProvider(name="ExcelWrite")
	public static Object[][] dataprovider() throws Exception{
		
		File src=new File("D:\\SDC.xlsx");
		FileInputStream fin=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet Sheet=wb.getSheetAt(0);
		int rowcount=Sheet.getPhysicalNumberOfRows();
		int colcount=Sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowcount][colcount];
		
		for(int i=0;i<rowcount;i++){
			
			
			for(int j=0;j<colcount;j++){
				
				
				obj[i][j]=Sheet.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		
		
		return obj;
	}
	
	@Test(dataProvider="ExcelWrite")
	public static void excel(String I1,String I2){
		
		System.out.println(I1+"      "+I2);
		
	}
	
	
}


	
	
	
	
	
	
	

