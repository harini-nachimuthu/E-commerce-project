package tests;

import org.testng.annotations.Test;

import base.basemethod;
import pages.desktoppage;
import pages.phonepage;

public class phonetests extends basemethod{
  @Test(priority=8,description="Added phone to cart and checkout done")
  public void phonetesting() throws InterruptedException {
	  phonepage phones=new phonepage(driver);
	  phones.phone();
	  desktoppage desktop=new desktoppage(driver);
	  desktop.addandfinal();
	  desktop.checkout();
  }
}
