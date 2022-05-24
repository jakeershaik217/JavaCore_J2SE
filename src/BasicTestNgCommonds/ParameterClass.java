package BasicTestNgCommonds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterClass {
	
 public static WebDriver driver;
 
 
  @Parameters({"browserName"})
  @Test
  public void SetUP(@Optional("chrome") String browserName) {
	  
	if(browserName.equals("IE")){
		
		System.setProperty("webdriver.ie.driver", "D:\\Drivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		
		
	}
	else if(browserName.equals("chrome")){
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\New folder\\chromedriver.exe");
		driver=new ChromeDriver();
		
		
	}
	  
	  
	  
  }
  
 
}
