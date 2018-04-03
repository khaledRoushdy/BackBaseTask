package com.backbase.computerdatabase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.backbase.computerdatabase.domains.Computer;

public class AddComputerPage extends ComputerDataPage {

	private By createComputerLocator = By.cssSelector("div.actions > input");
	private By computerNameErrorLocator = By.cssSelector("div.clearfix.error");
	
	public AddComputerPage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement createComputer() {
		return driver.findElement(createComputerLocator);
	}
	
	private WebElement computerNameError() {
		return driver.findElement(computerNameErrorLocator);
	}
	
	public void selectCreateComputer() {
		createComputer().click();
	}
	
	public boolean isComputerNotAdded() {
		if(computerNameError().getSize() != null)
			return true;
		
		return false;
	}

	public void AddComputer(Computer computer) {
		if (computer.name != null && !computer.name.isEmpty())
			computerName().sendKeys(computer.name);
		if (computer.introducedDate != null && !computer.introducedDate.isEmpty())
			introducedDate().sendKeys(computer.introducedDate);
		if (computer.discontinedDate != null && !computer.discontinedDate.isEmpty())
			discontinuedDate().sendKeys(computer.discontinedDate);
		if (computer.company != null && !computer.company.isEmpty()) 
			new Select(company()).selectByVisibleText(computer.company);
	
		selectCreateComputer();
	}
	
	public void selectCancel() {
		cancel().click();
	}
	
	public void cancelAddingComputerData(Computer computer) {
		
		if (computer.name != null && !computer.name.isEmpty())
			computerName().sendKeys(computer.name);
		if (computer.introducedDate != null && !computer.introducedDate.isEmpty())
			introducedDate().sendKeys(computer.introducedDate);
		if (computer.discontinedDate != null && !computer.discontinedDate.isEmpty())
			discontinuedDate().sendKeys(computer.discontinedDate);
		if (computer.discontinedDate != null && !computer.discontinedDate.isEmpty())
			discontinuedDate().sendKeys(computer.discontinedDate);
		if (computer.company != null && !computer.company.isEmpty()) 
			new Select(company()).selectByVisibleText(computer.company);
		
		selectCancel();
	}
}
