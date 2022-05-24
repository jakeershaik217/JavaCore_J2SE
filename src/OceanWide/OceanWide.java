package OceanWide;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.Action;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OceanWide {
	
	
	public static WebDriver driver;
	public WebDriverWait wait;
	 void  StartDriver(WebDriver driver) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G:\\Java\\chromedriver.exe");
	this.driver=new ChromeDriver();
	this.driver.manage().window().maximize();
	}

	static void  StopDriver(WebDriver driver) throws InterruptedException {
		driver.close();
	}
	
	public void highlightElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		}
	void login(WebDriver driver) throws InterruptedException {
		this.driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_Username_Dynamic_NestedControl_TextBox\"]")).sendKeys("bridge@oceanwide.com");
		this.driver.findElement(By.xpath("//*[@id=\"ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_Password_Dynamic_NestedControl_TextBox\"]")).sendKeys("p455w3rd");
		this.driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_btnLogon_Button']")).click();
	    wait=new WebDriverWait(driver, 120);
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[1]/a/span"))));
	}
	
	
	
	void javamouse() {
		
		
		String javascript="var evObj=document.createEvent('MouseEvent');"+"evObj.initMouseEvent(\"mouseover\",true,falsewindow,0,0,0,0,false,false,false,false,o,null"+"arguments[0].dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(javascript,this.driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/a/span")));
		((JavascriptExecutor) driver).executeScript(javascript,this.driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/a/span")));
		((JavascriptExecutor) driver).executeScript(javascript,this.driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/div/ul/li[1]/a/span")));
	
	}
	void MouseOvering(WebDriver driver) throws InterruptedException {
		wait=new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/a/span"))));
		act.moveToElement(this.driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/a/span"))).moveToElement(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/a/span"))).build().perform();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/a/span"))));
		act.moveToElement(this.driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/a/span"))).build().perform();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/div/ul/li[1]/a/span"))));
		act.moveToElement(this.driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/div/ul/li[1]/a/span"))).build().perform();
		this.driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/div/ul/li[1]/a/span")).click(); 
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenButtonBarPlaceHolder_ContentButtonPlaceHolder_ContentButtonPlaceHolder_ButtonBar_btnCreate_Button']"))));
	    driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenButtonBarPlaceHolder_ContentButtonPlaceHolder_ContentButtonPlaceHolder_ButtonBar_btnCreate_Button']")).click();
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table[1]/tbody/tr/td[2]/span/input"))));
	
	}
	public static void Javascriptmouseover(WebElement element){
	      
	       String javaScript = "var evObj = document.createEvent('MouseEvents');" +
	             "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
	             "arguments[0].dispatchEvent(evObj);";
	       ((JavascriptExecutor)driver).executeScript(javaScript, element);
	       
	      
	}
	void MouseOvering3(WebDriver driver) throws InterruptedException {
		wait=new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/a/span"))));
		Javascriptmouseover(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/a/span")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/a/span"))));
		Javascriptmouseover(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/a/span")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/div/ul/li[1]/a/span"))));
		Javascriptmouseover(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/div/ul/li[1]/a/span")));
		WebElement e1=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/div/ul/li[1]/a/span"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", e1);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenButtonBarPlaceHolder_ContentButtonPlaceHolder_ContentButtonPlaceHolder_ButtonBar_btnCreate_Button']"))));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenButtonBarPlaceHolder_ContentButtonPlaceHolder_ContentButtonPlaceHolder_ButtonBar_btnCreate_Button']")));
	}

	void MouseOvering2(WebDriver driver) throws InterruptedException {
		wait=new WebDriverWait(driver, 120);
		Actions act=new Actions(driver);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/a/span"))));
		act.moveToElement(this.driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/a/span"))).moveToElement(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/a/span"))).build().perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/a/span"))));
		act.moveToElement(this.driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/a/span"))).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/div/ul/li[1]/a/span"))));
		act.moveToElement(this.driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/div/ul/li[1]/a/span"))).build().perform();
		this.driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[6]/div/ul/li[1]/a/span")).click(); 
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenButtonBarPlaceHolder_ContentButtonPlaceHolder_ContentButtonPlaceHolder_ButtonBar_btnCreate_Button']"))));
	    
	}

	
 public String FileReader(String SheetName,int row,int col) throws IOException {
		
		File src=new File("G:\\OceanWide.xlsx");
		FileInputStream fin=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet sheet=wb.getSheet(SheetName);
		String Str=sheet.getRow(row).getCell(col).getStringCellValue();
		return Str;
		
	}
	
 public void DropDown(WebDriver driver,WebElement ele1,String Str) throws InterruptedException {
	 Select sel=new Select(ele1);
	 sel.selectByValue(Str);
	 wait=new WebDriverWait(driver, 120);
	
      System.out.println(((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
	  boolean b=((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	while(b!=true) {
			
			
		}
	 
	 	 
	 
 }
 
 public void dataEntry(WebDriver driver) throws IOException, InterruptedException {
	 
	for(int i=0;i<3;i++) {
		try {
		String s=FileReader("Sheet1", 1, i);
		if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td[2]/span/input")).isEnabled()==true&&s!=null) {
		driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td[2]/span/input")).sendKeys(s);
		
		}
		
		}catch(Exception e) {
			
			
			
		}
	}
	 
	
	
	for(int i=3;i<10;i++) {
		
		if(i!=8) {
		
		try {
		WebElement em1=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td/div/select"));
		String Str=FileReader("Sheet1", 1, i);
		if(em1.isEnabled()==true&& Str!="No") {	
		
	
			DropDown(driver, em1, Str);
			

		}
		
		
	}catch(Exception e) {
		
		WebElement em1=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td/div/select"));
		String Str=FileReader("Sheet1", 1, i);
		System.out.println(((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
		  boolean b=((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		while(b!=true) {
				
				
			}
		if(em1.isEnabled()==true&& Str!="No") {	
			
	
			DropDown(driver, em1, Str);
			
			
			
			
		}
		
		
		
	}
	
		
		}else if(i==8) {
			
			WebElement ment=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table[9]/tbody/tr/td[2]/span/span/input"));	
			((JavascriptExecutor)driver).executeScript("arguments[0].click()", ment);
			
		}
	}
		
	for(int i=0;i<2;i++) {
		
		String Str1=FileReader("Sheet2", 1, i);
		driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_ControlPropertiesPanel']/table["+(i+1)+"]/tbody/tr/td[2]/span/textarea")).sendKeys(Str1);;
		
	}
	for(int i=1;i<=6;i++) {
		
		String Str1=FileReader("Sheet2", 1, i+1);
		if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+i+"]/tbody/tr/td[2]/span/span/input")).isEnabled()==true && Str1.equals("yes"))
		driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+i+"]/tbody/tr/td[2]/span/span/input")).click();;
		
	}
	String Calculated=FileReader("Sheet2", 1, 8);
	WebElement web=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlCalculatedRelatedFields']/table[1]/tbody/tr/td[2]/span/span/input"));
	
	if(web.isEnabled()==true&&Calculated.equals("yes")) {
	((JavascriptExecutor)driver).executeScript("arguments[0].click()", web);
	 WebElement web1=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlCalculatedRelatedFields']/div/table[1]/tbody/tr/td[2]/span/span/input"));
	
	 String Always_Calculate=FileReader("Sheet2", 1, 9);
	 if(web1.isEnabled()==true&&Always_Calculate.equals("yes")) {
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click()", web1); 
		 String Calculated_Field_Formula=FileReader("Sheet2", 1, 10);
		 driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Formula_Dynamic_NestedControl_TextBox']")).sendKeys(Calculated_Field_Formula);;
		 for(int i=0;i<3;i++) {
				
				String Str1=FileReader("Sheet2", 1, i+11);
				if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).isEnabled()==true)
				driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).sendKeys(Str1);
				
			}
	 }
	}
	else {
		
		
		String Apply_Default=FileReader("Sheet2", 1, 14);
		if(Apply_Default.equals("None")) {
			
            for(int i=0;i<3;i++) {
				
				String Str1=FileReader("Sheet2", 1, i+11);
				if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).isEnabled()==true)
				driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).sendKeys(Str1);
				
			}
            
           
			
		}
		 else if(Apply_Default.equals("Constant")){
			 
			 WebElement Apply_Default_=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_DefaultValueType_Dynamic_NestedControl_RadioButtonList_1']"));	
				((JavascriptExecutor)driver).executeScript("arguments[0].click()", Apply_Default_);
			 
         	String Default=FileReader("Sheet2", 1, 15);
         	
			 driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_defaultValueTypePanel_Constant']/table/tbody/tr/td[2]/span/textarea")).sendKeys(Default);
         	
			 for(int i=0;i<3;i++) {
					
					String Str1=FileReader("Sheet2", 1, i+11);
					if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).isEnabled()==true)
					driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).sendKeys(Str1);
					
				}
         	
         	
         	
         	
         	
         	
         }
		
		
		 else if(Apply_Default.equals("Formula")){
			 WebElement Apply_Default_=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_DefaultValueType_Dynamic_NestedControl_RadioButtonList_2']"));	
				((JavascriptExecutor)driver).executeScript("arguments[0].click()", Apply_Default_);
			 
	         	String Default_Formula=FileReader("Sheet2", 1, 15);
				 driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_defaultValueTypePanel_Formula']/table/tbody/tr/td[2]/span/textarea")).sendKeys(Default_Formula);
	         	
				 for(int i=0;i<3;i++) {
						
						String Str1=FileReader("Sheet2", 1, i+11);
						if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).isEnabled()==true)
						driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).sendKeys(Str1);
						
					}
	         	
	         	
	         	
	         	
	         	
	         	
	         }
		
	}

	
	

for(int i=0;i<=6;i++) {
	
	
	int d=0;
	String Str1=FileReader("Sheet3", 1, 2*i);
	String Field=FileReader("Sheet3", 1, 2*i+1);
	if(Str1.equals("Source Transaction")) {
		d=1;
	}
	else if(Str1.equals("Default")) {
		
		d=2;
		
		
	}
	else if(Str1.equals("Field")) {
		
		d=3;
	}
	WebElement element=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_PolicySettingsPanel']/table["+(i+1)+"]/tbody/tr/td[2]/span/table/tbody/tr/td["+d+"]/input"));
	WebElement emt=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_PolicySettingsPanel']/div["+(i+1)+"]/table/tbody/tr/td[2]/div[1]/select"));

	if(element.isEnabled()==true && !Str1.equals(null))
		element.click();
	    if(d==3) {
	    	
	    	DropDown(driver, emt, Field);
	    }
		
		
	
}



 }
 
 
 public void inputBox() throws InterruptedException, AWTException {
	 
	 
	 highlightElement(driver.findElement(By.xpath(".//*[@id='dvCH_ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Fields_WebGrid_']/table/tbody/tr[2]/td[3]")));
	 highlightElement(driver.findElement(By.xpath(".//*[@id='dvCH_ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Fields_WebGrid_']/table/tbody/tr[2]/td[3]")));
	 ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.xpath(".//*[@id='dvCH_ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Fields_WebGrid_']/table/tbody/tr[2]/td[3]")));
	 ((JavascriptExecutor) driver).executeScript("arguments[0].value='jakeer';", driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlFieldSearch']/div[1]/div[1]/div[1]/input")));
	 List<WebElement> ele=driver.findElements(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Fields_WebGrid_TB"));
	 for(WebElement e:ele) {
		 
		 highlightElement(e); 
		 e.click();
		 e.sendKeys("123");
	 }
	 highlightElement(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlFieldSearch']/div[1]/div[1]/div[1]/input")));
	 driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlFieldSearch']/div[1]/div[1]/div[1]/input")).sendKeys("22");
	 
	 
 }
 
 
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
	
		OceanWide oc=new OceanWide();
		oc.StartDriver(driver);
		driver.get("https://owbridge2.beta.qa.oceanwidebridge.com/");
		Thread.sleep(3000);
		oc.login(driver);
       oc.MouseOvering3(driver);
       oc.dataEntry(driver);	
		
	}
		
		
		
	}

//
//Active:https://owbridge2.beta.qa.oceanwidebridge.com/
//.//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_StatusInfo_StatusInfo']/table/tbody/tr/td[2]/span/span/input
//
//created by
//.//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_StatusInfo_StatusInfo']/table[2]/tbody/tr/td[2]/span
//
//
//last mid by.//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_StatusInfo_StatusInfo']/table[3]/tbody/tr/td[2]/span.
//

