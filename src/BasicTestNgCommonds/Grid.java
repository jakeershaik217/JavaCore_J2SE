package BasicTestNgCommonds;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Grid {
	
	@Test
	public static void launch() throws MalformedURLException{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\New folder\\chromedriver.exe");
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.VISTA);
		URL url=new URL("http://localhost:4444/wd/hub");
		WebDriver driver=new RemoteWebDriver(url,cap);
		driver.get("https://www.mbusa.com/mercedes/special_offers/current#class=E");
		System.out.println(driver.getTitle());
		driver.close();
		
		
	}

}
