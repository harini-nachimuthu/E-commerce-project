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

public class desktoppage extends basemethod {
  
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[1]")
	WebElement desktopbtn;
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[1]/div[1]/a[@class='see-all']")
	WebElement showalldesktopbtn;
	
	@FindBy(xpath="(//a[normalize-space()='Palm Treo Pro'])[1]")
//	"//div[@id='product-category']/div/div/div[4]/div[9]/div/div[2]/div[1]/h4"
	WebElement palmtreoprobtn;
	
	@FindBy(xpath="//div[@id='content']/div[1]/div[2]/div[2]/div[1]/button[.='Add to Cart']")
	WebElement addtocartdesktop;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement afteraddingcart;
	
	public desktoppage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(45)); 
        this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
	}

	public desktoppage desktopproductadding() throws InterruptedException {
		scrollandclick(desktopbtn);
		scrollandclick(showalldesktopbtn);
		scrollandclick(palmtreoprobtn);
		return this;
	}
	
	public desktoppage addandfinal() throws InterruptedException {
		datachecking(addtocartdesktop);
		scrollandclick(addtocartdesktop);
		datacheckingonlyvisible(afteraddingcart);
		return this;
	}
	
	@FindBy(xpath="/html[1]/body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/button[1]")
	WebElement itemsadded;
	
	@FindBy(xpath="//body/header/div/div/div[3]/div/ul/li[2]/div/p/a[1]")
	WebElement viewcart;
	
	@FindBy(xpath="//div[@id='content']/div[@class='buttons clearfix']/div[2]")
	WebElement checkout;
	
	@FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible'])[1]")
	WebElement alertmsg;
	
	public desktoppage checkout() throws InterruptedException {
		Thread.sleep(2000);
		scrollandclick(itemsadded);
		scrollandclick(viewcart);
		scrollandclick(checkout);
		datacheckingonlyvisible(alertmsg);
		return this;
	}
}
