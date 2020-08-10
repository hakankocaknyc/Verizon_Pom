package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
// Locator
	
	By phone = By.xpath("//button[contains(text(),'Phones list')]");


	// Constructor
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	 public String getHomePageTitle (){
		
		return driver.getTitle();
		 
		 
	 }


	 
	 public SmartphonesPage moveClick(WebDriver driver) {
		WebElement smartPhones = driver.findElement(By.id("thirdLevel00"));	
		elementUtil.mouseOverClick(phone, smartPhones);
		return new SmartphonesPage(driver);
	}	
		 
	 
	 
	 
}