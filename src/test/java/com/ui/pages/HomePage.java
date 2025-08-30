package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browsers;
import static com.constants.Environment.*;
import com.utilities.BrowserUtility;
import com.utilities.JSONUtility;
import com.utilities.LoggerUtility;

public final class HomePage extends BrowserUtility{
	
	Logger logger=LoggerUtility.getLogger(this.getClass());
	private static final By Sign_IN_Locator=By.xpath("//a[contains(text(), 'Sign in')]");
	public HomePage(Browsers browsername,boolean isHeadless) {
		super(browsername,isHeadless);
	   // goToWebSite(readProperty(QA, "URL"));
		logger.info("Fetching and visiting the URL");
		goToWebSite(JSONUtility.readJSON(QA).getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebSite(JSONUtility.readJSON(QA).getUrl());
	}
	
	public LoginPage goToLoginPage() {
		logger.info("Clicking on SignIn Button");
		clickOn(Sign_IN_Locator);
		LoginPage loginpageobject=new LoginPage(getDriver());
		return loginpageobject;
	}

	public void quit() {
		getDriver().quit();
		
	}
	
}
