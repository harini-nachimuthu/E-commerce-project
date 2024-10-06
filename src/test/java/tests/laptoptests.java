package tests;

import org.testng.annotations.Test;

import base.basemethod;
import pages.desktoppage;
import pages.laptoppage;

public class laptoptests extends basemethod{
  @Test(priority=4,description="Adding laptop to cart and checkout done")
  public void laptopproducts() throws InterruptedException {
	  
	  laptoppage lappage=new laptoppage(driver);
	  lappage.laptopselection();
	  desktoppage desktop=new desktoppage(driver);
	  desktop.addandfinal();
	  desktop.checkout();
  }
}
