/**
 * 
 */
package com.MyStoreProject.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author Venu_Cherukuri
 *
 */
public class ExtentReportManagerClass {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public static void setReport() {
		String dateformat=new SimpleDateFormat("YYYYMMDDHHMMSS").format(new Date());
		System.out.println("check1");
	//	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+dateformat+"ExtentReport.html");
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/ExtentReport.html");
		System.out.println("check2");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		System.out.println("check3");
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Tester", "Venu Cherukuri");
		System.out.println("set Report is successful");
		
	}

	public static void endReport() {
		reports.flush();
	}
}
