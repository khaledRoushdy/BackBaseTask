package com.backbase.computerdatabase.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.backbase.computerdatabase.domains.Computer;
import com.backbase.computerdatabase.utilities.Utilities;

public class HomePage {

	private By filterByComputerLocator = By.id("searchbox");
	private By filterByNameLocator = By.id("searchsubmit");
	private By addComputerNameLocator = By.id("add");
	private By computerNamesLocator = By.xpath("//table//tr/td[1]/a");
	private By introductedDatesLocator = By.xpath("//table//tr/td[2]");
	private By discontinedDatesLocator = By.xpath("//table//tr/td[3]");
	private By computerCountLocator = By.xpath("//table/tbody/tr");
	private By companyLocater = By.xpath("//table//tr/td[4]");
	private By noDataMessageLocator = By.cssSelector("div.well em ");
	private By alertMessageLocator = By.cssSelector("div.alert-message.warning");
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	private WebElement filterByComputerName(){
		return driver.findElement(filterByComputerLocator);
	}
	
	private WebElement filterByName(){
		return driver.findElement(filterByNameLocator);
	}
	
	private WebElement addComputerName(){
		return driver.findElement(addComputerNameLocator);
	}
	
	private List<WebElement> computerName(){
		return driver.findElements(computerNamesLocator);
	}
	
	private List<WebElement> introducedDate(){
		return driver.findElements(introductedDatesLocator);
	}
	
	private List<WebElement> discontinuedDate(){
		return driver.findElements(discontinedDatesLocator);
	}
	
	private List<WebElement> computerCompany(){
		return driver.findElements(companyLocater);
	}
	
	private WebElement NoDataMessage(){
		return driver.findElement(noDataMessageLocator);
	}
	
	private WebElement alertMessage(){
		return driver.findElement(alertMessageLocator);
	}
	
	public String getNoDataMessage() {
		return NoDataMessage().getText();
	}
	
	public String getAlertMessage() {
		return alertMessage().getText();
	}
	
	public int GetComputersCount(){
		return driver.findElements(computerCountLocator).size();
	}
	
	public List<String> getComputerNames(){
		List<WebElement> computerNamesElements = computerName();
		List<String> computerNames = Utilities.getTextFromWebElements(computerNamesElements);
		return computerNames;
	}
	
	public List<String> getIntroducedDates(){
		List<WebElement> introducedDatesElements = introducedDate();
		List<String> introducedDates = Utilities.getTextFromWebElements(introducedDatesElements);
		return introducedDates;
	}
	
	public List<String> getDiscontinuedDates(){
		List<WebElement> discontinuedDatesElements = discontinuedDate();
		List<String> discontinuedDates = Utilities.getTextFromWebElements(discontinuedDatesElements);
		return discontinuedDates;
	}
	
	public List<String> getCompanies(){
		List<WebElement> companyElements = computerCompany();
		List<String> computerCompany = Utilities.getTextFromWebElements(companyElements);
		return computerCompany;
	}
	
	public void filterByComputerName(String name) throws InterruptedException{	 
		filterByComputerName().sendKeys(name);
		filterByName().click();
		Thread.sleep(3000);
	}
	
	public void selectAddComputerName(){
		addComputerName().click();
	}
	
	public List<Computer> getComputerData(){
	
		int computerCount = GetComputersCount();
		List<String> computerNames = getComputerNames();
		List<String> comptuerIntroducedDates = getIntroducedDates();
		List<String> computerDiscontinuedDates = getDiscontinuedDates();
		List<String> computerCompanies = getCompanies();
		List<Computer> computers = new ArrayList<>();
		
		for(int i=0;i<computerCount;i++){
			Computer computer = new Computer();
			computer.name = computerNames.get(i);
			computer.introducedDate = comptuerIntroducedDates.get(i);
			computer.discontinedDate = computerDiscontinuedDates.get(i);
			computer.company = computerCompanies.get(i);
			computers.add(computer);
		}
		return computers;
	}
	
	public void selectComputerName(String name){
		List<WebElement> computerNames = computerName();
		for (WebElement compname: computerNames) {
			if(compname.getText() == name){
				compname.click();
				break;
			}
		}
	}
	public void SelectAnyComputerName(){
		computerName().get(0).click();
	}
}
