/**
 * 
 */
package com.MyStoreProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStoreProject.Actions.pageActions;
import com.MyStoreProject.base.baseClass;

/**
 * @author Venu_Cherukuri
 *
 */
public class LoginPage extends baseClass {

	public WebDriver driver;

	@FindBy(id = "email_create")
	private WebElement signUp_emailAddress;

	@FindBy(id = "email")
	private WebElement signIn_emailAddress;

	@FindBy(id = "passwd")
	private WebElement signIn_password;

	@FindBy(id = "SubmitCreate")
	private WebElement createAccount;

	@FindBy(id = "SubmitLogin")
	private WebElement signIn;

	@FindBy(className = "account")
	private WebElement myAccount;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void signUp_emailAddress(String email) {
		pageActions.webElement_SendKeys(driver, signUp_emailAddress, email);
	}

	public void signIn_emailAddress(String email) {
		pageActions.webElement_SendKeys(driver, signIn_emailAddress, email);
	}

	public void signIn_password(String pwd) {
		pageActions.webElement_SendKeys(driver, signIn_password, pwd);

	}

	public void SubmitCreate() {
		pageActions.webElement_click(driver, createAccount);
	}

	public SearchResultsPage SubmitLogin() {
		pageActions.webElement_click(driver, signIn);
		return new SearchResultsPage(driver);
	}

	public String getTitle() {
		String titleOfThePage = pageActions.webElement_getTitle(driver);
		return titleOfThePage;
	}

	public String validateMyAccount() {
		String myAccountName = pageActions.webElement_getText(driver, myAccount);
		return myAccountName;
	}

}
