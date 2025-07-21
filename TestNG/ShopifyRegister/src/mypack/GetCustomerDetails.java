package mypack;     //Do not change the package name         

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class GetCustomerDetails {  //Do not change the class name
	
	//Use the below declared variable
	public WebDriver driver;
	public RespositoryParser parser;
	
	//Constructors are already given. If required, you can add more code into it but do NOT remove the existing code.
    public GetCustomerDetails(){}
    
	public GetCustomerDetails(WebDriver driver){
		//Assign driver and parser
		this.driver = driver;
        try {
            parser = new RespositoryParser("ObjectRepo.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	
	public WebElement getFirstName() {
		//Find and return the text displayed against FirstName using Xpath 
		String xpath = parser.getObjectLocator("firstname");
        return driver.findElement(By.xpath(xpath));
		//return null;
		
	}
	
	public WebElement getLastName() {
		//Find and return the text displayed against LastName using Xpath
		String xpath = parser.getObjectLocator("lastname");
        return driver.findElement(By.xpath(xpath));
		//return null;
	}

	public WebElement getUsername() {
		//Find and return the text displayed against Username using Xpath
		String xpath = parser.getObjectLocator("username");
        return driver.findElement(By.xpath(xpath));
		//return null;
	}	 	  	  		 	     	     	      	 	
	
	public WebElement getCity() {

		//Find and return the text displayed against City using Xpath
		String xpath = parser.getObjectLocator("city");
        return driver.findElement(By.xpath(xpath));
		//return null;
	
	}
	
	
}