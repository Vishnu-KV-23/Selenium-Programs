import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NameLocator {      // DO NOT CHANGE THE CLASS NAME
	  
	// Use the below declared variables 
	public static WebDriver driver;  
	public static WebElement textboxElmt; 
	String baseUrl = "http://webapps.tekstac.com/Shopify/";
	    
	    
	public WebDriver createDriver() {    // DO NOT CHANGE THE METHOD SIGNATURE 
	    
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    
	    driver=DriverSetup.getWebDriver();
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
	    
	    return driver;
	}
	
	public WebElement getNameLocator() {    // DO NOT CHANGE THE METHOD SIGNATURE
       
       // identify and locate a 'Username' textbox element using an 'name' locator
       // Store the element in the static variable 'textboxElmt' and return it
         textboxElmt=driver.findElement(By.name("usrnm"));
       return textboxElmt;
	}
	
	public String getPlaceholderText(WebElement textboxElmt) {    // DO NOT CHANGE THE METHOD SIGNATURE
       
       // Get the placeholder of 'username' text box using the textboxElmt and return it. 
       // Hint - use getAttribute() method te get the placeholder value
		String ph=textboxElmt.getAttribute("placeholder");
       
		return ph ;
	}
	
	public static void main(String[] args) {    // DO NOT CHANGE THE METHOD SIGNATURE
	    
	    NameLocator namLocator = new NameLocator();
	    
	    namLocator.createDriver();
	    WebElement textElmt = namLocator.getNameLocator();
	    String placeholdtxt = namLocator.getPlaceholderText(textElmt);
	    System.out.println("The placeholder of text box is "+placeholdtxt);
	}

}

