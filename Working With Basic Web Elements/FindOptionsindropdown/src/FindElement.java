import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.*;  

public class FindElement {      // DO NOT CHANGE THE CLASS NAME
	  
	// Use the below declared variables 
	public static WebDriver driver;  
	public static WebElement element; 
	public static List<WebElement> optionList;
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/TrainReservation/index.html";
	
	public WebDriver createDriver() {    // DO NOT CHANGe THE METHOD SIGNATURE 
	    
	    /*Invoke the getWebDriver() method from the DriverSetup File */
	    /*Store it in static variable 'driver' and return it*/
	    driver=DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
	    
	    return driver;
	}
	
	public WebElement getElementById() {    // DO NOT CHANGe THE METHOD SIGNATURE
       
       ///Find the drop down element using id 'selectclass' and return the webelement.
       element = driver.findElement(By.id("selectclass"));
         
       return element;
	}
	
	public List<WebElement> getOptions(WebElement dropdownElement) {    // DO NOT CHANGe THE METHOD SIGNATURE
       
       // get the number of options available in the dropdown by calling the getOptions() method of the Select class
       // store it in list 'optionList' and return it
         Select select = new Select(dropdownElement);
         optionList=select.getOptions();
         
         
        return optionList;
	}

	public static void main(String[] args) {    // DO NOT CHANGe THE METHOD SIGNATURE
	    
	     FindElement findElement = new FindElement();
	    
	    findElement.createDriver();
	    WebElement element=findElement.getElementById();
	    List<WebElement> options = findElement.getOptions(element);

	    System.out.println("The Option count is "+options.size());
	}

}

