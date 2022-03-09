package com.epoc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epoc.qa.base.TestBase;

public class ThankYouPage extends TestBase
{
	//Page Factory or Object Repository
	
			@FindBy(xpath = "//a[@id='clickhandler']")
			WebElement continueBtn;
			
			public ThankYouPage()
			{
				PageFactory.initElements(driver, this);
			}
			
			public String validateThankYouTitle()
			{
				System.out.println("inside validateThankYouTitle");
				return driver.getTitle();
			}
			
			public MyAccountPage clickcontinueBtn()
			{
				continueBtn.click();
				
				return new MyAccountPage();
			}


}
