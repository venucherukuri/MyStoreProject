/**
 * 
 */
package MyStoreProject.MyStoreProjectE2E;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStoreProject.PageObjects.AddressPage;
import com.MyStoreProject.PageObjects.IndexPage;
import com.MyStoreProject.PageObjects.LoginPage;
import com.MyStoreProject.PageObjects.SearchResultsPage;
import com.MyStoreProject.base.baseClass;

/**
 * @author Venu_Cherukuri
 *
 */
public class ValidateAddressPage extends baseClass {
	IndexPage iPage;
	SearchResultsPage spage;
	AddressPage aPage;
	LoginPage lpage;

	public static Logger log;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({ "url", "browser" })
	public void setup(String url, String browser) throws IOException {
		System.out.println("inside setup method1");
		initialiseDriver(url, browser);
		System.out.println("*****************************************************************");

		log = Logger.getLogger(placeOrder.class.getName());
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/Configuration/Log4j.properties");

		log.info("log4j is enabled");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws IOException {
		System.out.println("inside tearDown method1");
		driver.close();
		System.out.println("*****************************************************************");
	}

	@Test(groups = "regression")
	public void validateAddressPage() {
		
		try {
			iPage = new IndexPage(driver);

			lpage = iPage.clickSignin();

			lpage.signIn_emailAddress("admin@xyz.com");
			lpage.signIn_password("admin@123");
			lpage.SubmitLogin();

			String actual1 = lpage.validateMyAccount();

			Assert.assertEquals(actual1, "Akhil naik");

			System.out.println("signin is successful");
			System.out.println("*****************************************************************");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is:"+e);
			log.error("login is failed");
		}
		
		spage=new SearchResultsPage(driver);
		aPage=spage.ClickMyAddresses();
		String value=aPage.ValidateAddress();
		String expected="MY ADDRESS";
		Assert.assertEquals(value, expected);
		System.out.println("Address is present in Address page");
		System.out.println("*****************************************************************");
	}
}
