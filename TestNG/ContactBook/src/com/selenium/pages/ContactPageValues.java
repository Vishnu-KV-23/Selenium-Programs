package com.selenium.pages;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Dimension;

public class ContactPageValues { // DO NOT CHANGE THE CLASS NAME
	
	// Use the below declared variable 
	private WebDriver driver;
	private WebElement element;
	

    //Constructors are already given. If required, you can add more code into it but do NOT remove the existing code.
    public ContactPageValues(){}
    
	public ContactPageValues(WebDriver driver){
		this.driver= driver;		
	}
	
	// Implement code here
	
	public void setNickName(String nickName) {
		// Locate the WebElement 'NickName' using specific locator
        // Use sendKeys method to fill the nickname field
		WebElement nickNameElement = driver.findElement(By.id("nickname"));
		nickNameElement.sendKeys(nickName);

	}
	
	public void setContactName(String contact) {
		// Locate the WebElement 'Contact Nme' using specific locator
        // Use sendKeys method to fill the contact field
		WebElement contactNameElement = driver.findElement(By.id("contact"));
		contactNameElement.sendKeys(contact);

	}
	
	public void setCompany(String company) {
	    
	// Locate the WebElement 'Company' using specific locator
    // Use sendKeys method to fill the company field
		WebElement companyElement = driver.findElement(By.id("company"));
		companyElement.sendKeys(company);
	}	 	  	    	 	    	     	 	
	
	public void setCity(String city) {
	// Locate the WebElement 'City' using specific locator
    // Use sendKeys method to fill the city field
		WebElement cityElement = driver.findElement(By.id("city"));
		cityElement.sendKeys(city);

	}
	
	public void setCountry(String country) {
	// Locate the WebElement 'Country' using specific locator
    // Use sendKeys method to fill the country field
		WebElement countryElement = driver.findElement(By.id("country"));
		countryElement.sendKeys(country);

	}
	
	public void setType(String type) {
		// Locate the WebElement 'Type' using specific locator
        // Use sendKeys method to fill the type field
		WebElement typeElement = driver.findElement(By.id("type"));
		typeElement.sendKeys(type);

	}
	
	public void clickAddButton() {
		// Locate the WebElement 'Add' using specific locator
        // Use click method to submit the form.
		driver.findElement(By.id("add")).click();

	}
	
	
	public String getNickName() {// Do not change the method signature
	// Locate the WebElement corresponding to the 'Nickname' displayed after form. 
	// Get the WebElement, store it in a variable and return the text as String.
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[1]")).getText();

	    //return null;
	}	 	  	    	 	    	     	 	
	
	public String getContactName() {// Do not change the method signature
		// Locate the WebElement corresponding to the 'Contact' displayed after form. 
	    // Get the WebElement, store it in a variable and return the text as String.
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[2]")).getText();

		//return null;
	}
	
	public String getCompany() {// Do not change the method signature
		// Locate the WebElement corresponding to the 'Company' displayed after form. 
	    // Get the WebElement, store it in a variable and return the text as String.
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[3]")).getText();
		//return null;
	}
	
	public String getCity() {// Do not change the method signature
		// Locate the WebElement corresponding to the 'City' displayed after form. 
	    // Get the WebElement, store it in a variable and return the text as String.
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[4]")).getText();

		//return null;
	}
	
	public String getCountry() {// Do not change the method signature
		// Locate the WebElement corresponding to the 'Country' displayed after form. 
	    // Get the WebElement, store it in a variable and return the text as String.
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[5]")).getText();
		//return null;
	}
	
	public String getType() {// Do not change the method signature
		// Locate the WebElement corresponding to the 'Type' displayed after form. 
	    // Get the WebElement, store it in a variable and return the text as String.
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[6]")).getText();
		//return null;
	}
	
}
