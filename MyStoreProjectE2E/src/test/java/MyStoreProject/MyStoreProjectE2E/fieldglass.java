package MyStoreProject.MyStoreProjectE2E;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStoreProject.base.baseClass;

public class fieldglass extends baseClass {

	@BeforeClass(alwaysRun = true)
	@Parameters({ "url", "browser" })
	public void setup(String url, String browser) throws IOException {
		System.out.println("inside setup method");
		initialiseDriver(url, browser);
		System.out.println("*****************************************************************");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws IOException {
		System.out.println("inside tearDown method");
		//driver.close();
		System.out.println("*****************************************************************");
	}
	
	@Test
	public void fieldglassfill() {
		driver.findElement(By.name("username")).sendKeys("Chvenu");
		driver.findElement(By.name("password")).sendKeys("Nov@2020");
		driver.findElement(By.name("action")).click();
		
		driver.findElement(By.linkText("Complete Time Sheet")).click();
		
		driver.findElement(By.id("t_z17022004192153895870910_b_1_r1")).sendKeys("0");
		driver.findElement(By.id("t_z17022004192153895870910_b_2_r1")).sendKeys("6.4");
		driver.findElement(By.id("t_z17022004192153895870910_b_3_r1")).sendKeys("6.4");
		driver.findElement(By.id("t_z17022004192153895870910_b_4_r1")).sendKeys("6.4");
		driver.findElement(By.id("t_z17022004192153895870910_b_5_r1")).sendKeys("6.4");
		
		
		driver.findElement(By.id("t_z17022004192153895870910_b_1_r2")).sendKeys("0");
		driver.findElement(By.id("t_z17022004192153895870910_b_2_r2")).sendKeys("1.6");
		driver.findElement(By.id("t_z17022004192153895870910_b_3_r2")).sendKeys("1.6");
		driver.findElement(By.id("t_z17022004192153895870910_b_4_r2")).sendKeys("1.6");
		driver.findElement(By.id("t_z17022004192153895870910_b_5_r2")).sendKeys("1.6");
		
		driver.findElement(By.id("t_z17022004192153895870910_b_5_r2")).sendKeys(Keys.ENTER);
		
		String total=driver.findElement(By.id("t")).getText();
		
		System.out.println("total"+total);
		
		driver.findElement(By.id("fgTSSubmit")).click();
		
	}
}
