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
public class OrderConfirmationPage {
	
	WebDriver driver;

	@FindBy(xpath =   "//button[@type='submit']")
	private WebElement IConfirmMyOrder;


	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void IConfirmMyOrder() {
		System.out.println("My order is placed");
	}

}
