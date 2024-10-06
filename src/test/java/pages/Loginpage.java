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

public class Loginpage extends basemethod{

	public Loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(45));
		this.js=(JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
  
	@FindBy(xpath="//body/nav/div/div[2]/ul/li[2]/ul/li[2]")
	WebElement loginbtn;
	
	@FindBy(xpath="//body/nav/div/div[2]/ul/li[2]/a[@title='My Account']")
	WebElement myaccountbtn;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emaillogin;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordlogin;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtnfinal;
	
	public Loginpage loginform(String email,String password) throws InterruptedException {
		scrollandclick(myaccountbtn);
		scrollandclick(loginbtn);
		scrollandsendkeys(emaillogin,email);
		scrollandsendkeys(passwordlogin,password);
		scrollandclick(loginbtnfinal);
		return this;
		
	}
}
