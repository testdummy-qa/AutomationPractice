  package com.Guru.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Guru.utilities.ReadConfig;

public class BaseClassGuru {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL= readconfig.getAppURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver; 
	public static Logger log;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String brwsr)
	{
	
	log=Logger.getLogger("AutomationPractice");
	PropertyConfigurator.configure("log4j.properties");
	
	if(brwsr.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();
	}
	else if(brwsr.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
		driver= new FirefoxDriver();
	}
	else if (brwsr.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver", readconfig.getIePath());
		driver = new InternetExplorerDriver();
	}
	
	driver.get(baseURL);        	
	log.info("URL is opened");   // for logging 
	
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
