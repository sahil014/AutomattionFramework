package com.ui.tests;

import org.testng.annotations.Test;


import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.utilities.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public final class InvalidCredLoginTest extends TestBase {
	
     private static final String EMAIL_ADDRESS="Jio@gmail.com";
     private static final String PASSWORD="Jio@12345";
	@Test(description = "verifies the error message by logging the user with invalid credentials", groups = { "e2e",
			"sanity" })

	public void loginTest() {
		assertEquals(homePageObject.goToLoginPage().doLoginWithInvalidCredentails(EMAIL_ADDRESS,PASSWORD).getErrorMessage(),"Authentication failed.");
	}
}
