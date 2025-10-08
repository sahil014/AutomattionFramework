package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPojo;
import com.utilities.BrowserUtility;
import com.utilities.LoggerUtility;

public class AddressPage extends BrowserUtility{
	Logger logger=LoggerUtility.getLogger(this.getClass());
    private static final By COMPANY_LOCATOR=By.id("company");
    private static final By ADDRESS_LOCATOR=By.id("address1");
    private static final By ADDRESS_LINE_2_LOCATOR=By.id("address2");
    private static final By CITY_LOCATOR=By.id("city");
    private static final By ZIP_CODE=By.id("postcode");
    private static final By HOME_PHONE=By.id("phone");
    private static final By MOBILE_PHONE=By.id("phone_mobile");
    private static final By ADDITIONAL_INFORMATION=By.id("other");
    private static final By ADDRESS_TITLE=By.id("alias");
    private static final By STATE=By.id("id_state");
    private static final By SAVE_BUTTON=By.id("submitAddress");
    private static final By ADDRESS_LABEL=By.tagName("h3");
	public AddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String saveAddress(AddressPojo address) throws InterruptedException {
		enterText(COMPANY_LOCATOR,address.getCompany());
		enterText(ADDRESS_LOCATOR,address.getAddress1());  		
		enterText(ADDRESS_LINE_2_LOCATOR,address.getAddress2());	
		enterText(CITY_LOCATOR,address.getCity());
		enterText(ZIP_CODE,address.getZipcode());	
		enterText(HOME_PHONE,address.getHome_phone());
		enterText(MOBILE_PHONE,address.getMobile_phone());
		enterText(ADDITIONAL_INFORMATION,address.getAdditional_info());
		clearText(ADDRESS_TITLE);
		enterText(ADDRESS_TITLE,address.getAddress_title());
		selectFromDropDown(STATE,address.getState());
		logger.info("clicking on save button");
		clickOn(SAVE_BUTTON);
	/*	logger.info("going on sleep for 5s..");
		Thread.sleep(5000);
		logger.info("scrolling using js");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,700)");
		logger.info("finding the address label");*/
		return getByVisibleText(ADDRESS_LABEL);
	}
}
