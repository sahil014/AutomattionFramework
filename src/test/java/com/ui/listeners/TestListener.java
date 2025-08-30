package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utilities.BrowserUtility;
import com.utilities.ExtentReportUtility;
import com.utilities.LoggerUtility;

public class TestListener implements ITestListener{
	Logger logger=LoggerUtility.getLogger(this.getClass());
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest	extentTest;
		
	 public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());    
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	 }

	 public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+"-->"+" Passed");    
		ExtentReportUtility.getTest().log(Status.PASS,result.getMethod().getMethodName()+"-->"+" Passed");
	 }
	 
	 public void onTestFailure(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+"-->"+" Failed");    
		logger.info(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL,result.getMethod().getMethodName()+"-->"+" Failed");
	    ExtentReportUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
	    Object testClass=result.getInstance();
	    BrowserUtility browserUtility=((TestBase)testClass).getInstance();
	    if(browserUtility!=null) {
	    logger.info("Capturing the screenshot for the failed test cases");
	    String screenshotPath=browserUtility.takeScreenshot(result.getMethod().getMethodName());
	    logger.info("Attaching screenshot to the file");
	    ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	    }
	    else {
	    	logger.info("BrowserUtility was null, couldnot capture the screenshot");
	    }
	 }
	 
	 public  void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod()+"-->"+" Skipped");    
		ExtentReportUtility.getTest().log(Status.SKIP,result.getMethod().getMethodName()+"-->"+" SKIP");
	 }
	 
	 public void onStart(ITestContext context) {
		logger.info("Test Suite Started");    
		ExtentReportUtility.setupSparkReporter("report.html");
	 }
	 
	 public void onFinish(ITestContext context) {
	    logger.info("Test Suite Completed"); 	    
	    ExtentReportUtility.flushReport();
	 }
}
