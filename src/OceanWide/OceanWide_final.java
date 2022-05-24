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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OceanWide_final {
	
	
	public static WebDriver driver;
	 public WebDriverWait wait;
	 
	 
	 void  StartDriver(WebDriver driver) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "G:\\Java\\chromedriver.exe");
	this.driver=new ChromeDriver();
	this.driver.get("https://owbridge2.beta.qa.oceanwidebridge.com/");
	this.driver.manage().window().maximize();
	WebDriverWait wait1=new WebDriverWait(this.driver, 120);
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
	    this.wait=new WebDriverWait(driver, 120);
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
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[1]/a/span"))));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[@id='ctl00_ctl00_TopMenuPlaceHolder_ucTopMenu_RadTopMenu']/ul/li[4]/div/ul/li[1]/a/span")));
		
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
		
		File src=new File("G:\\OceanWide2.xlsx");
		FileInputStream fin=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet sheet=wb.getSheet(SheetName);
		String Str=sheet.getRow(row).getCell(col).getStringCellValue();
		return Str;
		
	}
 public void Filewrite(String SheetName,int row,int col,String Sd) throws IOException {
		
		File src=new File("G:\\OceanWide2.xlsx");
		FileInputStream fin=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet sheet=wb.getSheet(SheetName);
		sheet.createRow(row).createCell(col).setCellValue(Sd);
		
		
	}
	
 public void DropDown(WebDriver driver,WebElement ele1,String Str) throws InterruptedException {
	 Select sel=new Select(ele1);
	 sel.selectByVisibleText(Str);
	 wait=new WebDriverWait(driver, 120);
     System.out.println(((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
	 boolean b=((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		while(b!=true) {
			
			
		}
	  
		Thread.sleep(20000); 
	 
 }
 public void DropDown1(WebDriver driver,WebElement ele1,String Str) throws InterruptedException {
	 Select sel=new Select(ele1);
	 sel.selectByVisibleText(Str);
	 wait=new WebDriverWait(driver, 120);
     System.out.println(((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
	 boolean b=((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		while(b!=true) {
			
			
		}
	 
	 
 }
 
 public void dataEntry(WebDriver driver) throws IOException, InterruptedException {
	 
	for(int i=0;i<3;i++) {
		try {
		String s=FileReader("Sheet5", 1, i);
		if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td[2]/span/input")).isEnabled()==true&&s!=null) {
		driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td[2]/span/input")).sendKeys(s);
		
		}
		
		}catch(Exception e) {
			
			
			
		}
	}
	 
	
	
	for(int i=3;i<9;i++) {
		
		if(i!=7) {
		
		try {
		WebElement em1=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td/div/select"));
		String Str=FileReader("Sheet5", 1, i);
		if(em1.isEnabled()==true&&!Str.equals("No")) {	
		
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td/div/select")));
			DropDown(driver, em1, Str);
			

		}
		
		
	}catch(Exception e) {
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td/div/select")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td/div/select")));
		WebElement em1=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td/div/select"));
		//wait.until(ExpectedConditions.visibilityOf(em1));
		String Str=FileReader("Sheet5", 1, i);
		if(em1.isEnabled()==true&&!Str.equals("No")) {	
			
	
			DropDown(driver, em1, Str);
			
			
			
			
		}
		
		
		
	}
	
		
		}else if(i==7) {
			String Str=FileReader("Sheet5", 1, i);
			if(!Str.equals("No")) {
			WebElement ment=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table[8]/tbody/tr/td[2]/span/span/input"));	
			((JavascriptExecutor)driver).executeScript("arguments[0].click()", ment);
			}
		}
	}
		
	for(int i=0;i<2;i++) {
		
		String Str1=FileReader("Sheet2", 1, i);
		driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_ControlPropertiesPanel']/table["+(i+1)+"]/tbody/tr/td[2]/span/textarea")).sendKeys(Str1);;
		
	}
	for(int i=0;i<6;i++) {
		
		String Str1=FileReader("Sheet3", 1, i);
		if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+1)+"]/tbody/tr/td[2]/span/span/input")).isEnabled()==true && Str1.equals("Yes"))
		driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+1)+"]/tbody/tr/td[2]/span/span/input")).click();;
		
	}
	String Calculated=FileReader("Sheet1", 1, 1);
	WebElement web=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlCalculatedRelatedFields']/table[1]/tbody/tr/td[2]/span/span/input"));
	
	if(web.isEnabled()==true&&Calculated.equals("Yes")) {
	((JavascriptExecutor)driver).executeScript("arguments[0].click()", web);
	 WebElement web1=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlCalculatedRelatedFields']/div/table[1]/tbody/tr/td[2]/span/span/input"));
	
	 String Always_Calculate=FileReader("Sheet1", 1, 2);
	 if(web1.isEnabled()==true&&Always_Calculate.equals("Yes")) {
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click()", web1); 
		 String Calculated_Field_Formula=FileReader("Sheet1", 1, 3);
		 driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Formula_Dynamic_NestedControl_TextBox']")).sendKeys(Calculated_Field_Formula);;
		 for(int i=0;i<3;i++) {
				
				String Str1=FileReader("Sheet1", 1, i+4);
				if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).isEnabled()==true)
				driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).sendKeys(Str1);
				
			}
	 }
	}
	else {
		
		
		String Apply_Default=FileReader("Sheet3", 1, 6);
		if(Apply_Default.equals("None")) {
			
            for(int i=0;i<3;i++) {
				
				String Str1=FileReader("Sheet3", 1, i+7);
				if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).isEnabled()==true)
				driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).sendKeys(Str1);
				
			}
            
           
			
		}
		 else if(Apply_Default.equals("Constant")){
			 
			 WebElement Apply_Default_=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_DefaultValueType_Dynamic_NestedControl_RadioButtonList_1']"));	
				((JavascriptExecutor)driver).executeScript("arguments[0].click()", Apply_Default_);
			 
				String Default=FileReader("Sheet3", 1, 7);
         	
			 driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_defaultValueTypePanel_Constant']/table/tbody/tr/td[2]/span/textarea")).sendKeys(Default);
         	
			 for(int i=0;i<3;i++) {
				 
					
					String Str1=FileReader("Sheet3", 1, i+8);
					if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).isEnabled()==true)
					driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).sendKeys(Str1);
					
				}
         	
         	
         	
         	
         	
         	
         }
		
		
		 else if(Apply_Default.equals("Formula")){
			 WebElement Apply_Default_=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_DefaultValueType_Dynamic_NestedControl_RadioButtonList_2']"));	
				((JavascriptExecutor)driver).executeScript("arguments[0].click()", Apply_Default_);
			 
	         	String Default_Formula=FileReader("Sheet3", 1, 7);
				 driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_defaultValueTypePanel_Formula']/table/tbody/tr/td[2]/span/textarea")).sendKeys(Default_Formula);
	         	
				 for(int i=0;i<3;i++) {
						
						String Str1=FileReader("Sheet3", 1, i+8);
						if(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).isEnabled()==true)
						driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_OwPanel1']/table["+(i+7)+"]/tbody/tr/td[2]/span/input")).sendKeys(Str1);
						
					}
	         	
	         	
	         	
	         	
	         	
	         	
	         }
		
	}

	


for(int i=0;i<=6;i++) {
	
	
	int d=0;
	String Str1=FileReader("Sheet4", 1, 2*i);
	String Field=FileReader("Sheet4", 1, 2*i+1);
	if(Str1.equals("Copy From Source")) {
		d=1;
	}
	else if(Str1.equals("Do Not Copy")) {
		
		d=2;
		
		
	}
	else if(Str1.equals("Copy Different Field From Source")) {
		
		d=3;
	}
	WebElement element=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_PolicySettingsPanel']/table["+(i+1)+"]/tbody/tr/td[2]/span/table/tbody/tr/td["+d+"]/input"));
	WebElement emt=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_PolicySettingsPanel']/div["+(2*i+1)+"]/table/tbody/tr/td[2]/div[1]/select"));

	if(element.isEnabled()==true && !Str1.equals(null))
		element.click();
	    if(d==3) {
	    	
	    	DropDown1(driver, emt, Field);
	    }
		
		
	
}
driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenButtonBarPlaceHolder_ContentButtonPlaceHolder_ContentButtonPlaceHolder_ButtonBar_btnAdd_Button']")).click();


 }
 public void getdata() {
	 for(int i=0;i<2;i++) {
			try {
			
			String S1=driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_pnlGeneralInformation']/table["+(i+1)+"]/tbody/tr/td[2]/span/input")).getText();
			Filewrite("Sheet1", 1, i+7,S1);
			
			}catch(Exception e) {
				
				
				
			}
		}
	 
	 
			try {
			String S1=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_StatusInfo_CreatedBy_Dynamic_NestedControl_Label']")).getText();
			Filewrite("Sheet1", 1, 9,S1);
			String S2=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_StatusInfo_CreatedBy_Dynamic_NestedControl_Label']")).getText();
			Filewrite("Sheet1", 1, 10,S2);
			
			}catch(Exception e) {
				
				
				
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
 
 public void MainLineClick() throws IOException, InterruptedException {
	 
	 
	/*String Name=FileReader("Sheet1", 1, 0);
	 WebElement Filter=driver.findElement(By.xpath("//*[@id='tb_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_WorkflowContainerListView_WorkflowContainerListGrid_WebGrid_']/tbody/tr[14]/td[3]/nobr/a[text()='"+Name+"']"));
	 wait.until(ExpectedConditions.visibilityOf(Filter));
	((JavascriptExecutor)driver).executeScript("arguments[0].click()",Filter);
	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_LeftColumnPlaceHolder_ContentPlaceHolderLeftSidebar_ContentPlaceHolderLeftSidebar_ucCommonScreens_ListWidget']/ul/li/div/ul/li[2]/a/span/span[2]"))));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_LeftColumnPlaceHolder_ContentPlaceHolderLeftSidebar_ContentPlaceHolderLeftSidebar_ucCommonScreens_ListWidget']/ul/li/div/ul/li[2]/a/span/span[2]")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_LeftColumnPlaceHolder_ContentPlaceHolderLeftSidebar_ContentPlaceHolderLeftSidebar_ucCommonScreens_ListWidget']/ul/li/div/ul/li[2]/div/ul/li[1]/a/span/span[2]"))));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_LeftColumnPlaceHolder_ContentPlaceHolderLeftSidebar_ContentPlaceHolderLeftSidebar_ucCommonScreens_ListWidget']/ul/li/div/ul/li[2]/div/ul/li[1]/a/span/span[2]")));
		 
	
	
	// driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_WorkflowContainerListView_WorkflowContainerListPanel']/div/div[1]/div[1]/input")).sendKeys("adv");
	// driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_WorkflowContainerListView_WorkflowContainerListPanel']/div/div[1]/div[1]/input")).sendKeys(Keys.ENTER);
	
	/* List<WebElement> e=driver.findElements(By.tagName("input"));
	 for(WebElement ele:e) {
		 
		 System.out.println(ele.getClass());
		 
	 }*/
	 String Name=FileReader("Sheet1", 1, 0);
	
	 
		driver.findElement(By.xpath("//td[@type='FilterColumn']")).click();
	    driver.findElement(By.id("ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_WorkflowContainerListView_WorkflowContainerListGrid_WebGrid_TB")).clear();
	    driver.findElement(By.id("ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_WorkflowContainerListView_WorkflowContainerListGrid_WebGrid_TB")).sendKeys(Name);
	    driver.findElement(By.id("ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_WorkflowContainerListView_WorkflowContainerListGrid_WebGrid_TB")).sendKeys(Keys.ENTER);
		 
	    WebElement Filter=driver.findElement(By.xpath("//*[@id='tb_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_WorkflowContainerListView_WorkflowContainerListGrid_WebGrid_']//child::a[text()='"+Name+"']"));
		 wait.until(ExpectedConditions.visibilityOf(Filter));
	((JavascriptExecutor)driver).executeScript("arguments[0].click()",Filter);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_LeftColumnPlaceHolder_ContentPlaceHolderLeftSidebar_ContentPlaceHolderLeftSidebar_ucCommonScreens_ListWidget']/ul/li/div/ul/li[2]/a/span/span[2]"))));
	((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_LeftColumnPlaceHolder_ContentPlaceHolderLeftSidebar_ContentPlaceHolderLeftSidebar_ucCommonScreens_ListWidget']/ul/li/div/ul/li[2]/a/span/span[2]")));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_LeftColumnPlaceHolder_ContentPlaceHolderLeftSidebar_ContentPlaceHolderLeftSidebar_ucCommonScreens_ListWidget']/ul/li/div/ul/li[2]/div/ul/li[1]/a/span/span[2]"))));
	((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[@id='ctl00_ctl00_ctl00_LeftColumnPlaceHolder_ContentPlaceHolderLeftSidebar_ContentPlaceHolderLeftSidebar_ucCommonScreens_ListWidget']/ul/li/div/ul/li[2]/div/ul/li[1]/a/span/span[2]")));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenButtonBarPlaceHolder_ContentButtonPlaceHolder_ContentButtonPlaceHolder_ButtonBar_btnCreate_Button']"))));
	((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_ScreenButtonBarPlaceHolder_ContentButtonPlaceHolder_ContentButtonPlaceHolder_ButtonBar_btnCreate_Button']")));
	
 }
 
 
 public void dummy() {
	 
	 driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Name_Dynamic_NestedControl_TextBox")).clear();
     driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Name_Dynamic_NestedControl_TextBox")).sendKeys("jakeer");
     driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_ExternalCode_Dynamic_NestedControl_TextBox")).clear();
     driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_ExternalCode_Dynamic_NestedControl_TextBox")).sendKeys("hussain");
     wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_ControlTypeCode_Dynamic_NestedControl_ComboBox"))));
     new Select(driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_ControlTypeCode_Dynamic_NestedControl_ComboBox"))).selectByVisibleText("Drop Down");
     wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Options_Dynamic_NestedControl_ComboBox"))));
     driver.findElement(By.cssSelector("option[value=\"DropDown\"]")).click();
     new Select(driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Options_Dynamic_NestedControl_ComboBox"))).selectByVisibleText("Attachment Types");
     wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Size_Dynamic_NestedControl_ComboBox"))));
     driver.findElement(By.cssSelector("option[value=\"DropDown\"]")).click();
     new Select(driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Size_Dynamic_NestedControl_ComboBox"))).selectByVisibleText("Medium");
     driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_Correlated_Dynamic_NestedControl_Checkbox")).click();
     new Select(driver.findElement(By.id("ctl00_ctl00_ctl00_ScreenContentPlaceHolder_rootCPH_rootCPH_ParentField_Dynamic_NestedControl_ComboBox"))).selectByVisibleText("Generic Child Correlated Field");
	 
	 
 }
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
	
		OceanWide_final oc=new OceanWide_final();
		oc.StartDriver(driver);
		oc.login(driver);
       oc.MouseOvering3(driver);
       oc.MainLineClick();
      // oc.dummy();
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

