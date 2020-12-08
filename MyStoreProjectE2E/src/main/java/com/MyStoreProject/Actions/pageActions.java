/**
 * 
 */
package com.MyStoreProject.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.MyStoreProject.base.baseClass;

/**
 * @author Venu_Cherukuri
 *
 */
public class pageActions extends baseClass {
	
	public static void webElement_mouseHover(WebDriver ldriver, WebElement ele) {
		Actions action=new Actions(ldriver);
		action.moveToElement(ele);
	}

	public static void webElement_click(WebDriver ldriver, WebElement ele) {
		ele.click();
	}
	
	public static void webElement_JavaScriptclick(WebDriver ldriver, WebElement ele) {
		
		JavascriptExecutor js= (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click", ele);
	}

	public static void webElement_Search(WebDriver ldriver, WebElement ele, String search) {
		ele.sendKeys(search);
	}

	public static void webElement_ScrollPage(WebDriver ldriver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public static void webElement_SendKeys(WebDriver ldriver, WebElement ele, String value) {
		ele.sendKeys(value);
	}
	
	public static String webElement_getTitle(WebDriver ldriver) {
		return ldriver.getTitle();
	}
	
	public static String webElement_getCurrentURL(WebDriver ldriver) {
		return ldriver.getCurrentUrl();
	}
	
	public static String webElement_getText(WebDriver ldriver, WebElement ele) {
		String text= ele.getText();
		System.out.println("actual value:"+text);
		return text;
	}
	
	public static String webElement_JavaScriptGetText(WebDriver ldriver, WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		String value= js.executeScript("return document.getElementById('quantity_wanted').value").toString();
		System.out.println("actual value:"+value);
		return value;
	}
	
	public static String webElement_getValueAttribute(WebDriver driver, WebElement ele) {
		String actual= ele.getAttribute("Value");
		return actual;
	}
	
	public static void webElement_windowMaximize(WebDriver ldriver) {
		ldriver.manage().window().maximize();
	}
	
	public static void webElement_ImpicitTimeWait(WebDriver ldriver) {
		ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void webElement_pageTimeOut(WebDriver ldriver) {
		ldriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void webElement_ExplicitTimeWait(WebDriver ldriver, WebElement ele) {
		WebDriverWait wait=new WebDriverWait(ldriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) ele));
	}
	
	public static void keysEnter(WebDriver ldriver, WebElement ele) {
		ele.sendKeys(Keys.ENTER);
	}
	
	public static void webElement_isDisplayed(WebDriver ldriver, WebElement ele) {
		boolean value=ele.isDisplayed();
		
		if(value== true) {
			System.out.println("element is displayed");
		}
		
		else {
			System.out.println("element is not displayed");
		}
	}
	
	public static boolean webElement_isSelected(WebDriver ldriver, WebElement ele) {
		boolean value=ele.isSelected();
		
		if(value== true) {
			System.out.println("element is displayed");
		}
		
		else {
			System.out.println("element is not displayed");
		}
		
		return value;
	}
		
	public static void selectDropDown(WebDriver ldriver, WebElement ele, String value) {
		Select s=new Select(ele);
		s.selectByVisibleText(value);
	}
	
	public static String TakesScreenShot(WebDriver ldriver, String value) throws IOException {

		String dateformat=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		String destination=System.getProperty("user.dir")+ "/ScreenShots/" + value + "_" + dateformat + ".png";
		File file=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File(destination) );
		
		String newdestination="http://localhost:8080/job/MyStoreProject/ws/MyStoreProject/MyStoreProjectE2E/ScreenShots/"+value+"_"+dateformat+".png";
		
		return destination;
	}

	
}
