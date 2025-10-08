package com.utilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

import com.constants.Browsers;

import static com.constants.Browsers.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private static WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(30L));
	}

	public BrowserUtility(Browsers browserName, Boolean isHeadless) {
		logger.info("launching the browser.." + isHeadless);
		if (browserName == CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait=new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait=new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
			}
		} else if (browserName == EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
				wait=new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
			}
		} else if (browserName == FIREFOX) {
			driver.set(new FirefoxDriver());
			wait=new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
		}
	}

	public void goToWebSite(String url) {
		driver.get().get(url);
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
	//	WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void clickOnCheckBox(By locator) {
		//	WebElement element = driver.get().findElement(locator);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element.click();
		}
	
	public void clickOn(WebElement element) {
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(textToEnter);
	}

	public void clearText(By locator) {
	//	WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
	//	WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(keyToEnter);
	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		select.selectByVisibleText(optionToSelect);
	}

	public static String getByVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public static String getByVisibleText(WebElement element) {
		return element.getText();
	}

	public static List<String> getAllByVisibleText(By locator) {
		List<WebElement> element = driver.get().findElements(locator);
		List<String> productList = new ArrayList<String>();
		for (WebElement e : element) {
			productList.add(getByVisibleText(e));
		}
		return productList;
	}
	
	public static List<WebElement> getAllTheWebElements(By locator){
		List<WebElement> element = driver.get().findElements(locator);		
		return element;
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + "-" + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}