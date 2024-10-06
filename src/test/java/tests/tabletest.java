package tests;

import org.testng.annotations.Test;

import base.basemethod;
import pages.tabletpage;

public class tabletest extends basemethod{
  @Test(priority=6,description="tablet product checking")
  public void tablet() throws InterruptedException {
	  tabletpage tablettesting=new tabletpage(driver);
	  tablettesting.tablet();
  }
}
