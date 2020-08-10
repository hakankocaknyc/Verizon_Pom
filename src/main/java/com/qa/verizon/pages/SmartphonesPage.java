package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.Constants;
import com.qa.verizon.util.ElementUtil;

public class SmartphonesPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	//By smartPhone = By.xpath("//div[@id='tile_dev12360040']//div[contains(@class,'NHaasTX75Bd marginBottom5')]//span[1]");
   // By smartPhone = By.xpath("//div/a/span[text()='Apple ' and text()='iPhone 11']");
    By smartPhone = By.partialLinkText("iPhone 11");
	// Constructor

	public SmartphonesPage(WebDriver driver) {
		this.driver = driver;
		homePage = new HomePage(driver);
		elementUtil = new ElementUtil(driver);

	}

	public String getSmartphonePageTitle() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(Constants.SMARTPHONE_PAGE_TITLE));
		return driver.getTitle();
	

	}

	public PhonePage clickSmartPhone(WebDriver driver) {

		elementUtil.doClick(smartPhone);

		return new PhonePage(driver);
	}
}
