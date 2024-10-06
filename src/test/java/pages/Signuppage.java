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

public class Signuppage extends basemethod{

	public Signuppage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(45));
		this.js=(JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
  
	@FindBy(xpath="//body/nav/div/div[2]/ul/li[2]/a[@title='My Account']")
	WebElement myaccountbtn;
	
	@FindBy(xpath="//body/nav/div/div[2]/ul/li[2]/ul/li[1]")
	WebElement registerbtn;
	
	@FindBy(xpath="//body/div[2]/div[1]/div/form/fieldset/div[2]/div/input[@name='firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//body/div[2]/div[1]/div/form/fieldset/div[3]/div/input[@name='lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//body/div[2]/div[1]/div/form/fieldset/div[4]/div/input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//body/div[2]/div[1]/div/form/fieldset/div[5]/div/input[@name='telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//body/div[2]/div[1]/div/form/fieldset[2]/div[1]/div/input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//body/div[2]/div[1]/div/form/fieldset[2]/div[2]/div/input[@name='confirm']")
	WebElement confirmpassword;
	
	@FindBy(xpath="//body/div[2]/div[1]/div/form/fieldset[3]/div/div/label[1]/input")
	WebElement newslettersubscribe;
	
	@FindBy(xpath="//body/div[2]/div[1]/div/form/div/div/input[1]")
	WebElement privacy;
	
	@FindBy(xpath="//body/div[2]/div[1]/div/form/div/div/input[2]")
	WebElement continuebtn;
	
	@FindBy(xpath="//div[@id='common-success']/div/div/h1")
	WebElement h1heading;
	
	@FindBy(xpath="//div[@id='common-success']/div/div/p[1]")
	WebElement pheading;
	
	@FindBy(xpath="//div[@id='account-register']/div[1]")
	WebElement emailexist; 
	
	public Signuppage signup(String firstnamevalue,String lastnamevalue,String emailvalue,String telephonevalue,String passwordvalue,String confirmpasswordvalue) throws InterruptedException {
		scrollandclick(myaccountbtn);
		scrollandclick(registerbtn);
		scrollandsendkeys(firstname,firstnamevalue);
		scrollandsendkeys(lastname,lastnamevalue);
		scrollandsendkeys(email,emailvalue);
		scrollandsendkeys(telephone,telephonevalue);
		scrollandsendkeys(password,passwordvalue);
		scrollandsendkeys(confirmpassword,confirmpasswordvalue);
		scrollandclick(newslettersubscribe);
		scrollandclick(privacy);
		scrollandclick(continuebtn);
		checknotprintthis(h1heading,emailexist);
		
		
		return this;
	}
}
