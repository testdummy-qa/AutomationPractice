package com.Guru99.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Guru99.pageObject.LoginGuru;

public class TC_LoginGuru extends BaseClassGuru{

	@Test
	public void loginTestGuru()
	{
		driver.get(baseURL);        	// values from BaseClassGuru.java
		LoginGuru logGuru = new LoginGuru(driver);
		logGuru.setUserID(username);	// values from BaseClassGuru.java
		logGuru.setUserPwd(password);	// values from BaseClassGuru.java
		logGuru.clickLogin();
		
// Verifying the page title upon successful login - to ensure test has passed
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertFalse(false);
		}
				
	}
}
