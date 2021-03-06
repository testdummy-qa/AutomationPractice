package com.Guru.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
// Covers the Test case [ TC_LoginGuru ]
	
	WebDriver localDriver; // driver object created 
	
 /* GuruLogin here is a constructor, takes driver as a parameter, 
	and initiates the driver inside it */
	
	public LoginPage(WebDriver remoteDriver)
	{
		localDriver = remoteDriver; // driver initiated
		PageFactory.initElements(remoteDriver,this);	
	}
	
	@FindBy(name="uid") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement UserID;
	 
	@FindBy(name="password")
	@CacheLookup             // @CacheLookup is optional to use
	WebElement UserPwd;
	
	@FindBy(name="btnLogin")
	@CacheLookup             // @CacheLookup is optional to use
	WebElement LoginBtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup             // @CacheLookup is optional to use
	WebElement LogoutBtn;
	
	
		
// Creating action methods for the above page elements
	
	public void setUserID(String uid)
	{
		UserID.sendKeys(uid);
	}
	
	public void setUserPwd(String upwd)
	{
		UserPwd.sendKeys(upwd);
	}
	
	public void clickLogin()
	{
		LoginBtn.click();
	}

	public void clickLogout()
	{
		LogoutBtn.click();
	}
	
} 
