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

public class camerapage extends basemethod{
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[7]")
	WebElement camerabtn;
	
	@FindBy(xpath="//div[@id='product-category']/div/div[@id='content']/div[2]/div[1]/div/div[2]/div[2]/button[3]")
	WebElement product1comparebtn;
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/button[3]")
	WebElement product2comparebtn;
	
	@FindBy(xpath="(//div[@class='alert alert-success alert-dismissible'])[1]")
	WebElement afteraddingtocompare;
	
	@FindBy(xpath="//body/div[2]/div[2]/div[1]/div[1]/div[2]/div/a")
	WebElement productcompare;
	
	@FindBy(xpath="(//button[normalize-space()='×'])[1]")
	WebElement closebtnnotifications;
	
	public camerapage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(45)); 
        this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
	}


	public camerapage camera1() throws InterruptedException {
		scrollandclick(camerabtn);
		scrollandclick(product1comparebtn);
		datacheckingonlyvisible(afteraddingtocompare);
		Thread.sleep(2000);
		return this;
	}
	
	public camerapage camera2() throws InterruptedException {
		scrollandclick(camerabtn);
		scrollandclick(product2comparebtn);
		datacheckingonlyvisible(afteraddingtocompare);
		
		scrollandclick(productcompare);
		for(int i = 0; i < 5; i++) {
		    js.executeScript("window.scrollBy(0, 100);");
		    Thread.sleep(1000);
		}

		return this;
	}
	
	@FindBy(xpath="(//a[contains(text(),'Remove')])[1]")
	WebElement product1remove;
	
	@FindBy(xpath="(//div[@class='alert alert-success alert-dismissible'])[1]")
	WebElement afterremoving;
	
	public camerapage remove() throws InterruptedException {
		scrollandclick(product1remove);
		datacheckingonlyvisible(afterremoving);
		Thread.sleep(2000);
		
		scrollandclick(product1remove);
		datacheckingonlyvisible(afterremoving);
		Thread.sleep(2000);
		
		return this;
	}
	
	@FindBy(xpath="//div[@id=\"product-compare\"]/div/div[1]/p[.='You have not chosen any products to compare.']")
	WebElement productinfo;
	
	@FindBy(xpath="//div[@id='content']/div/div/a[.='Continue']")
	WebElement continuebtn;
	
	public camerapage productinfocollect() throws InterruptedException {
		informationdatachecking(productinfo,continuebtn);
		return this;
	}
}
