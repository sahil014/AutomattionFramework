package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.BrowserUtility;

public class ShippingPage extends BrowserUtility{

	private static final By PROCEED_TO_CHECKOUT_BUTTON=By.name("processCarrier");
	private static final By TERMS_AND_CONDITIONS_CHECKBOX=By.id("uniform-cgv");
	public ShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public ShippingPage clickOnTermsAndConditions() {
		clickOnCheckBox(TERMS_AND_CONDITIONS_CHECKBOX);
		return new ShippingPage(getDriver());
	}
	public PaymentPage goToPaymentPage() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON);
		return new PaymentPage(getDriver());
	}
}
