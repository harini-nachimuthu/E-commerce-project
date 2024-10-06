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

public class tabletpage extends basemethod {
  
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[4]")
	WebElement tabletbtn;
	
	@FindBy(xpath="//div[@id='product-category']/div/div/div[2]/div/div/div[2]/div/h4/a[.='Samsung Galaxy Tab 10.1']")
	WebElement samsungtablet;
	
	public tabletpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(45));
		this.js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}

	public tabletpage tablet() throws InterruptedException {
		scrollandclick(tabletbtn);
		scrollandclick(samsungtablet);
//		js.executeScript("window.scrollBy(0,100)","");
		
		return this;
	}
}
