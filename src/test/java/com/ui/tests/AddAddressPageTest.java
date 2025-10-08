package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccount;
import com.ui.pojo.AddressPojo;
import com.utilities.FakeAddressUtiliy;

public class AddAddressPageTest extends TestBase{
  private MyAccount myAccountPageObject;
  private AddressPage addressPageObject;
  private AddressPojo address;
	
  @BeforeMethod
	public void setup() {
		myAccountPageObject=homePageObject.goToLoginPage().doLoginWith("Sahilnarang014@gmail.com", "Sahil@12345");
	    address=FakeAddressUtiliy.getFakeAddress();
  }
	
	@Test
	public void addNewAddress() throws InterruptedException {
	 String label=myAccountPageObject.goToAddressPage().saveAddress(address);
	 Assert.assertEquals(label,"OFFICEADDRESS");
	}
}
