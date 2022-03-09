package com.epoc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epoc.qa.base.TestBase;

public class LogOutPage extends TestBase
{
	//@FindBy(xpath = "//*[@id='epocrates-account-menu']/li[3]/a")
	//WebElement signoutLink;
	
	public LogOutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLogOutPageTitle()
	{
		System.out.println("inside validateMyAccountTitle");
		return driver.getTitle();
	}

}
