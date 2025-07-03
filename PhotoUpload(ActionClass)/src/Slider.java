import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.IOException;

public class Slider  {  //DO NOT Change the class Name

    // Use the below declared variables 
	public static WebDriver driver;
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_prof.html";

	
	public WebDriver createDriver() {      //DO NOT change the method signature

	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);

        // DO NOT MODIFY THE BELOW CODE
	    JavascriptExecutor js = (JavascriptExecutor) driver;    //DO NOT change 
        js.executeScript("window.scrollBy(1283,700)", "");  //DO NOT change 
        
        // return driver
        return driver;
	}
	
	public void implDragnDrop() {  //DO NOT change the method signature

        // Locate the source web element that needs to be dragged.
        // Locate the target web element that needs to be dropped.        
        // Creating object of Actions class to build composite actions
        // Performing the drag and drop action
        
        // Print the output texts displayed after drag and drop
	}
	
	       
        
	public static void main(String[] args) {    //DO NOT change the method signature
	    Slider slider =new Slider();
	    
	    //Call the method createDriver()
	    //Call the method implDragnDrop()
	    //Print the message displayed after drag and drop. 
	    
	}
}

