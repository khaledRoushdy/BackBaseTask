package com.backbase.computerdatabase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComputerDataPage {

	protected By computerNameLocator = By.id("name");
	protected By introducedDateLocator = By.id("introduced");
	protected By discontinuedDateLocator = By.id("discontinued");
	protected By companyLocator = By.id("company");
	protected By cancelLocator = By.cssSelector(".actions a");
	
	protected WebDriver driver;
	
	public ComputerDataPage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected WebElement computerName() {
		return driver.findElement(computerNameLocator);
	}

	protected WebElement introducedDate() {
		return driver.findElement(introducedDateLocator);
	}

	protected WebElement discontinuedDate() {
		return driver.findElement(discontinuedDateLocator);
	}

	protected WebElement company() {
		return driver.findElement(companyLocator);
	}
	
	protected WebElement cancel() {
		return driver.findElement(cancelLocator);
	}
}

