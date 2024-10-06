package tests;

import org.testng.annotations.Test;

import base.basemethod;
import pages.componentspage;
import pages.softwarepage;

public class softwaretest extends basemethod{
  @Test(priority=7,description="Components checking")
  public void softwaretesting() throws InterruptedException {
	  softwarepage soft=new softwarepage(driver);
	  soft.software();
	  componentspage component=new componentspage(driver);
	  component.noproductcontinue();
  }
}
