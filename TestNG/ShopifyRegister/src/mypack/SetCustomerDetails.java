package mypack;        //Do not change the package name

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class SetCustomerDetails {       //Do not change the class name

    //Use the below declared variable
	public WebDriver driver;
	public WebElement element;
	
    //Constructors are already given. If required, you can add more code into it but do NOT remove the existing code.
    public SetCustomerDetails(){}
    
	public SetCustomerDetails(WebDriver driver) { 
		//Assign driver
		this.driver = driver;
	}	 	  	  		 	     	     	      	 	


    public void setFirstName(String firstName) throws Exception{ 
        // Locate the Web Element corresponding to the ‘FirstName’ (TextField) using specific locators.		
        // Use the sendKeys() method and fill the input box of the ‘FirstName' with 'firstName'
    	element = driver.findElement(By.id("firstname"));
        element.sendKeys(firstName);
	}
	
	public void setLastname(String lastName) throws Exception{ 
		// Locate the Web Element corresponding to the ‘LastName’ (TextField) using specific locators.		
        // Use the sendKeys() method and fill the input box of the ‘LastName' with 'lastName'
		element = driver.findElement(By.id("lastname"));
        element.sendKeys(lastName);
	}
	
	public void setUsername(String userName) throws Exception{ 
		// Locate the Web Element corresponding to the ‘UserName’ (TextField) using specific locators.		
        // Use the sendKeys() method and fill the input box of the ‘UserName' with 'userName'
		element = driver.findElement(By.id("username"));
        element.sendKeys(userName);
	}
	
	public void setCity(String city) throws Exception{ 
		// Locate the Web Element corresponding to the ‘City’ (Drop down) using specific locators based on the input given.            
		// Use Select to select the given city
		Select dropdown = new Select(driver.findElement(By.name("city")));
        dropdown.selectByVisibleText(city);
	}
	
	
	public void setGender(String gender) throws Exception{ 
		// Locate the Web Element corresponding to the ‘Gender’ (Radio button) using specific locators.		
        // Use the click() method to select the gender based on the given input
		gender = gender.toLowerCase();
	    element = driver.findElement(By.cssSelector("input[type='radio'][name='gender'][value='" + gender + "']"));
	    element.click();
	}
	
	public void setPassword(String password) throws Exception{ 
		// Locate the Web Element corresponding to the ‘Password’ (TextField) using specific locators.		
        // Use the sendKeys() method and fill the input box of the ‘Password' with 'password'
		element = driver.findElement(By.id("pass"));
        element.sendKeys(password);
	}
	
	public void setRegisterBtn() throws Exception{ 
		// Locate the Web Element corresponding to the ‘Register’ (Button) using specific locators.
		// Click the ‘Register’ button and submit the form.
		element = driver.findElement(By.id("reg")); 
	    element.click();
	}
}