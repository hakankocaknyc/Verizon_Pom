package com.qa.verizon.tests;

import java.util.Properties;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.util.Constants;
import com.qa.verizon.util.ElementUtil;

 

public class HomePageTest  {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	
	

	
	

	@BeforeTest
	public void setUp(){
		
		basePage = new BasePage();
		prop = basePage.initialize_properties();//browser
		driver = basePage.initialize_driver(prop);//url
		homePage = new HomePage(driver);
		 
	}
	@Test(priority=1)
	public void verifyHomePageTitle() throws InterruptedException{
		Thread.sleep(3000);
	String title = homePage.getHomePageTitle();
	System.out.println("Home page title is " + title);
	
	Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	
	}
 
	@Test(priority=2)
	public void clickTest(){
		homePage.moveClick(driver);
	}
	
	@AfterTest
	public void tearDown(){
		basePage.quitBrowser();
	
	}
}
