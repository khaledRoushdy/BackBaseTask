package com.backbase.computerbase.tests;

import org.testng.annotations.Test;

import com.backbase.computerbase.baseTest.ComputerDatabaseBaseTest;
import com.backbase.computerdatabase.domains.Computer;
import com.backbase.computerdatabase.pages.EditComputerPage;
import com.backbase.computerdatabase.pages.HomePage;
import com.backbase.computerdatabase.utilities.Utilities;

import junit.framework.Assert;

public class EditComputerTests extends ComputerDatabaseBaseTest {

	private HomePage homePage;
	private EditComputerPage editComputerPage;
	
	@Test
	public void ShouldEditComputerDataSuccessfully() {
		
	homePage = new HomePage(driver);
	editComputerPage = new EditComputerPage(driver);
	Computer computer = new Computer();
	computer.company = "Nokia";
	computer.name = Utilities.generateRandomChars(6);
	computer.introducedDate = "1990-12-27";
	computer.discontinedDate = "2007-12-27";
	
	homePage.SelectAnyComputerName();
	editComputerPage.SaveComputer(computer);
	String alertMessage = homePage.getAlertMessage().trim();
	String expectedAlertMessage = String.format("Computer %s has been updated", computer.name);
	Assert.assertTrue(alertMessage.contains(expectedAlertMessage));
	}
	
	@Test
	public void ShouldNotEditComputerWithoutName() {
		
		homePage = new HomePage(driver);
		editComputerPage = new EditComputerPage(driver);
		Computer computer = new Computer();
		computer.company = "Nokia";
		computer.name = Utilities.generateRandomChars(6);
		computer.introducedDate = "1990-12-27";
		computer.discontinedDate = "2007-12-27";
		
		homePage.SelectAnyComputerName();
		editComputerPage.ClearComputerName();
		editComputerPage.SelectSaveThisComputer();
		
		boolean isComputerNotEdited= editComputerPage.isComputerNotEdited();
		Assert.assertTrue(isComputerNotEdited);
	}
	
	
}
