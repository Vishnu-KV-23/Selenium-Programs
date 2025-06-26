import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Locator {      // DO NOT CHANGE THE CLASS NAME
	  
	// Use the below declared variables 
	public static WebDriver driver;  
	public static WebElement resultElmt; 
	String baseUrl = "https://webapps.tekstac.com/Handling_Reg_Expression/";
	
	public WebDriver createDriver() {    // DO NOT CHANGe THE METHOD SIGNATURE 
	    
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	  
	  
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
	    
	    return driver;
	}
	
	public void setUsername() {    // DO NOT CHANGe THE METHOD SIGNATURE
       
       // identify and locate a 'textbox' using locator
       // fill the text box with value 'Shamili'
       // Use sendKeys() method to fill the content 
	   
       
	}
	
	public void clickSearchBtn() {  // DO NOT CHANGe THE METHOD SIGNATURE
	    
	    // Click the Search button after filling the text box. 
	}
	
	public WebElement getResult() {    // DO NOT CHANGe THE METHOD SIGNATURE
       
       // After clicking Search button, result will be displayed. 
       // identify and locate the web element of the output text displayed
       
       // Store the element in the static variable 'resultElmt' and return it
       return null;
      
	}
	
	public static void main(String[] args) {    // DO NOT CHANGe THE METHOD SIGNATURE
	    
	    Locator loc = new Locator();
	    
	    loc.createDriver();
	    loc.setUsername();
	    loc.clickSearchBtn();
	    
	    WebElement elemt=loc.getResult();
	    
	    System.out.println("The displayed result is "+elemt.getText());
	}

}

