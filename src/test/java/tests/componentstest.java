package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.basemethod;
import pages.componentspage;
import pages.desktoppage;

public class componentstest extends basemethod{
  @Test(priority=5,description="Adding monitor to cart and checkout is done")
  public void components() throws InterruptedException, IOException  {
	  componentspage compage=new componentspage(driver);
	  compage.component();
	  compage.apple();
  }
}
