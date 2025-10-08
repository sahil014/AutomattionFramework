package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public class LoginPage extends BrowserUtility {

	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_BOX_LOCATOR = By.id("SubmitLogin");
	private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//li[contains(text(),'Authentication failed.')]");

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public MyAccount doLoginWith(String email, String password) {

		enterText(EMAIL_TEXT_BOX_LOCATOR, email);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_BOX_LOCATOR);
		MyAccount myaccountobject = new MyAccount(getDriver());
		return myaccountobject;
	}

	public LoginPage doLoginWithInvalidCredentails(String email, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, email);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_BOX_LOCATOR);
		LoginPage loginPageObject = new LoginPage(getDriver());
		return loginPageObject;
	}

	public String getErrorMessage() {
		return getByVisibleText(ERROR_MESSAGE_LOCATOR);
	}

}
