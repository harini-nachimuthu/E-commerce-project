package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basemethod;
import pages.Loginpage;

public class Logintest extends basemethod {
	
	@BeforeTest
	public void loginbefore() {
		excelsheet="e-commerce_website";
		sheetname="Login";
	}
	
  @Test(dataProvider="retrievedatafromexcel",priority=2,description="Login functionality is done here")
  public void loginform(String email,String password) throws InterruptedException {
	  Loginpage login=new Loginpage(driver);
	  login.loginform(email,password);
  }
}
