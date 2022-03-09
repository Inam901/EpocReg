package com.epoc.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epoc.qa.base.TestBase;
import com.epoc.qa.util.TestUtil;

public class HomePage extends TestBase
{
	//Page Factory or Object Repository
	
	@FindBy(xpath = "//a[@href='https://www.epocrates.com/account.do?mode=summary&ICID=website']")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//img[@src='https://prod.caas.epocrates.com/sites/epocrates/files/epocrates-logo-326x49-midnight%402x_0.png']")
	WebElement epocLogo;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		System.out.println("inside validateHomePageTitle");
		return driver.getTitle();
	}
	
	public boolean validateEpocLogo()
	{
		return epocLogo.isDisplayed();
	}
	
	public SignInPage clickLoginBtn()
	{
		System.out.println("Test1");
		// Store the current window handle
		//String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		signUpBtn.click();
		System.out.println("Test2");
		
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    //driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		    System.out.println("Test3");
		}
			
		return new SignInPage();
	}

}
