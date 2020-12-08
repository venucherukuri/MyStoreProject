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
public class ListenersClass extends ExtentReportManagerClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=reports.createTest(result.getName());
		test.createNode(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.PASS, "Test Case is Pass"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, MarkupHelper.createLabel("Test Case is Failed"+result.getName(), ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel("Test Case is Failed"+result.getThrowable(), ExtentColor.RED));
		
		try {
			String path=pageActions.TakesScreenShot(baseClass.driver, result.getName());
			test.fail("Test case is failed:"+result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, "Test Case is Skipped"+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

}
