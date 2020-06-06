package com.Guru99.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassGuru {

	public String baseURL="http://demo.guru99.com/v4/";
	public String username ="mngr264437";
	public String password ="nUpUpEv";
	public static WebDriver driver; 
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	
	logger=Logger.getLogger("automationPractice");
	PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
