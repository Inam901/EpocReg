package com.epoc.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

//import com.epoc.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fileInput = new FileInputStream("/Eclipse WorkSpace/EpocratesReg/src/main/java/com/epoc"
					+ "/qa/config/config.properties");
			prop.load(fileInput);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		//if(browserName.equals("chrome"))
			if("chrome".equals(browserName))
		{
			//System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver.exe");
		    WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		//else if(browserName.equals("firefox"))
		else if("firefox".equals(browserName))
		{
			//System.setProperty("webdriver.gecko.driver", "D:/FireFoxDriver/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		//Take screenshot
		//takeScreenshot();
	}
	
	public static void takeScreenshot(String fileName) throws IOException
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("/Eclipse WorkSpace/EpocratesReg/" + "src/main/java/screenshots/"+ fileName +".jpg"));
	}
	

}
