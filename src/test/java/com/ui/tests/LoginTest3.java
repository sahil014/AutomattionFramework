package com.ui.tests;

import static com.constants.Browsers.CHROME;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utilities.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public final class LoginTest3 extends TestBase {
/*	
	@Test(description ="verifies the login functionality with valid user", groups= {"e2e", "sanity"},
		  dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider")
	
	public void loginTest(User user) throws InterruptedException {		 
		assertEquals(homePageObject.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(),"Sahil Narang");
	}

	@Test(description ="verifies the login functionality with valid user", groups= {"e2e", "sanity"},
			  dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginCsvDataProvider")
		
		public void loginTest2(User user) throws InterruptedException {		
		  assertEquals(homePageObject.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(),"Sahil Narang");
		}
	*/
	@Test(description ="verifies the login functionality with valid user", groups= {"e2e", "sanity"},
			  dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginExcelDataProvider", retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
		
		public void loginTest3(User user) throws InterruptedException {		 
		 assertEquals(homePageObject.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(),"Sahil Narang");
	}
}
