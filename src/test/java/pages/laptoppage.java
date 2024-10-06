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

public class laptoppage extends basemethod{
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[2]")
	WebElement laptopbtn;
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[2]/div/div/ul/li[1]")
	WebElement Macbtn;

	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[2]/div/div/ul/li[2]")
	WebElement windowsbtn;
	
	@FindBy(xpath="//div[@id='product-category']/div/div[1]/p[.='There are no products to list in this category.']")
	WebElement informationpresent;
	
	@FindBy(xpath="//div[@id='content']/div/div/a[.='Continue']")
	WebElement afterinfocontinue;
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[2]/div/a")
	WebElement showallbtn;
	
	@FindBy(xpath="//body/div[2]/div/div/div[4]/div[5]/div/div[2]/div/h4/a[.='Sony VAIO']")
	WebElement sonylaptop;
	
	public laptoppage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.js=(JavascriptExecutor)driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(45));
		PageFactory.initElements(driver, this);
	}

	public laptoppage laptopselection() throws InterruptedException {
		scrollandclick(laptopbtn);
		scrollandclick(Macbtn);
		scrollandclick(laptopbtn);
		scrollandclick(windowsbtn);
		scrollandclick(laptopbtn);
		scrollandclick(showallbtn);
		scrollandclick(sonylaptop);
		return this;
	}
}
