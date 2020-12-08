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
public class IndexPage extends baseClass {
	
	public WebDriver driver;
	
	@FindBy(className = "login" )
	private WebElement signIn;
	
	public IndexPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPage clickSignin() throws InterruptedException {
		pageActions.webElement_click(driver, signIn);
		return new LoginPage(driver);
	}
	
	
}
