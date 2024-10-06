package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.basemethod;

public class Listenerclass extends basemethod implements ITestListener{
	
	ExtentReports extents=Extentreport.getreport();
	ExtentTest test;
	String browsername=null;
	
	@Override
	public void onTestStart(ITestResult result) {
		Test testAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
        ITestContext context=result.getTestContext();
        browsername=context.getCurrentXmlTest().getParameter("browser");
        if (testAnnotation != null) {
            String testName = result.getMethod().getMethodName();
            String testDescription = testAnnotation.description();
            
            
            test = extents.createTest(testName)
                .assignAuthor("Harini")
                .assignDevice(browsername);

            test.log(Status.INFO, "Description: " + testDescription);
        } else {
           
            test = extents.createTest(result.getMethod().getMethodName())
                .assignAuthor("Unknown")
                .assignCategory("General")
                .assignDevice("chrome");
        }
		test.log(Status.PASS,"Test passed : "+result.getMethod().getMethodName());
	}
  
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test passed : "+result.getMethod().getMethodName());
		
		 String filepath = null;
		    try {
		        filepath = takeScreenshot(browsername,result.getMethod().getMethodName());
		        System.out.println("Test passed :: Screenshot path location : "+filepath);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
	    
	    String filepath = null;
	    try {
	        filepath = takeScreenshot(browsername,result.getMethod().getMethodName());
	        System.out.println(" Test failed :: Screenshot path location : "+filepath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,"On test Skipped : "+result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		test.log(Status.FAIL,"On test failed but within success percentage : "+result.getMethod().getMethodName());
	}
	
//	@Override
//	public void onStart(ITestContext context) {
//		test.log(Status.INFO, "test Started : "+context.getName());
//	}
	
	@Override
	public void onFinish(ITestContext context) {
		extents.flush();
	}
}
