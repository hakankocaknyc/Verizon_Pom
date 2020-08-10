package com.qa.verizon.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.verizon.base.BasePage;

public class ElementUtil {
WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Get title
	 * @return
	 */
	public String doGetPageTitle() {
		
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting the title...");
		}
		return null;
	}
	
	/**
	 * This method is used to create the webelement on the basis of by locator
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		
		WebElement element = null;
		
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception got occured while creating the web element " + locator);
		}
		return element;
	}
	
	/**
	 * This method is used to click the webelement on the basis of by locator
	 * @param locator
	 */
	public void doClick(By locator) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occured while clicking the web element " + locator);
		}
	}
	
	/**
	 * This method is used to send value in a field
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception got occured while entering values in a field " + locator);
		}
	}
	
	/**
	 * isDisplayed
	 * @param locator
	 * @return
	 */
	public boolean doIsDisplayed(By locator) {
	
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception got occured isDisplayed method" + locator);
		}
		return false;
	}
	
	/**
	 * isEnabled
	 * @param locator
	 * @return
	 */
	public boolean doIsEnabled(By locator) {
		
		try {
			return getElement(locator).isEnabled();
		} catch (Exception e) {
			System.out.println("some exception got occured isEnabled method"+locator);
		}
		return false;
	}
	
	/**
	 * isSelected
	 * @param locator
	 * @return
	 */
	public boolean doIsSelected(By locator) {
		
		try {
			return getElement(locator).isSelected();
		} catch (Exception e) {
			System.out.println("some exception got occured isSelected method"+locator);
		}
		return false;
	}
	
	
	/**
	 * GetText()
	 * @param locator
	 * @return
	 */
	public String doGetText(By locator) {
		
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting text..."+locator);
		}
		return null;
	}

	
	public void mouseHover(By element, WebElement elementClicked) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement mouseOverAction = driver.findElement(element);
		action.moveToElement(mouseOverAction).click(elementClicked).build().perform();	
}
	
	
	public void mouseOverClick(By element, WebElement elementClicked) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement mouseOverAction = driver.findElement(element);
		action.moveToElement(mouseOverAction).click(elementClicked).build().perform();	
	}
	
	public String verifyGetText(By locator, String verifyText ) {
		
		
		String text = driver.findElement(locator).getText();
		if (text.equals(verifyText)) {
			System.out.println("Text is correct.");
		} else {
			System.out.println("Text is not correct.");
		}
		return text;
		
	}
//	
//	public WebElement getElement(By locator) {
//		waitForElementPresentBy(locator);
//		WebElement element = null;
//		try {
//			element = driver.findElement(locator);
//			if (flash.equalsIgnoreCase("yes")) {
//				JavaScriptUtil.flash(element, driver);
//			}
//		} catch (Exception e) {
//			System.out.println("some exception occured while creating webelement " + locator);
//		}
//		return element;
//	}
	}
