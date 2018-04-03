package com.backbase.computerbase.tests;

import org.testng.annotations.Test;

import com.backbase.computerbase.baseTest.ComputerDatabaseBaseTest;
import com.backbase.computerdatabase.pages.AddComputerPage;
import com.backbase.computerdatabase.pages.EditComputerPage;
import com.backbase.computerdatabase.pages.HomePage;

import junit.framework.Assert;

public class DeleteComputerTests extends ComputerDatabaseBaseTest {

	private HomePage homePage;
	private EditComputerPage editComputerPage;
	@Test
	public void ShouldDeleteComputerSuccessfully() {
		
		homePage = new HomePage(driver);
		editComputerPage = new EditComputerPage(driver);
		
		homePage.SelectAnyComputerName();
		editComputerPage.SelectDeleteThisComputer();
		String actualErrorMessage = homePage.getAlertMessage().trim();
		String expectedErroMessage = "Computer has been deleted";
		Assert.assertEquals(expectedErroMessage, actualErrorMessage);
		
	}
}
