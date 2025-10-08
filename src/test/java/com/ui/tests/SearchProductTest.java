package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.MyAccount;

@Listeners({com.ui.listeners.TestListener.class})
public class SearchProductTest extends TestBase{
	
	private MyAccount myAccountPageObject;
	private static final String SEARCH_TERM="Printed Summer Dress";
	@BeforeMethod
	public void setup() {
		myAccountPageObject=homePageObject.goToLoginPage().doLoginWith("Sahilnarang014@gmail.com", "Sahil@12345");
	}
	
  @Test(description="Verify if her logged in user is able to search the product and correct products should be displayed")
  public void verifyproductSearchTest() {
	  boolean actualResult=myAccountPageObject.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);    
	  Assert.assertEquals(actualResult, true);
  }
}
