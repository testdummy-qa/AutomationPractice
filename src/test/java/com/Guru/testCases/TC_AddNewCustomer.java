package com.Guru.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Guru.pageObject.LoginPage;
import com.Guru.pageObject.NewCustomerPage;

import junit.framework.Assert;

public class TC_AddNewCustomer extends BaseClassGuru {

@Test
public void addNewCustomer() throws InterruptedException, IOException
{
// Performing the Login test 	
	LoginPage logGuru = new LoginPage(driver);
	driver.manage().window().maximize();
	
	logGuru.setUserID(username);	// values directly from BaseClassGuru.java
	log.info("User ID Entered");
	
	logGuru.setUserPwd(password);	// values directly from BaseClassGuru.java
	log.info("User Password Entered");
	
	logGuru.clickLogin();
	log.info("Login Button Clicked");

	Thread.sleep(3000);
	
// 	Performing actions for adding new customer
	NewCustomerPage NewCust = new NewCustomerPage(driver);
	NewCust.clickNewCustomerTab();
	
	log.info("Providing Customer Information ............................. > ");
	NewCust.setCustName("Vandana");
	NewCust.clickGender("Female");
	NewCust.setDateOfBirth("28", "01", "1990");
	
	Thread.sleep(3000);
	
	NewCust.setAddress("India");
	NewCust.setCity("New Delhi");
	NewCust.setState("Delhi");
	NewCust.setPinNum("200034");
	NewCust.setMobileNum("9876543210");
	
	String email = randomemail()+"@gmail.com";
	NewCust.setEmail(email);  // Random email is generated using the user defined randomemail() method
	
	NewCust.setPassword("TestPassword");
	NewCust.clickSubmit();
	
	Thread.sleep(3000);
	
// Validating the successful customer add > using "Customer registered succcessfully" screen 
	boolean testResult = driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	if (testResult==true)
	{
		Assert.assertTrue(true);		
		log.info("Test Passed ............................. > ");
	}
	
	else 
	{
		captureScreen(driver, "AddNewCustomer");
		Assert.assertTrue(false);	
		log.info("Test Failed ............................. > ");
	}	
}

// User defined method to generate random email id
 public String randomemail()
 {
	String generatedemail = RandomStringUtils.randomAlphabetic(8);
	return(generatedemail);	 
 }	
}
