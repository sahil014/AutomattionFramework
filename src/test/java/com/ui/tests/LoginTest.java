package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utilities.BrowserUtility;
public class LoginTest extends BrowserUtility { 

	public LoginTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
	/*	WebDriver wd=new ChromeDriver();
		BrowserUtility browserutility=new BrowserUtility(wd);
		browserutility.goToWebSite("http:automationpractice.pl/index.php?");
        browserutility.maximizeWindow();
        By signinLocator=By.xpath("//a[contains(text(), 'Sign in')]");
        browserutility.clickOn(signinLocator);
        
        By emailLocator=By.id("email");
        browserutility.enterText(emailLocator, "sahilnarang014@gmail.com");
        
        By passwordLocator=By.id("passwd");
        browserutility.enterText(passwordLocator, "Sahil@12345");
        
        By submitLocator=By.id("SubmitLogin");
        WebElement submit_button=wd.findElement(submitLocator);
        submit_button.click();
        System.out.println("Test"); */
	}

}
