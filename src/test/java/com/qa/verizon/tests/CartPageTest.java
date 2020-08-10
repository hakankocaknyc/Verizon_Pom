package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.CartPage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.pages.PhonePage;
import com.qa.verizon.pages.SmartphonesPage;
import com.qa.verizon.util.Constants;

public class CartPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	PhonePage phonePage;
	SmartphonesPage smartphonesPage;
	CartPage cartPage;

	@BeforeTest
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);
		smartphonesPage = homePage.moveClick(driver);
		phonePage = smartphonesPage.clickSmartPhone(driver);
		cartPage = phonePage.clickPhoneFutures(driver);

	}

	@Test(priority = 1)
	public void verifyCartPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		String title = cartPage.getCartPageTitle();
		System.out.println("Cart page title is " + title);
		Assert.assertEquals(title, Constants.CART_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void verifyTitleTest() {
		System.out.println(cartPage.verifyGetText());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
