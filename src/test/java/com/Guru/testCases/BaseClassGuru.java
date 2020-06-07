package com.Guru.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Guru.utilities.ReadConfig;

public class BaseClassGuru {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL= readconfig.getAppURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver; 
	public static Logger log;
	
	@BeforeClass
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
	driver = new ChromeDriver();
	
	log=Logger.getLogger("AutomationPractice");
	PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
