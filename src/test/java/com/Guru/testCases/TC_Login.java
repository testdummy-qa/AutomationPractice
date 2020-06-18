package com.Guru.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Guru.pageObject.LoginGuru;

public class TC_LoginGuru extends BaseClassGuru{

	@Test
	public void loginTestGuru() throws IOException
	{
					
		LoginGuru logGuru = new LoginGuru(driver);
		logGuru.setUserID(username);	// values directly from BaseClassGuru.java
		log.info("User ID Entered");
		
		logGuru.setUserPwd(password);	// values directly from BaseClassGuru.java
		log.info("User Password Entered");
		
		logGuru.clickLogin();
		log.info("Login Button Clicked");
		
// Verifying the page title upon successful login - to ensure test has passed
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			log.info("Login Test Passed");
		}
		else 
		{
			captureScreen(driver, "loginTestGuru"); //User defined method in base class-to capture screenshot
			Assert.assertFalse(false);
			log.info("Login Test Failed");
		}
				
	}
	
	
}
