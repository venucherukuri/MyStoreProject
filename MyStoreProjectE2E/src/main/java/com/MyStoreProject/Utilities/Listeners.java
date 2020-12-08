/**
 * 
 */
package com.MyStoreProject.Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.MyStoreProject.Actions.pageActions;
import com.MyStoreProject.base.baseClass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * @author Venu_Cherukuri
 *
 */
public class Listeners extends ExtentReportManager implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest=extentReport.createTest(result.getName());
		extentTest.createNode(result.getName());
		System.out.println("Test Case Name id:"+result.getName());
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.PASS, result.getName()+"-Test Case Passed");
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String path=null;
		try {
		System.out.println("inside test failure");
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "- Test Case Failed", ExtentColor.RED));
		System.out.println("check1");
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"- Test Case Failed", ExtentColor.RED));
		System.out.println("check2");
		path = pageActions.TakesScreenShot(baseClass.driver, result.getName());
		System.out.println("check3");
			
		extentTest.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		System.out.println("check4");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//extentTest.addScreenCaptureFromPath(path);
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("inside test skip");
		extentTest.log(Status.SKIP, result.getName()+"- Test Case skipped");
		System.out.println("check5");
	//	extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getTestName()+"- Test Case skipped", ExtentColor.GREY));
	//	extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getThrowable()+"- Test Case skipped", ExtentColor.GREY));
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	

}
