package com.epoc.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epoc.qa.base.TestBase;

public class SignInPage extends TestBase
{
	
	//Page Factory or Object Repository
	
		@FindBy(xpath = "//a[contains(text(), 'Register Now')]")
		WebElement registerNowBtn;
		
		
		public SignInPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public String validateSignInPageTitle()
		{
			System.out.println("inside validateSignInPageTitle");
			return driver.getTitle();
		}
		
		public CreateAnAccount clickRegisterNowBtn()
		{
			System.out.println("Reg1");
			// Perform the click operation that opens new window
			registerNowBtn.click();
			System.out.println("Reg2");
			
			return new CreateAnAccount();
		}
		
		
}
