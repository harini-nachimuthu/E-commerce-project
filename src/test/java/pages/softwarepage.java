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

public class softwarepage extends basemethod {
	
	@FindBy(xpath="//div[@class='container']/nav/div[2]/ul/li[5]")
	WebElement softwarebtn;
	
	public softwarepage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(45));
		this.js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}

	

	public softwarepage software() throws InterruptedException {
		scrollandclick(softwarebtn);
		return this;
	}
}
