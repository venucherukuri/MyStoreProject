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
public class AddToCartPage {

	WebDriver driver;

	@FindBy(id = "color_14")
	private WebElement blueColor;

	@FindBy(id = "color_13")
	private WebElement OrangeColor;

	@FindBy(className = "icon-plus")
	private WebElement plusSymbol;

	@FindBy(id = "group_1")
	private WebElement selectSize;

	@FindBy(id = "add_to_cart")
	private WebElement addToCart;
	
	@FindBy(id ="quantity_wanted")
	WebElement quantitySelected;

	@FindBy(xpath = "//h1[@itemprop='name']")
	private WebElement productName;
	
	@FindBy(xpath = "//span[@class='cross']/h2")
	private WebElement displayMessage;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement ProceedToCheckout;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void increaeQuantity() {
		pageActions.webElement_click(driver, plusSymbol);
	}
	
	public String quantitySelected() {
		String quantity=pageActions.webElement_JavaScriptGetText(driver, quantitySelected);
		return quantity;
	}

	public String productName() {
		String prodName = pageActions.webElement_getText(driver, productName);
		return prodName;
	}

	public void selectSize(String value) {
		pageActions.selectDropDown(driver, selectSize, value);
	}

	public void selectColor(String color) {
		if (color.equalsIgnoreCase("blue")) {
			pageActions.webElement_click(driver, blueColor);
		}
		else if(color.equalsIgnoreCase("orange")) {
			pageActions.webElement_click(driver, OrangeColor);
		}
		else {
			System.out.println("default color is selected");
		}
	}

	public void clickAddToCart() {
		pageActions.webElement_click(driver, addToCart);
	}
	
	public String displayMessage() throws InterruptedException {
		Thread.sleep(10000);
		String displayMsg = pageActions.webElement_getText(driver, displayMessage);
		return displayMsg;
	}

	public SummaryPage ProceedToCheckout() {
		pageActions.webElement_click(driver, ProceedToCheckout);
		return new SummaryPage(driver);
	}

}
