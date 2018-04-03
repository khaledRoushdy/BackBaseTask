package com.backbase.computerbase.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.backbase.computerbase.baseTest.ComputerDatabaseBaseTest;
import com.backbase.computerdatabase.domains.Computer;
import com.backbase.computerdatabase.driver.Browser;
import com.backbase.computerdatabase.pages.HomePage;
import com.backbase.computerdatabase.utilities.Utilities;

public class FilterByComputerNameTests extends ComputerDatabaseBaseTest{

	private HomePage homePage;

	@Test
	public void shouldFilterByComputerNameThatHasMoreThanOneMatch() throws InterruptedException {
		
		homePage = new HomePage(driver);
		homePage.filterByComputerName("acer");
		List<Computer> computerData=homePage.getComputerData();
		for (Computer computer : computerData) {
			Assert.assertTrue(computer.name.toLowerCase().contains("acer"));
		}
	}
	
	@Test
	public void shouldFilterByComputerNameThatHasOneMatch() throws InterruptedException {
		
		homePage = new HomePage(driver);
		homePage.filterByComputerName("Alex eReader");
		List<Computer> computerData=homePage.getComputerData();
		Assert.assertEquals(computerData.size(), 1);
		for (Computer computer : computerData) {
			Assert.assertEquals(computer.name,"Alex eReader");
		}	
	}
	
	@Test
	public void ShouldFilterByComputerNameThatHasNoMatches() throws InterruptedException {
		
		homePage = new HomePage(driver);
		String randomName = Utilities.generateRandomChars(6);
		homePage.filterByComputerName(randomName);
		List<Computer> computerData=homePage.getComputerData();
		Assert.assertEquals(computerData.size(), 0);
		String actualNoDatMessage = homePage.getNoDataMessage();
		Assert.assertEquals(actualNoDatMessage, "Nothing to display");
	}
}
