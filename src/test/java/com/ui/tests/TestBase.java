package com.ui.tests;

import static com.constants.Browsers.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browsers;
import com.ui.pages.HomePage;
import com.utilities.BrowserUtility;
import com.utilities.LambdaTest;
import com.utilities.LoggerUtility;

public class TestBase {

	protected HomePage homePageObject;
	Logger logger=LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	
	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod
	public void setup(@Optional("chrome")String browser, 
			          @Optional("false")boolean isLambdaTest, 
			          @Optional("true")boolean isHeadless, ITestResult result) {
		
		  
	WebDriver lambdaDriver;	
	this.isLambdaTest=isLambdaTest;
	if(isLambdaTest) {
		lambdaDriver=LambdaTest.intializeLambda(browser, result.getMethod().getMethodName());
		homePageObject=new HomePage(lambdaDriver);
	}	
	else {
    logger.info("loading home page of the website");
	homePageObject=new HomePage(Browsers.valueOf(browser.toUpperCase()),isHeadless);	
	}
	}
	
	public BrowserUtility getInstance() {
		return homePageObject;
	}
	
	@AfterMethod(description="Tear down the browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTest.quitSession();
		}
		else {
			homePageObject.quit();
		}
		
	}
	
}
