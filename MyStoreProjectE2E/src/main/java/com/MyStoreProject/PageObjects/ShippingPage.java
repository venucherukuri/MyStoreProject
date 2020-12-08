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
public class ShippingPage {

	WebDriver driver;

	@FindBy(id = "cgv")
	private WebElement TermsCheckBox;

	@FindBy(name = "processCarrier")
	private WebElement ProceedToCheckout;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void TermsCheckBox() {
		boolean value = pageActions.webElement_isSelected(driver, TermsCheckBox);
		if (value == false) {
			pageActions.webElement_click(driver, TermsCheckBox);
			System.out.println("terms and conditions acceppted");
		} else
			System.out.println("check box is already selected and terms and conditions acceppted");
	}

	public PaymentPage ProceedToCheckout() {
		pageActions.webElement_click(driver, ProceedToCheckout);
		return new PaymentPage(driver);

	}

}
