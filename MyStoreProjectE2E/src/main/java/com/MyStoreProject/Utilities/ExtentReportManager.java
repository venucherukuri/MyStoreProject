/**
 * 
 */
package com.MyStoreProject.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author Venu_Cherukuri
 *
 */
public class ExtentReportManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	

	
	public static void setExtentReport() {
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/ExtentReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		
//		htmlReporter.config().setDocumentTitle("Extent Automation Report");
//		htmlReporter.config().setReportName("MyStoreProject Report");
//		htmlReporter.config().setTheme(Theme.DARK);
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		
		extentReport.setSystemInfo("ProjectName", "MyStoreProject");
		extentReport.setSystemInfo("Tester", "Venu Cherukuri");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("OS", "Windows");
		
	}
	
	public static void endReport() {
		
		extentReport.flush();
	}

}
