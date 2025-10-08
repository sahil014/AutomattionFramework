package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;
import com.utilities.LoggerUtility;

public final class MyAccount extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");
	private static final By ADD_MY_FIRST_LOCATOR=By.xpath("//a[@title='Add my first address']");
	Logger logger=LoggerUtility.getLogger(this.getClass());

	public MyAccount(WebDriver driver) {
		super(driver);

	}

	public String getUserName() {
		return getByVisibleText(USER_NAME_LOCATOR);
	}

	public SearchPageResult searchForAProduct(String productName) {
		logger.info("Inputting text into seqarh field");
		enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		SearchPageResult searchPageResultObject = new SearchPageResult(getDriver());
		return searchPageResultObject;

	}
	
	public AddressPage goToAddressPage() {
	  clickOn(ADD_MY_FIRST_LOCATOR);	
	  return new AddressPage(getDriver());
	}
}
