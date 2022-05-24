package driver;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;


import org.testng.annotations.*;

public class Warrenty {
	
	public static WebDriver driver;
	public static Properties pr;
	public static File src=new File("C:\\Users\\JS5028452\\workspace\\MbUSAAutomationSuite_webdriver\\MbUSAAutomationSuite\\src\\main\\resources\\Sample.xml");
	public static FileInputStream file;
	
	
	@BeforeTest
	public static void launch() throws FileNotFoundException, InterruptedException{
		
		System.setProperty("webdriver.ie.driver", "D:\\Drivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.navigate().to("https://www.mbusa.com/mercedes/vehicles/model/class-C/model-C300W");
		
		for(int i=0;i<25;i++){
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,270);");
		Thread.sleep(1000);

		}
		file=new FileInputStream(src);
	}
	
	@Test
	public static void Setproperties() throws InvalidPropertiesFormatException, IOException, InterruptedException{
		
		pr=new Properties();
		pr.loadFromXML(file);
		
	}
	
	@Test(dependsOnMethods={"Setproperties"})
	public static void warrenty() throws InterruptedException{
		
		String warrenty=driver.findElement(By.xpath("//div[@id='model-warranty']/div[1]/div[1]/h2")).getText();
		String overview=driver.findElement(By.xpath(".//*[@id='model-warranty']/div/div/div[1]/div[1]")).getText();
		String keepit=driver.findElement(By.xpath(".//*[@id='model-warranty']/div/div/div[1]/div[2]/strong")).getText();
		for(int i=1;i<=2;i++){
		String text1=driver.findElement(By.xpath(".//*[@id='model-warranty']/div/div/div[1]/div[2]/div/div["+i+"]")).getText();
		Assert.assertEquals( pr.getProperty("text"+i), text1.replaceAll("\n", ""),"Both are nop matched");
		
		}
		Assert.assertEquals(pr.getProperty("Warrentyservices"), warrenty.replaceAll("\n", ""),"Both are nop matched");
		
		Assert.assertEquals( pr.getProperty("Overview"), overview.replaceAll("\n", ""),"Both are nop matched");
		Assert.assertEquals( pr.getProperty("KeepIt"), keepit.replaceAll("\n", ""),"Both are nop matched");
	   
		
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath(".//*[@id='model-warranty']/div/div/div[2]/ul/li[4]/div/a")));
		
		Thread.sleep(4000);
		
		WebElement Ele=driver.findElement(By.xpath("//div[@id='model-warranty']/div/div/div[2]/ul/div/div[1]/div[1]"));
		/*System.out.println(Ele.getText());
		System.out.println("***************************");*/
		
	boolean b=	Ele.getText().equals(pr.getProperty("prepaid4"));
	Assert.assertTrue(b);
		
		}
		
		
		
	
	@AfterTest
	public static void close(){
		
		
		driver.close();
	}

}
