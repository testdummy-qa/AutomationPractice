// Listener Class - used to generate Extent Reports.

package com.Guru.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportingExtent extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeTest
	public void onStart() 
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date()); // time stamp
		String repName = "Test-Report-"+ timeStamp +".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/" + repName); // location of generated report
	//	htmlReporter.loadXMLConfig(System.getProperty("user.dir"+ "/extent-config.xml")); // I am temporarily chaging to below line 
		htmlReporter.loadXMLConfig(System.getProperty("user.dir"+ "/TestNG.xml"));

		extent=new ExtentReports();   

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Vandana Kumari");

		htmlReporter.config().setDocumentTitle("AutomationPractice Project"); 	// Report Title
		htmlReporter.config().setReportName("Automated Functional Test Report"); // Report Name
	//	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);	// Chart Location
		htmlReporter.config().setTheme(Theme.DARK);			
	}

	@AfterTest
	public void onFinish()
	{
		extent.flush();
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); //Send the passed information
	}

	public void onTestFailure(ITestResult tr)
	{
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); 

		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";

		File f = new File(screenshotPath);

		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(screenshotPath));
			}	
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}

	}

	public void onTestSkipped(ITestResult tr)
	{
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE)); 
	}

	

}
