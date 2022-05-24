package BasicTestNgCommonds;

import java.io.*;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class JsonCompare {

	public static WebDriver driver;
	public static File src1;
	public static File src2;
	public static File src3;
	public static String S1;
	public static String S2;
	public static StringBuilder Sb1;
	public static StringBuilder Sb2;
	public static WebDriverWait wait;
	public static ArrayList<StringBuilder> a1;
	@BeforeTest
	public static void launch(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\New folder\\chromedriver.exe");
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver, 10);
	}
	

	public static void loadxml(String S1,String S2) throws IOException{
		
		src1=new File("D:\\notepads\\URL1.txt");
		src2=new File("D:\\notepads\\URL2.txt");
		src3=new File("D:\\notepads\\diff.txt");
		
		BufferedWriter bw1=new BufferedWriter(new FileWriter(src1));
		bw1.write(S1);
		bw1.close();
		BufferedWriter bw2=new BufferedWriter(new FileWriter(src2));
		bw2.write(S2);
		bw2.close();
		
		
	}
	
	

	public static void launchBrowser() throws IOException{
		
		driver.get("http://mbusaprod-bgn.corpinter.net/mercedes/json/mediaServer/config");
		driver.manage().window().maximize();
		S1=driver.findElement(By.cssSelector("html>body>pre")).getText();
		driver.get("https://www.mbusa.com/mercedes/json/mediaServer/config");
		S2=driver.findElement(By.cssSelector("html>body>pre")).getText();
		loadxml(S1,S2);
		
		
		
		
		
		
	}
	@Test(priority=2)
	public static void compareNotepads() throws Exception{
		
		BufferedReader br1=new BufferedReader(new FileReader(src1));
		BufferedReader br2=new BufferedReader(new FileReader(src2));
		src1=new File("D:\\notepads\\URL1.txt");
		src2=new File("D:\\notepads\\URL2.txt");
		src3=new File("D:\\notepads\\diff.txt");
		Boolean b=false;
		String Reader1=br1.readLine();
		String Reader2=br2.readLine();
		
		while(Reader1!=null && Reader2!=null){
			
			
			if(Reader1==null || Reader2==null){
				
				b=false;
				break;
				
				
			}
			else if(!Reader1.equalsIgnoreCase(Reader2)){
				
				
				b=false;
				break;
			}
			else{
				
				b=true;
			}
			
			
			Reader1=br1.readLine();
			Reader2=br2.readLine();
			
		}
		
		if(b){
			System.out.println("Both URLs have same content");
		   Reporter.log("URL1:http://mbusaprod-bgn.corpinter.net/mercedes/json/mediaServer/config \n URL 2:https://www.mbusa.com/mercedes/json/mediaServer/config \n both have same content");
		}
		else{
			
	   System.out.println("Both URLs have different content and  follow the path"+src3.getPath()+"To get it");
	   Reporter.log("URL1:http://mbusaprod-bgn.corpinter.net/mercedes/json/mediaServer/config \n URL 2:https://www.mbusa.com/mercedes/json/mediaServer/config \n both have difference content and the difference is : \n"+StringUtils.difference(S1, S2));
	   BufferedWriter bw3=new BufferedWriter(new FileWriter(src2));
		bw3.write(StringUtils.difference(S1, S2));
		bw3.close();
		}
	}
	@AfterTest
	public static void close(){
		
		driver.close();
	}
	
	
}
