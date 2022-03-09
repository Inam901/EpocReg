package com.epoc.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.epoc.qa.base.TestBase;

public class CreateAnAccount extends TestBase
{
	public static String EmailId;

	//Page Factory or Object Repository
	@FindBy(xpath = "//input[@id='name_first']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='name_last']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='emailConfirm']")
	WebElement confirmEmail;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='input_password']")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//select[@id='country']")
	WebElement countryOfResidence;
	
	@FindBy(xpath = "//input[@id='zipWork']")
	WebElement zipCode;
	
	@FindBy(xpath = "//select[@id='occupation']")
	WebElement occupation;
	
	@FindBy(xpath = "//select[@id='specialtyGroup']")
	WebElement specialty;
	
	@FindBy(xpath = "//input[@alt='JOIN']")
	WebElement joinBtn;
	
	public CreateAnAccount()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateCreateAnAccountTitle()
	{
		System.out.println("inside validateCreateAnAccountTitle");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver.getTitle();
	}
	
	public ThankYouPage fillRegistrationForm()
	{
		firstName.sendKeys(prop.getProperty("firstname"));
		lastName.sendKeys(prop.getProperty("lastname"));
		
		// for timestamp
		String TIMESTAMP = Long.toHexString(System.currentTimeMillis());
        String EMAIL = "autoTeamEmail"+ TIMESTAMP +"@epocrates.com";
        
        EmailId = EMAIL;
        
        email.sendKeys(EMAIL);
        confirmEmail.sendKeys(EMAIL);
        password.sendKeys(prop.getProperty("password"));
        confirmPassword.sendKeys(prop.getProperty("confirmpassword"));
        //countryOfResidence.
        zipCode.sendKeys(prop.getProperty("zipcode"));
        new Select(driver.findElement(By.id("occupation"))).selectByVisibleText(prop.getProperty("occupation"));
        joinBtn.click();
        
        return new ThankYouPage();
        
	}
}
