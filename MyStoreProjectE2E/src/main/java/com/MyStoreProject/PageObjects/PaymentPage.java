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
public class PaymentPage {
	
	WebDriver driver;

	@FindBy(className =  "cheque")
	private WebElement payByCheck;

	@FindBy(className =  "bankwire")
	private WebElement payByBankWire;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public OrderConfirmationPage payByBankWire() {
		pageActions.webElement_click(driver, payByBankWire);
		return new OrderConfirmationPage(driver);
	}

	public OrderConfirmationPage payByCheck() {
		pageActions.webElement_click(driver, payByCheck);
		return new OrderConfirmationPage(driver);

	}


}
