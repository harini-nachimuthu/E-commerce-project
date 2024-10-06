package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class utility {
	
	public static WebDriver driver; 
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public String excelsheet;
	public String sheetname;
	
	public  void launchingbrowserandurl(String browser,String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
//			options.addArguments("--headless");
			driver=new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("dom.webnotifications.enabled\", false");
			options.addArguments("--incognito");
//			options.addArguments("headless");
			driver=new FirefoxDriver(options);
		}else {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
//			options.addArguments("--headless");
			driver=new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		js=(JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public  void closebrowser() {
		driver.close();
	}
	
	public  void  quitbrowser() {
		driver.quit();
	}

	public void scrollandclick(WebElement ele) throws InterruptedException {
	    wait.until(ExpectedConditions.visibilityOf(ele));
	    wait.until(ExpectedConditions.elementToBeClickable(ele));
	    js.executeScript("arguments[0].scrollIntoView(true);", ele);
//	    js.executeScript("arguments[0].click();", ele);
	    ele.click();
	}

	public void datachecking(WebElement ele) {
		WebElement web1=wait.until(ExpectedConditions.visibilityOf(ele));
	    WebElement web2=wait.until(ExpectedConditions.elementToBeClickable(ele));
	    if(web1.isDisplayed()&&web2.isDisplayed()) {
	    	System.out.println(ele.getText()+" is present........");
	    }else {
	    	System.out.println(ele.getText()+" is not present..........");
	    }
	}
	
	public void datacheckingonlyvisible(WebElement ele) {
		WebElement web1=wait.until(ExpectedConditions.visibilityOf(ele));
//	    WebElement web2=wait.until(ExpectedConditions.elementToBeClickable(ele));
	    if(web1.isDisplayed()) {
	    	System.out.println(ele.getText()+"is present........");
	    }else {
	    	System.out.println(ele.getText()+"is not present..........");
	    }
	}
	
	public void informationdatachecking(WebElement ele,WebElement continuebtn) throws InterruptedException {
		if(ele.isDisplayed()) {
			System.out.println(ele.getText()+" this is the information present");
			scrollandclick(continuebtn);
		}else {
			System.out.println("element is not present there......");
		}
	}
	
	public void scrollandsendkeys(WebElement ele,String keyvalue) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	    js.executeScript("arguments[0].scrollIntoView(true);", ele);
	    ele.clear();
	    ele.sendKeys(keyvalue);
	}
	
	public String[][] readdatafromexcel(String excelsheet,String sheetname) throws IOException{
		
		XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\harin\\eclipse-workspace\\E-commercewebsite\\Excelsheet\\"+excelsheet+".xlsx");
		XSSFSheet sheet=book.getSheet(sheetname);
		
		int rowsize=sheet.getLastRowNum();
		int columnsize=sheet.getRow(0).getLastCellNum();
		
		String[][] data=new String[rowsize][columnsize];
		for(int i=1;i<=rowsize;i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<columnsize;j++) {
				XSSFCell cell=row.getCell(j);
				
				if(cell==null) {
					data[i-1][j]="";
				}else {
					switch(cell.getCellType()) {
					case STRING:
						data[i-1][j]=cell.getStringCellValue();
						break;
					case NUMERIC:
						data[i-1][j]=String.valueOf(cell.getNumericCellValue());
						break;
					case BOOLEAN:
						data[i-1][j]=String.valueOf(cell.getBooleanCellValue());
						break;
					case FORMULA:
						data[i-i][j]=cell.getCellFormula();
						break;
					default:
						data[i-1][j]="";
					}
				}
			}
		}
		book.close();
		return data;
		
	}
	
	
	public void checknotprintthis(WebElement ele1, WebElement ele2) {
	    try {
	        WebElement web1 = wait.until(ExpectedConditions.visibilityOf(ele1));
	        if (web1.isDisplayed()) {
	            System.out.println(ele1.getText() + " is present........");
	        }
	    } catch (Exception e) {
	         try {
	            WebElement web2 = wait.until(ExpectedConditions.visibilityOf(ele2));
	            if (web2.isDisplayed()) {
	                System.out.println(ele2.getText() + " is present..........");
	            }
	        } catch (Exception ex) {
	            System.out.println("Neither element is present or visible.");
	        }
	    }	
	}
	
	public String takeScreenshot(String browser,String screenshotname) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String time=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String filename=browser+"_"+screenshotname+"_"+time+".png";
		String path="C:\\Users\\harin\\eclipse-workspace\\E-commercewebsite\\Screenshots\\"+filename;
		System.out.println("Screenshot" +path);
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
        return path;
    }
}
