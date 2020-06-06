package com.Guru99.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassGuru {

	public String baseURL="http://demo.guru99.com/v4/";
	public String username ="mngr264437";
	public String password ="nUpUpEv";
	public static WebDriver driver; 
	
	@BeforeClass
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
