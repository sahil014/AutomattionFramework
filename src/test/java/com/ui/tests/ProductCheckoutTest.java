package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchPageResult;

public class ProductCheckoutTest extends TestBase{
   private static final String SEARCH_TERM="Printed Summer dress";
   private SearchPageResult searchPageResultObject;
	
   @BeforeMethod
     public void setup() {
	   searchPageResultObject=homePageObject.goToLoginPage().doLoginWith("Sahilnarang014@gmail.com", "Sahil@12345").searchForAProduct(SEARCH_TERM);
   }
	
	
	
	@Test(description="Verify if a loggedin user is able to buy a dress", groups= {"e2e", "smoke", "sanity"})
	public void checkOut() throws InterruptedException {
	String result=searchPageResultObject.clickonTheProduct(1).changeSize(L).changeColorTOWhite().clickOnAddToCart().clickOnProceedToCheckOut()
		.gotToConfirmAddressPage().goToShippingPage().clickOnTermsAndConditions().goToPaymentPage().placeTheOrder();
	
      Assert.assertTrue(result.contains("complete"));;
	}
}
