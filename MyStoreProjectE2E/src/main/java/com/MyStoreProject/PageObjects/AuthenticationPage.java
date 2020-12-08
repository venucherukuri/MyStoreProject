/**
 * 
 */
package com.MyStoreProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStoreProject.base.baseClass;

/**
 * @author Venu_Cherukuri
 *
 */
public class AuthenticationPage extends baseClass {
	
	@FindBy(name = "uniform-id_gender1")
	WebElement gender;

	@FindBy(id = "customer_firstname")
	WebElement customer_firstname;
	
	@FindBy(id = "customer_lastname")
	WebElement customer_lastname;
	
	@FindBy(id = "passwd")
	WebElement passwd;

	@FindBy(id = "days")
	WebElement days;
	
	@FindBy(id = "months")
	WebElement months;
	
	@FindBy(id = "years")
	WebElement years;
	
	@FindBy(id = "firstname")
	WebElement firstname;
	
	@FindBy(id = "lastname")
	WebElement lastname;
	
	@FindBy(id = "address1")
	WebElement address1;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "id_state")
	WebElement id_state;
	
	@FindBy(id = "postcode")
	WebElement postcode;
	
	@FindBy(id = "id_country")
	WebElement id_country;
	
	@FindBy(id = "phone_mobile")
	WebElement phone_mobile;
	
	@FindBy(id = "alias")
	WebElement alias;
	
	@FindBy(id = "submitAccount")
	WebElement submitAccount;
	

	public AuthenticationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
}
