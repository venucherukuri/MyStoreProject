/**
 * 
 */
package com.MyStoreProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStoreProject.Actions.pageActions;

/**
 * @author Venu_Cherukuri
 *
 */
public class SearchResultsPage {
	
	private WebDriver driver;
	
	@FindBy(id= "search_query_top")
	private WebElement seachButton;
	
	@FindBy(className =  "available-now")
	private WebElement stockAvailability;
	
	@FindBy(className =  "product-container")
	private WebElement productDetails;
	
	@FindBy(className = "product-image-container")
	WebElement mouseHover;
	
	@FindBy(xpath = "//a[@title='Addresses']")
	WebElement MyAddresses;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchButton(String value) {
		pageActions.webElement_SendKeys(driver, seachButton, value);
	}
	
	public String stockAvailability() {
		String actual=pageActions.webElement_getText(driver, stockAvailability);
		return actual;
	}
	
	public void keysEnter() {
		pageActions.keysEnter(driver, seachButton);
	}
	
	public void mouseHover() {
		pageActions.webElement_mouseHover(driver, mouseHover);
	}
	
	public AddToCartPage checkProductDetails() {
		pageActions.webElement_click(driver, productDetails);
		return new AddToCartPage(driver);
	}

	public AddressPage ClickMyAddresses() {
		pageActions.webElement_click(driver, MyAddresses);
		return new AddressPage(driver);
	}
}
