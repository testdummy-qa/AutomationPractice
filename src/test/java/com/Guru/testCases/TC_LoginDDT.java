package com.Guru.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Guru.pageObject.LoginGuru;
import com.Guru.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginGuruDDT extends BaseClassGuru
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd)
	{
		LoginGuru lp=new LoginGuru(driver);
		
		lp.setUserID(user);
		log.info("Username is provided");
		
		lp.setUserPwd(pwd);
		log.info("User password is provided");
		
		lp.clickLogin();
		log.info("Login button is clicked");
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent(); // moves to main page
			Assert.assertTrue(false);
			log.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			log.info("Login Passed");
			lp.clickLogout();
			
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();			
		}		
	}
	
	// user defined method created to check if alert is present or not - should ideally be moved to BaseClass
	public boolean isAlertPresent()
	{
		try 
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path =System.getProperty("user.dir")+"/src/test/java/com/Guru/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount= XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); // 1   0 
			}
			
		}
		return logindata;
		
	}
	
}
