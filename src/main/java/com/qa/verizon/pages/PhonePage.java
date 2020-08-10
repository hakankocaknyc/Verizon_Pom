package com.qa.verizon.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class PhonePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	SmartphonesPage smartphonesPage;
	By color = By.xpath(
			"//div[@class='container-fluid pdp-main-container clearFixBanner noPad']//div[@class='row noSideMargin']//div[3]//div[1]");
	By storage = By.xpath("//p[contains(text(),'256GB')]");
	By payment = By.xpath(
			"//div[@class='col-sm-12 noSidePad fontSize_16 fontDSStd-75Bd textAlignLeft contractDetail']//span[contains(text(),'$849.99')]");
	By continueBtn = By.xpath("//button[@id='ATC-Btn']");
	By zipcode = By.id("zipcode");
	By confirmBtn = By.xpath("//button[contains(@class,'defaultPrimaryCTA')]");
	By newCustomer = By.xpath("//button[@class='modalButton fontSize_12 NHaasDS55Rg background_FF onlyRightMargin margin8']");
	
//	/locators
//	By color = By.xpath("//div[@class='colorStyleDiv height26 width26 positionRelative borderRadius50 cursorPointer border_97']");
//	By storageSize = By.xpath("//*[@id=\"tile_container\"]/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/p");
//	By retailPrize = By.xpath("//*[@id=\"tile_container\"]/div[1]/div[3]/div[1]/div/div[2]/div/div[2]/div[1]/div/div[2]/div/div/div/div/div[1]/span");
//	By addToCart = By.id("ATC-Btn");
//	By newCustomer = By.xpath("//button[@aria-label='New Customer']");
//	By zipcode = By.id("zipcode");
//	By confirmLocation = By.xpath("//button[@class='defaultPrimaryCTA ']");
//	By gotoMycart = By.id("navCartCircle");
//	
	// locator

	public PhonePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		homePage = new HomePage(driver);
		smartphonesPage = new SmartphonesPage(driver);

	}

	// method
	public String verifyGetTitle() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return elementUtil.doGetPageTitle();

	}

	public CartPage clickPhoneFutures(WebDriver driver) {
		elementUtil.doClick(color);
		elementUtil.doClick(storage);
		elementUtil.doClick(payment);
		elementUtil.doClick(continueBtn);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(zipcode)).clear();
		elementUtil.doSendKeys(zipcode, "11235");
		elementUtil.doClick(confirmBtn);
		elementUtil.doClick(newCustomer);
		return new CartPage(driver);
	}
}