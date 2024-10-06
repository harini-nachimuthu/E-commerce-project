package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreport{
	 public static ExtentReports getreport() {
		 String path="C:\\Users\\harin\\eclipse-workspace\\E-commercewebsite\\Report_generation\\index.html";
		 ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		 reporter.config().setReportName("E-commerce website");
		 reporter.config().setDocumentTitle("Automation testing of shopping website");
		 reporter.config().setTheme(Theme.DARK);
		 
		 ExtentReports extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("System path info : ", path);
		 return extent; 
	 }
}
