package com.qa.verizon.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class CartPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	SmartphonesPage smartphonesPage;
	PhonePage phonePage;

	By deviceInfo1 = By.xpath("//span[contains(text(),'Apple')]");
	By deviceInfo2 = By.xpath("//span[contains(text(),'iPhone 11')]");

	// const

	public CartPage(WebDriver driver) {
		this.driver = driver;

		elementUtil = new ElementUtil(driver);
		homePage = new HomePage(driver);
		smartphonesPage = new SmartphonesPage(driver);
		phonePage = new PhonePage(driver);

	}

	public String getCartPageTitle() {

		return driver.getTitle();

	}

	public String verifyGetText() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(deviceInfo1));
		String text1 = elementUtil.verifyGetText(deviceInfo1, "Apple");

		wait.until(ExpectedConditions.elementToBeClickable(deviceInfo2)).click();

		String text2 = elementUtil.verifyGetText(deviceInfo2, "iPhone 11");
		return text1 + text2;
	}

}
