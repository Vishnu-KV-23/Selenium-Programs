import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;  

public class FindElement {      // DO NOT CHANGE THE CLASS NAME
	  
	// Use the below declared variables 
	public static WebDriver driver;  
	public static WebElement element; 
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp2/Library/Library.html";
	   
	public WebDriver createDriver() {    // DO NOT CHANGE THE METHOD SIGNATURE 
	    
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it*/
	    
	    driver = DriverSetup.getWebDriver();
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
	    
	    return driver;
	}
	
	public WebElement getElementByClassname() {    // DO NOT CHANGE THE METHOD SIGNATURE
       
       // identify and locate a 'Home' button element with class 'active' using 'className' locator and return it.  
       // print the element text 
		element=driver.findElement(By.className("active"));
       return element;
	}
	
	public static void main(String[] args) {    // DO NOT CHANGe THE METHOD SIGNATURE
	    
	    FindElement findElement = new FindElement();
	    
	    findElement.createDriver();
	    WebElement classnameElmt = findElement.getElementByClassname();
	    
	    System.out.println("The element text is "+classnameElmt.getText());
	}

}

