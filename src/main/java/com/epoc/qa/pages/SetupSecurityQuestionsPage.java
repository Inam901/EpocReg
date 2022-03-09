package com.epoc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epoc.qa.base.TestBase;

public class SetupSecurityQuestionsPage extends TestBase
{
	//Page Factory or Object Repository
	
		@FindBy(xpath = "//input[@alt='SKIP']")
		WebElement skipForNowBtn;
		
		public SetupSecurityQuestionsPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public String validateSetupSecurityQuestionsTitle()
		{
			System.out.println("inside validateSetupSecurityQuestionsTitle");
			return driver.getTitle();
		}
		
		public ThankYouPage clickSkipForNowBtn()
		{
			skipForNowBtn.click();
			
			return new ThankYouPage();
		}

}
