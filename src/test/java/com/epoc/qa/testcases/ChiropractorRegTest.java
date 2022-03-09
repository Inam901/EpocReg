package com.epoc.qa.testcases;



import java.io.IOException;

//import org.apache.logging.log4j.core.tools.Generate;
//import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;

import com.epoc.qa.base.TestBase;
import com.epoc.qa.pages.CreateAnAccount;
import com.epoc.qa.pages.HomePage;
import com.epoc.qa.pages.LogOutPage;
import com.epoc.qa.pages.MyAccountPage;
import com.epoc.qa.pages.SetupSecurityQuestionsPage;
import com.epoc.qa.pages.SignInPage;
import com.epoc.qa.pages.ThankYouPage;

public class ChiropractorRegTest extends TestBase
{
	HomePage objhomepage;
	SignInPage objsigninpage;
	CreateAnAccount objcreateaccount;
	SetupSecurityQuestionsPage objsetupsecurityquestions;
	ThankYouPage objthankyou;
	MyAccountPage objmyaccount;
	LogOutPage objlogoutpage;
	
	String title;
	
	Logger log = Logger.getLogger(ChiropractorRegTest.class);
	
	//Logger Log = Logger.getLogger(ChiropractorRegTest.class);
	//PropertyConfigurator.configure(log4j.properties);
	
	public ChiropractorRegTest()
	{
		super();
		
	}
	
	@BeforeTest
	public void setUp()
	{
		//System.out.println("begin setUp");
		log.info("begin setUp");
		initialization();
	    objhomepage = new HomePage();
	    objsigninpage = new SignInPage();
	    objcreateaccount = new CreateAnAccount();
	    objsetupsecurityquestions = new SetupSecurityQuestionsPage();
	    objthankyou = new ThankYouPage();
	    objmyaccount = new MyAccountPage();
	    objlogoutpage = new LogOutPage();
	    //System.out.println("end setUp");
	    log.info("end setUp");
	}
	
	
	@AfterMethod
	public void testResultCheck(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			takeScreenshot(result.getName()+"_Test_Failed");
		}
	}
	
	@Test(priority=1)
	public void homePageTitleValidation() throws IOException
	{
		//HomePage Title Validation
		//System.out.println("begin homePageTitleTest");
		log.info("begin homePageTitleTest");
		title = objhomepage.validateHomePageTitle();
		//Assert Pass
		Assert.assertEquals(title, "Point of care medical application | Epocrates");
		//Assert Fail
		//Assert.assertEquals(title, "oint of care medical application | Epocrates");
		//takeScreenshot("Epocrates_HomaPage");
		//System.out.println("end homePageTitleTest");
		log.info("homePageTitleTest Pass");
		
		//Epoc Logo Validation
		//System.out.println("begin Epoc Logo Validation");
		log.info("begin Epoc Logo Validation");
		boolean flag = objhomepage.validateEpocLogo();
		Assert.assertTrue(flag);
		//System.out.println("end Epoc Logo Validation");
		log.info("Epoc Logo Validation Pass");
		
		/*
		title = objsetupsecurityquestions.validateSetupSecurityQuestionsTitle();
		Assert.assertEquals(title, "epoc - Register Security Questions");
		
		//SetUp Security questions title test
		System.out.println("begin SetupSecurityQuestionsTitleTest");
		title = objsetupsecurityquestions.validateSetupSecurityQuestionsTitle();
		Assert.assertEquals(title, "epoc - Register Security Questions");
		System.out.println("end SetupSecurityQuestionsTitleTest");
		
		//skip for now button navigation test
		System.out.println("begin click SkipForNow button test ");
		objthankyou = objsetupsecurityquestions.clickSkipForNowBtn();
		title = objthankyou.validateThankYouTitle();
		Assert.assertEquals(title, "epoc - Thank You");
		System.out.println("end click sign-up button test"); */
		
			
	}
	
	@Test(priority=2)
	public void signUpButtonNavigationValidation()
	{
		        //SignUp button navigation test
				//System.out.println("begin click sign-up button test ");
		        log.info("begin click sign-up button test");
				objsigninpage = objhomepage.clickLoginBtn();
				title = objsigninpage.validateSignInPageTitle();
				Assert.assertEquals(title, "Epocrates - Sign in");
				log.info("Epocrates - Sign in page Title test Pass");
				log.info("end click sign-up button test");
				//System.out.println("end click sign-up button test");
	}
	
	@Test(priority=3)
	public void registerNowButtonNavigationValidation()
	{
		        //Register Now button navigation test
				//System.out.println("begin click Register Now button test ");
				log.info("begin click Register Now button test");
				objcreateaccount = objsigninpage.clickRegisterNowBtn();
				title = objcreateaccount.validateCreateAnAccountTitle();
				Assert.assertEquals(title, "Epocrates - Create an Account");
				log.info("Epocrates - Create an Account Title validation Pass");
				log.info("end click sign-up button test");
				//System.out.println("end click sign-up button test");
	}
	
	@Test(priority=4)
	public void fillRegistrationFormValidation()
	{
		        //Fill registration form
				//System.out.println("begin filling Registration Form ");
				log.info("begin filling Registration Form Validation");
				//objsetupsecurityquestions = objcreateaccount.fillRegistrationForm();
				objthankyou = objcreateaccount.fillRegistrationForm();
				//System.out.println("end filling Registration Form ");
				log.info("end filling Registration Form");
	}
	
	@Test(priority=5)
	public void thankYouPageValidation()
	{
		        //Thank You page title test
				//System.out.println("begin ThankYouTitleTest");
				log.info("begin ThankYouTitleTest");
				title = objthankyou.validateThankYouTitle();
				Assert.assertEquals(title, "Epocrates - Thank You");
				log.info("Epocrates - Thank You Page Title Validation Pass");
				//System.out.println("end ThankYouTitleTest");
				log.info("end ThankYouTitleTest");
	}
	
	@Test(priority=6)
	public void myAccountPageValidation()
	{
		        //Continue button navigation test
				//System.out.println("begin click continue button test ");
				log.info("begin click continue button test");
				objmyaccount = objthankyou.clickcontinueBtn();
				title = objmyaccount.validateMyAccountTitle();
				//My Account page title test
				Assert.assertEquals(title, "Epocrates, the leading provider of mobile and web based clinical reference tools");
				log.info("myAccountPageValidation Pass");
				log.info("end click continue button test");
				//System.out.println("end click continue button test");
	}
	
	@Test(priority=7)
	public void userSignOutValidation()
	{
		        //Sign out link test
				//System.out.println("begin click sign out link test ");
				log.info("begin click sign out link test");
				objlogoutpage = objmyaccount.clicksignoutLink();
				title = objlogoutpage.validateLogOutPageTitle();
				//Log out page title test
				Assert.assertEquals(title, "Epocrates - Sign in");
				log.info("userSignOutValidation Pass");
				log.info("end ThankYouTitleTest");
				//System.out.println("end ThankYouTitleTest");
	}

	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
