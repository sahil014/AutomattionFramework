package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browsers;
import com.constants.Size;
import com.utilities.BrowserUtility;
import com.ui.pages.*;

public class ProductDetailsPage extends BrowserUtility{
	
	private static final By SIZE_DROP_DOWN=By.id("group_1");
	private static final By PRODUCT_COLOR_WHITE=By.xpath("//a[@title='White']");
	private static final By ADD_TO_CART_BUTTON=By.name("Submit");
    private static final By PROCEED_TO_CHECKOUT_BUTTON= By.xpath("//a[@title='Proceed to checkout']");
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ProductDetailsPage changeSize(Size size) {
		selectFromDropDown(SIZE_DROP_DOWN,size.toString());
		return new ProductDetailsPage(getDriver());
	}
	
	public ProductDetailsPage changeColorTOWhite() {
        clickOn(PRODUCT_COLOR_WHITE);
        return new ProductDetailsPage(getDriver());
	}
	
	public ProductDetailsPage clickOnAddToCart() {
		clickOn(ADD_TO_CART_BUTTON);
		return new ProductDetailsPage(getDriver()); 
	}
	
	public ShoppingCartPage clickOnProceedToCheckOut() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON);
		return new ShoppingCartPage(getDriver());
	}

}
