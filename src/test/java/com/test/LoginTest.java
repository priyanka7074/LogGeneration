package com.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
	
	WebDriver driver;
	//String configFileName = "C:\\Users\\welcome\\eclipse-workspace\\GenerateLogs\\src\\main\\resources\\log4j.properties";
    Logger log = Logger.getLogger(LoginTest.class);
   
	
	@BeforeMethod
	public void setup() {
       // PropertyConfigurator.configure(configFileName);
		
		log.info("*********************Starting test cases execution************************");
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    log.info("launching chrome browser");
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.crmpro.com/index.html");
		log.info("Entering application url");
		log.warn("Hey this is just a warning message");
		log.fatal("Hey this is just a fatal error message");
		log.debug("This is a debug message");
		
	}
	
	@Test(priority = 1)
	public void freeCRMTitleTest() {
		log.info("*********************Starting Test Case************************");
		log.info("*********************freeCRMTitleTest************************");	
		
		String title = driver.getTitle();
		System.out.println(title);
		log.info("login page title -->"+title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
		log.info("*********************Ending Test Case************************");
		log.info("*********************freeCRMTitleTest************************");	
	}
	
	@Test(priority = 2)
	public void freeCRMLogoTest() {
		log.info("*********************Starting Test Case************************");
		log.info("*********************freeCRMLogoTest************************");
		
		boolean b = driver.findElement(By.xpath("//img[@class= 'img-responsive']")).isDisplayed();
		Assert.assertTrue(b);
		
		log.info("*********************Ending Test Case************************");
		log.info("*********************freeCRMLogoTest************************");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("*********************Browser is closed************************");
	}

}
