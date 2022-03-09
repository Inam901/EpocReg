package com.epoc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epoc.qa.base.TestBase;

public class MyAccountPage extends TestBase 
{
	//"Epocrates, the leading provider of mobile and web based clinical reference tools"
	
	//Page Factory or Object Repository
	
	@FindBy(xpath = "//*[@id='epocrates-account-menu']/li[3]/a")
	WebElement signoutLink;
	
	public MyAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateMyAccountTitle()
	{
		System.out.println("inside validateMyAccountTitle");
		return driver.getTitle();
	}
	
	public LogOutPage clicksignoutLink()
	{
		signoutLink.click();
		
		return new LogOutPage();
	}

}
