package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basemethod;
import pages.Signuppage;

public class Signuptest extends basemethod{
	
	@BeforeTest
	public void beforesign() {
		excelsheet="e-commerce_website";
		sheetname="Signup";
	}
	
  @Test(dataProvider="retrievedatafromexcel",priority=1,description="Signup functionality is done")
  public void signupform(String firstnamevalue,String lastnamevalue,String emailvalue,String telephonevalue,String passwordvalue,String confirmpasswordvalue) throws InterruptedException {
	  Signuppage sign=new Signuppage(driver);
	  sign.signup(firstnamevalue, lastnamevalue, emailvalue, telephonevalue, passwordvalue, confirmpasswordvalue);
  }
}
