import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;  

public class FindElements {      // DO NOT CHANGE THE CLASS NAME
	  
	// Use the below declared variables 
	public static WebDriver driver;  
	static int radiobuttonCount;
	static List<WebElement> radioButtonList;
	static By radiobuttonXpath;
	String baseUrl = "https://webapps.tekstac.com/TicketBooking/TicketBookingForm.html";
	
	public WebDriver createDriver() {    // DO NOT CHANGe THE METHOD SIGNATURE 
	    
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    
	    driver=DriverSetup.getWebDriver();
	    driver.get(baseUrl);
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
	    
	    return driver;
	}
	
	public List<WebElement> radiobuttonCount() {    // DO NOT CHANGe THE METHOD SIGNATURE
       
        // Identify the radio buttons by customized xpath (use By.xpath("//*[@type='radio']")) 
		// Assign your locator to 'radiobuttonXpath' variable and use that to locate the element
		// Get the list of radio buttons and store it in a variable 'radioButtonList'
		// print the total radio buttons count using the list
		// Return the list 'radioButtonList'
		radiobuttonXpath=By.xpath("//*[@type='radio']");
		radioButtonList=driver.findElements(radiobuttonXpath);
		radiobuttonCount=radioButtonList.size();
		System.out.println("Total radio button count "+ radiobuttonCount);
		return  radioButtonList;
       
	}
	
	public static void main(String[] args) {    // DO NOT CHANGe THE METHOD SIGNATURE
	    
	    FindElements elmts = new FindElements();
	    
	    elmts.createDriver();
	    List<WebElement> radioList=elmts.radiobuttonCount();
	    System.out.println("Total radio buttons count "+radioList.size());
	}

}

