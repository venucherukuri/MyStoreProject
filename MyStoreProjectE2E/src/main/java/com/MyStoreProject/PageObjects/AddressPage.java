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
public class AddressPage {

	WebDriver driver;

	@FindBy(id = "addressesAreEquals")
	private WebElement sameAddress;

	@FindBy(name = "processAddress")
	private WebElement ProceedToCheckout;

	@FindBy(className = "page-subheading")
	private WebElement MyAddress;
	
	public AddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectSameAddress() {
		boolean value=pageActions.webElement_isSelected(driver, sameAddress);
		if (value==false)
		 pageActions.webElement_click(driver, sameAddress);
		else
			System.out.println("check box is already selected and delivery adddress is same as billing address");
	}

	public ShippingPage ProceedToCheckout() {
		pageActions.webElement_click(driver, ProceedToCheckout);
		return new ShippingPage(driver);

	}

	public String ValidateAddress() {
		String Address=pageActions.webElement_getText(driver, MyAddress);
		return Address;

	}
	
}
