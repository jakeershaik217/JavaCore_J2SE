import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClasspageExtraction {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static void launch() {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Java\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}

	public static void Login() {
		driver.get("https://confluence.mbusa.com/display/MBUSACOM/MY18+C-Class");
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='brand']/div/div/div/div[1]/h5"))));
		driver.findElement(By.xpath("//div[@class='row']/div/div[1]/div[1]/input[1]")).sendKeys("FISHAIK");
		driver.findElement(By.xpath("//div[@class='row']/div/div[2]/div[1]/input[1]")).sendKeys("Syntel@2018");
		driver.findElement(By.xpath("//button[@id='button_login']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='sidebar-spaces']/div/ul/li[1]/a/span[2]"))));

		
	}
	public static void URL() {
		
		driver.get("https://confluence.mbusa.com/display/MBUSACOM/MY18+E43+AMG+Sedan+-+Model");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@id='MY18E43AMGSedan-Model-Features']/strong"))));

	}
	public static void close() {
		
		driver.close();
	}
public static void performance() {
		
    List<WebElement>  ele1=driver.findElements(By.xpath("//div[@id='main-content']/h1[contains(@id,'Model-Performance&Handling')]//following-sibling::div/table"));
    List<WebElement>  ele2=driver.findElements(By.xpath("//div[@id='main-content']/h1[contains(@id,'Model-Design')]//following-sibling::div/table"));
    ArrayList<WebElement> a1=new ArrayList();
    ArrayList<String> a2=new ArrayList();
    a1.addAll(ele1);
    a1.addAll(ele2);
    /*for(WebElement e:a1) {
    	
    	a2.add(e.getText());
    }
    	
    Set<String> st=new HashSet<String>();
    st.addAll(a2);
 for(String e:st) {
    	System.out.println(e);
    	
    }
    */
    	for(int i=0;i<a1.size();i++) {
    		
    		for(int j=i+1;j<a1.size();j++) {
    			
    			if(a1.get(i).getText().equals(a1.get(j).getText())) {
    				
    				a1.remove(a1.get(j));
    				
    			}
    			
    		}
    		
    	}
    	
    	
   
   
    for(WebElement e:a1) {
    	
    	System.out.println(e.getText());
    }
    
    
    
	}
	
	public static void main(String[] args) {
		launch();
		Login();
		URL();
		performance();
		close();

	}

}

class ComparatorClass implements Comparator{
	
	public int compare(Object O1,Object O2) {
		
		WebElement e1=(WebElement)O1;
		WebElement e2=(WebElement)O2;
		if(e1==e2) return 1;
		return -1;
		
		
	}
	
	
}
