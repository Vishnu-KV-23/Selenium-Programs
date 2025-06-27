import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;  

public class FindElements {      // DO NOT CHANGE THE CLASS NAME
	  
	// Use the below declared variables 
	public static WebDriver driver;  
	public static List<WebElement> optionsList;
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp2/OrderFood/order.html";
	
public WebDriver createDriver() {    // DO NOT CHANGE THE METHOD SIGNATURE 
	    
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    driver = DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
	    
	    
	    return driver;
	}
	
	
	public List<WebElement> getDropdownCount() {    // DO NOT CHANGe THE METHOD SIGNATURE
      
       // identify all the drop down options belonging to the 'Select' tag using tagName locator 
       // store the list in the static variable 'optionsList' and return it
       // print the drop down options count 
       optionsList = driver.findElements(By.tagName("select"));
    	return optionsList;
	}
	
	public static void main(String[] args) {    // DO NOT CHANGe THE METHOD SIGNATURE
	    
	    FindElements elmts = new FindElements();
	    
	    elmts.createDriver();
	    List<WebElement> count = elmts.getDropdownCount();
	    System.out.println("The dropdown options count is "+ count.size());
	}

}

