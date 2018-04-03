package com.backbase.computerdatabase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.backbase.computerdatabase.domains.Computer;

public class EditComputerPage extends ComputerDataPage {

	private By saveThisComputerLocator = By.cssSelector(".actions input");
	private By deleteThisComputerLocator = By.cssSelector("input.btn.danger");
	private By computerNameErrorLocator = By.cssSelector("div.clearfix.error");

	public EditComputerPage(WebDriver driver) {
		super(driver);
	}

	private WebElement saveThisComputer() {
		return driver.findElement(saveThisComputerLocator);
	}

	private WebElement deleteThisComputer() {
		return driver.findElement(deleteThisComputerLocator);
	}
	
	private WebElement computerNameError() {
		return driver.findElement(computerNameErrorLocator);
	}

	public void SelectSaveThisComputer() {
		saveThisComputer().click();
	}

	public void SelectDeleteThisComputer() {
		deleteThisComputer().click();
	}
	
	public boolean isComputerNotEdited() {
		if(computerNameError().getSize() != null)
			return true;
		
		return false;
	}
	
	public void ClearComputerName() {
		computerName().clear();
	}

	public void SaveComputer(Computer computer) {
		
		if (computer.name != null && !computer.name.isEmpty()) {
			computerName().clear();
			computerName().sendKeys(computer.name);
		}
		
		if (computer.introducedDate != null && !computer.introducedDate.isEmpty()) {
			introducedDate().clear();
			introducedDate().sendKeys(computer.introducedDate);
		}
		
		if (computer.discontinedDate != null && !computer.discontinedDate.isEmpty()) {
			discontinuedDate().clear();
			discontinuedDate().sendKeys(computer.discontinedDate);
		}
		
		if (computer.company != null && !computer.company.isEmpty()) {
			new Select(company()).selectByVisibleText(computer.company);
		}
		
		SelectSaveThisComputer();
	}

	public void selectCancel() {
		cancel().click();
	}

	public void cancelEditingComputerData(Computer computer) {

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
