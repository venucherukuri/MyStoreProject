/**
* 
*/
package MyStoreProject.MyStoreProjectE2E;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStoreProject.PageObjects.AddToCartPage;
import com.MyStoreProject.PageObjects.AddressPage;
import com.MyStoreProject.PageObjects.IndexPage;
import com.MyStoreProject.PageObjects.LoginPage;
import com.MyStoreProject.PageObjects.OrderConfirmationPage;
import com.MyStoreProject.PageObjects.PaymentPage;
import com.MyStoreProject.PageObjects.SearchResultsPage;
import com.MyStoreProject.PageObjects.ShippingPage;
import com.MyStoreProject.PageObjects.SummaryPage;
import com.MyStoreProject.base.baseClass;

/**
 * @author Venu_Cherukuri
 *
 */
public class placeOrder extends baseClass{
	
	
	IndexPage iPage;
	LoginPage lpage;
	SearchResultsPage spage;
	AddToCartPage addPage;
	SummaryPage summarypage;
	AddressPage aPage;
	ShippingPage shipPage;
	PaymentPage payPage;
	OrderConfirmationPage orderPage;
	public static Logger log;
	

	@BeforeClass(alwaysRun = true)
	@Parameters({ "url", "browser" })
	public void setup(String url, String browser) throws IOException {
		System.out.println("inside setup method");
		initialiseDriver(url, browser);
		System.out.println("*****************************************************************");

		log = Logger.getLogger(placeOrder.class.getName());
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/Configuration/Log4j.properties");

		log.info("log4j is enabled");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws IOException {
		System.out.println("inside tearDown method");
		driver.close();
		System.out.println("*****************************************************************");
	}

	@Test(groups = "progression")
	public void validateLogin() throws InterruptedException {

		iPage = new IndexPage(driver);

		lpage = iPage.clickSignin();

		Thread.sleep(10000);
		
		lpage.signIn_emailAddress("admin@xyz.com");
		lpage.signIn_password("admin@123");
		lpage.SubmitLogin();

		String actual1 = lpage.validateMyAccount();

		Assert.assertEquals(actual1, "Akhil naik");

		System.out.println("signin is successful");
		System.out.println("*****************************************************************");
	}

	@Test(dependsOnMethods = "validateLogin", groups = "progression")
	public void searchProductAndCheckAvailability() {

		spage = new com.MyStoreProject.PageObjects.SearchResultsPage(driver);
		spage.searchButton("t-shirt");
		spage.keysEnter();
		String actual = spage.stockAvailability();
		String expected = "In stock";
		Assert.assertEquals(actual, expected);
		System.out.println("Stock is available");
		System.out.println("*****************************************************************");

	}

	@Test(dependsOnMethods = "searchProductAndCheckAvailability", groups = "progression")
	public void AddProductToTheCart() throws InterruptedException {

		// spage.mouseHover();
		addPage = spage.checkProductDetails();
		addPage.selectColor("blue");
		System.out.println("blue color is selected");

		addPage.selectSize("M");
		System.out.println("Medium size is selected");

		addPage.increaeQuantity();
		String quantitySelected = addPage.quantitySelected();
		String expected = "2";
		Assert.assertEquals(quantitySelected, expected);
		System.out.println("the quantity selected is :" + quantitySelected);

		
		addPage.clickAddToCart();
		
		Thread.sleep(5000);
		try {
		WebElement message=driver.findElement(By.xpath("//div[@id='layer_cart']/div/div/h2"));
		String script="return arguments[0].innerHTML;";
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String msg=js.executeScript(script, message).toString();
		String newmsg=msg.split("</i>")[1];
		System.out.println("new msg:"+newmsg);
		String newmsg1=newmsg.split(" cart")[0];
		System.out.println("new msg1: "+newmsg1);
		String expected1="Product successfully added to your shopping";
		Assert.assertEquals(newmsg1, expected1);
		}
		catch(Exception e){
			System.out.println("exception message is:"+e);
		}
		

		System.out.println("product is added to cart");
		System.out.println("*****************************************************************");

	}

	@Test(dependsOnMethods = "AddProductToTheCart", groups = "progression")
	public void checkOutAndvalidateTotalPrice() {
		summarypage = addPage.ProceedToCheckout();
		String actual = summarypage.total_price();
		String expected = "$35.02";
		Assert.assertEquals(actual, expected);
		System.out.println("total price is matched");
		System.out.println("*****************************************************************");

	}

	@Test(dependsOnMethods = "checkOutAndvalidateTotalPrice", groups = "progression")
	public void validateAddressPage() {
		aPage = summarypage.ProceedToCheckout();
		aPage.selectSameAddress();
		System.out.println("Address page is validated");
		System.out.println("*****************************************************************");
	}

	@Test(dependsOnMethods = "validateAddressPage", groups = "progression")
	public void validateShippingPage() {
		shipPage = aPage.ProceedToCheckout();
		shipPage.TermsCheckBox();
		System.out.println("Shippment page is validated");
		System.out.println("*****************************************************************");
	}

	@Test(dependsOnMethods = "validateShippingPage", groups = "progression")
	public void validatePaymentPage() {
		payPage = shipPage.ProceedToCheckout();
		orderPage = payPage.payByCheck();
		System.out.println("Payment page is validated");
		System.out.println("*****************************************************************");
	}

	@Test(dependsOnMethods = "validatePaymentPage", groups = "progression")
	public void placeTheOrder() {
		orderPage.IConfirmMyOrder();
		System.out.println("*****************************************************************");
	}

}
