package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public class PaymentPage extends BrowserUtility{

	private static final By PAY_BY_BANK_WIRE=By.xpath("//a[@class='bankwire']");
	private static final By CONFIRM_ORDER=By.xpath("//p[contains(@class,'cart_navigation')]/button");
	private static final By ORDER_SUCCESS_MESSAGE=By.xpath("//p[contains(@class,'success')]");
	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String  placeTheOrder() throws InterruptedException{
		clickOn(PAY_BY_BANK_WIRE);
		clickOn(CONFIRM_ORDER);
		return getByVisibleText(ORDER_SUCCESS_MESSAGE);	
	}
	

}
