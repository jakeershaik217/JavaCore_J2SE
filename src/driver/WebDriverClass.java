package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverClass {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverWait wait=new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='GmailAddress']"))));
		System.setProperty("webdriver.ie.driver", "D:\\Drivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.get("https://accounts.google.com/SignUp?hl=en-GB");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.DAYS);
		driver.findElement(By.xpath(".//*[@id='GmailAddress']")).clear();
		
		
		
		
	}

}
