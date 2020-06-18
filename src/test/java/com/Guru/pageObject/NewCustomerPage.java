package com.Guru.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver localDriver;
	
	public NewCustomerPage(WebDriver remoteDriver)
	{
		localDriver = remoteDriver; // driver initiated
		PageFactory.initElements(remoteDriver,this);	
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement NewCustomerTab;
	
	@FindBy(name="name") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement CustName;
	
	
	@FindBy(name ="rad1") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement Gender;
	
	@FindBy(name="dob") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement DateOfBirth;
	
	@FindBy(name="addr") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement Address;
	
	@FindBy(name="city") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement City;
	
	@FindBy(name="state") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement State;
	
	@FindBy(name="pinno") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement PIN;
	
	@FindBy(name="telephoneno") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement MobileNum;
	
	@FindBy(name="emailid") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement Email;
	
	@FindBy(name="password") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement Password;
	
	@FindBy(name="sub") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement SubmitBtn;
	
	@FindBy(name="res") 
	@CacheLookup              // @CacheLookup is optional to use
	WebElement ResetBtn;
	
// Creating action methods for the above page elements
	
	
	public void clickNewCustomerTab()
	{
		NewCustomerTab.click();
	}
	
	public void setCustName(String custname)
	{
		CustName.sendKeys(custname);
	}
	
	public void clickGender(String gender)
	{
		Gender.click();
	}
	
	public void setDateOfBirth(String mm, String dd, String yyyy) // Since the values are entered saperately
	{
		DateOfBirth.sendKeys(mm);
		DateOfBirth.sendKeys(dd);
		DateOfBirth.sendKeys(yyyy);
	}
	
	public void setAddress(String address)
	{
		Address.sendKeys(address);
	}
	
	public void setCity(String city)
	{
		City.sendKeys(city);
	}
	
	public void setState(String state)
	{
		State.sendKeys(state);
	}
	
	public void setPinNum(String pin)
	{
		PIN.sendKeys(pin);
	}
	
	public void setMobileNum(String mobile)
	{
		MobileNum.sendKeys(mobile);
	}
	
	public void setEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		SubmitBtn.click();
	}
	
	public void clickReset()
	{
		ResetBtn.click();
	}
	
	
}
