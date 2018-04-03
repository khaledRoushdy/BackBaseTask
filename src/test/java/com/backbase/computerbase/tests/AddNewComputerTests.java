package com.backbase.computerbase.tests;

import org.testng.annotations.Test;

import com.backbase.computerbase.baseTest.ComputerDatabaseBaseTest;
import com.backbase.computerdatabase.domains.Computer;
import com.backbase.computerdatabase.pages.AddComputerPage;
import com.backbase.computerdatabase.pages.HomePage;
import com.backbase.computerdatabase.utilities.Utilities;

import junit.framework.Assert;

public class AddNewComputerTests extends ComputerDatabaseBaseTest{

	private HomePage homePage;
	private AddComputerPage addComputerPage;
	@Test
	public void shouldAddNewComputerSuccessfully() {
		
		homePage = new HomePage(driver);
		addComputerPage = new AddComputerPage(driver);
		 
		Computer computer = new Computer();
		computer.company = "Nokia";
		computer.name = Utilities.generateRandomChars(6);
		computer.introducedDate = "1990-12-27";
		computer.discontinedDate = "2007-12-27";
		homePage.selectAddComputerName();
		addComputerPage.AddComputer(computer);
		String alertMessage = homePage.getAlertMessage().trim();
		String expectedAlertMessage = String.format("Computer %s has been created", computer.name);
		Assert.assertTrue(alertMessage.contains(expectedAlertMessage));
	}
	
	@Test
	public void ShouldAddNewComputerWithFillingOnlyRequiredFields() {
		
		homePage = new HomePage(driver);
		addComputerPage = new AddComputerPage(driver);
		 
		Computer computer = new Computer();
		computer.name = Utilities.generateRandomChars(6);
		homePage.selectAddComputerName();
		addComputerPage.AddComputer(computer);
		String alertMessage = homePage.getAlertMessage().trim();
		String expectedAlertMessage = String.format("Computer %s has been created", computer.name);
		Assert.assertTrue(alertMessage.contains(expectedAlertMessage));
	}
	
	@Test
	public void ShouldNotAddComputerWithNoName() {
		
		homePage = new HomePage(driver);
		addComputerPage = new AddComputerPage(driver);
		 
		Computer computer = new Computer();
		homePage.selectAddComputerName();
		addComputerPage.AddComputer(computer);
		boolean isComputerNotAdded= addComputerPage.isComputerNotAdded();
		Assert.assertTrue(isComputerNotAdded);
	}
}
