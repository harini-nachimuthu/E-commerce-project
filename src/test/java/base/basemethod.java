package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.utility;

public class basemethod extends utility{
	
 @Parameters({"browser","url"})
//	String url="https://tutorialsninja.com/demo/";
//	String browser="chrome";
 @BeforeMethod
  public void beforemethodstart(String browser,String url) {
	  launchingbrowserandurl(browser,url);
  }
  
 @DataProvider(name="retrievedatafromexcel")
 public String[][] retrieveexceldata() throws IOException{
	 String[][] datas=readdatafromexcel(excelsheet,sheetname);
	 return datas;
 }
 
  @AfterMethod
  public void aftermethodcomplete() {
	  quitbrowser();
  }
}
