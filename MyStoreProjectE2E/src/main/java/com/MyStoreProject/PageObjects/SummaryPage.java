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
public class SummaryPage {

	WebDriver driver;

	@FindBy(id = "total_price")
	private WebElement totalPrice;

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	private WebElement ProceedToCheckout;

	public SummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String total_price() {
		String actual = pageActions.webElement_getText(driver, totalPrice);
		return actual;
	}

	public AddressPage ProceedToCheckout() {
		pageActions.webElement_click(driver, ProceedToCheckout);
		return new AddressPage(driver);

	}
	
}
