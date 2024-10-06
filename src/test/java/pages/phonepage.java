package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.basemethod;

public class phonepage extends basemethod{
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[6]")
	WebElement phonebtn;
	
	@FindBy(xpath="//body/header/div/div/div[2]/div/input[@name='search']")
	WebElement searchbox;
	
	@FindBy(xpath="//body/header/div/div/div[2]/div/span/button")
	WebElement searchbtn;
	
	@FindBy(xpath="//div[@id='product-search']/div/div/div[3]/div/div/div[2]/div/h4/a[.='HTC Touch HD']")
	WebElement htcphone;
	
	public phonepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(45));
		this.js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}

	public phonepage phone() throws InterruptedException {
//		scrollandclick(phonebtn);
		
		scrollandsendkeys(searchbox,"HTC Touch HD");
		scrollandclick(searchbtn);
		scrollandclick(htcphone);
		return this;
	}
}
