package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.pages.PhonePage;
import com.qa.verizon.pages.SmartphonesPage;
import com.qa.verizon.util.Constants;

public class PhonePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	PhonePage phonePage;
	SmartphonesPage smartphonesPage;

	@BeforeTest
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
//		driver.get("https://www.verizon.com/smartphones/apple-iphone-11-pro-max/");
		homePage = new HomePage(driver);
		smartphonesPage = homePage.moveClick(driver);
		phonePage = smartphonesPage.clickSmartPhone(driver);
		//phonePage = new PhonePage(driver);
		//smartphonesPage = new SmartphonesPage(driver);

	}

	@Test(priority = 1)
	public void verifyTitleTest() {
		String title = phonePage.verifyGetTitle();
		System.out.println("Phone page title  " + title);
		Assert.assertEquals(title, Constants.PHONE_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void clickPhone() {
		phonePage.clickPhoneFutures(driver);
	}

	 

	@AfterTest
	public void tearDown() {
//		basePage.closeBrowser();

	}

}
