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
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStoreProject.base.baseClass;

/**
 * @author Venu_Cherukuri
 *
 */
public class TestFailureAndSkip extends baseClass {
	
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
	@Ignore
	public void TestFailure() {
		Assert.assertTrue(false);
	}
	
	@Test(groups = "progression")
	public void TestSkip() {
		Assert.assertTrue(true);
	}

}
