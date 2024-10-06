package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.basemethod;
import pages.desktoppage;

public class desktoptest extends basemethod {
  

@Test(priority=3,description="Adding desktop to cart and checkout done")
  public void desktopproduct() throws InterruptedException {
	  desktoppage desk=new desktoppage(driver);
	  desk.desktopproductadding();
	  desk.addandfinal();
	  desk.checkout();
  }
}
