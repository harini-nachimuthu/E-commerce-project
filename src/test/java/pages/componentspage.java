package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.basemethod;

public class componentspage extends basemethod{
  
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[3]")
	WebElement componentbtn;
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[3]/div/div/ul/li[1]")
	WebElement micesandtrackballs;
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[3]/div/div/ul/li[2]")
	WebElement monitors;
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[3]/div/div/ul/li[3]")
	WebElement printers;
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[3]/div/div/ul/li[4]")
	WebElement scanners;
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[3]/div/div/ul/li[5]")
	WebElement webcameras;
	
	@FindBy(xpath="//div[@id='product-category']/div/div[1]/p[.='There are no products to list in this category.']")
	WebElement informationpresent;
	
	@FindBy(xpath="//div[@id='content']/div/div/a[.='Continue']")
	WebElement afterinfocontinuebtn;
	
	@FindBy(xpath="//div[@id='content']/div[3]/div/div/div[2]/div/h4/a[.='Apple Cinema 30\"']")
	WebElement applecinema;
	
	public componentspage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(45));
		this.js=(JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public componentspage component() throws InterruptedException {
		scrollandclick(componentbtn);
		scrollandclick(micesandtrackballs);
		informationdatachecking(informationpresent,afterinfocontinuebtn);
		
		scrollandclick(componentbtn);
		scrollandclick(printers);
		informationdatachecking(informationpresent,afterinfocontinuebtn);
		
		scrollandclick(componentbtn);
		scrollandclick(scanners);
		informationdatachecking(informationpresent,afterinfocontinuebtn);
		
		scrollandclick(componentbtn);
		scrollandclick(webcameras);
		informationdatachecking(informationpresent,afterinfocontinuebtn);
		
		return this;
	}
	
	
	@FindBy(xpath="//div[@id='content']/div/div[2]/div[2]/div[1]/div[1]/div[@class='radio']/label/input[@name='option[218]']")
	WebElement radiobtn;
	
	@FindBy(xpath="//div[@id='content']/div/div[2]/div[2]/div[2]/div[1]/div[1]/label/input[@name='option[223][]']")
	WebElement checkbox;
	
	@FindBy(xpath="//div[@id='content']/div/div[2]/div[2]/div[3]/input[@id='input-option208']")
	WebElement text;
	
	@FindBy(xpath="//div[@id='content']/div/div[2]/div[2]/div[4]/select[@id='input-option217']")
	WebElement selectbtn;
	
	@FindBy(xpath="//div[@id='content']/div/div[2]/div[2]/div[5]/textarea[@id='input-option209']")
	WebElement textarea;
	
	@FindBy(xpath="//div[@id='content']/div/div[2]/div[2]/div[6]/button")
	WebElement upload;
	
	@FindBy(xpath="//div[@id='content']/div/div[2]/div[2]/div[7]/div/input")
	WebElement fromdatebttn;
	
	@FindBy(xpath="//div[@id='content']/div/div[2]/div[2]/div[8]/div/input")
	WebElement time;
	
	@FindBy(xpath="//div[@id='content']/div/div[2]/div[2]/div[9]/div/input")
	WebElement todatebtn;
	
	@FindBy(xpath="//div[@id='content']/div/div[2]/div[2]/div[10]/input[@id='input-quantity']")
	WebElement quantity;
	
	@FindBy(xpath="(//button[@id='button-cart'])[1]")
	WebElement addtocart1;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement afteraddingtocart;
	
	public componentspage apple() throws InterruptedException, IOException {
		scrollandclick(componentbtn);
		scrollandclick(monitors);
		scrollandclick(applecinema);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		scrollandclick(radiobtn);
		scrollandclick(checkbox);
		scrollandsendkeys(text,"Testing");
		
		Select select=new Select(wait.until(ExpectedConditions.elementToBeClickable(selectbtn)));
		select.selectByValue("3");
		
		scrollandsendkeys(textarea,"Apple Cinema monitor");
		
		scrollandclick(upload);
		Thread.sleep(3000);
		
		String path="C:\\AutoIT_file\\ecommerce_website.exe";
		ProcessBuilder build=new ProcessBuilder(path);
		build.start();
		
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		
		scrollandsendkeys(fromdatebttn,"2024-10-05");
		scrollandsendkeys(time,"19:04");
		scrollandsendkeys(todatebtn,"2024-10-05 19:04");
		scrollandsendkeys(quantity,"1");
		
		datachecking(addtocart1);
		scrollandclick(addtocart1);
		datacheckingonlyvisible(afteraddingtocart);
		Thread.sleep(4000);
		
		return this;
	}
	
	public componentspage noproductcontinue() throws InterruptedException {
		informationdatachecking(informationpresent,afterinfocontinuebtn);
		return this;
	}
}
