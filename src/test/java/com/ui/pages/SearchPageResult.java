package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;
import com.utilities.LoggerUtility;
import com.ui.pages.*;

public class SearchPageResult extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By PRODUCT_LISTS=By.xpath("//h5[@itemprop=\"name\"]/a");
	Logger logger=LoggerUtility.getLogger(this.getClass());

	public SearchPageResult(WebDriver driver) {
		super(driver);
	}

	public String getSearchTitle() {
		return getByVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public boolean isSearchTermPresentInProductList(String searchTerm) {
		logger.info("Verrifying that search list matches with input or not");
		List<String> keywords=Arrays.asList(searchTerm.toLowerCase().split(" "));
		logger.info("Getting the products list");
		List<String> productNameList=getAllByVisibleText(PRODUCT_LISTS);
		logger.info("Comparing the products with the supplied input");
		boolean result=productNameList.stream()
		.anyMatch(name ->(keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;
	}
	
	public ProductDetailsPage clickonTheProduct(int index) {
		clickOn(getAllTheWebElements(PRODUCT_LISTS).get(index));
		ProductDetailsPage productDetailsPageobj=new ProductDetailsPage(getDriver());
		return productDetailsPageobj;
	}

}
