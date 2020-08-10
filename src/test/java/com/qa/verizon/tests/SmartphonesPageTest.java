package com.qa.verizon.tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.pages.SmartphonesPage;
import com.qa.verizon.util.Constants;

public class SmartphonesPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	SmartphonesPage smartphonesPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);
		smartphonesPage = homePage.moveClick(driver);

	}

	@Test(priority = 1)
	public void getTitleTest() {
		 String title = smartphonesPage.getSmartphonePageTitle();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 System.out.println("Smartphone page title is " + title);
		Assert.assertEquals(title, Constants.SMARTPHONE_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void clickPageTest() {
		smartphonesPage.clickSmartPhone(driver);
	}

	@AfterTest
	public void tearDown() {
		 basePage.quitBrowser();

	}
}
