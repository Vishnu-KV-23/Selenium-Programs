import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Locator {      // DO NOT CHANGE THE CLASS NAME
	  
	// Use the below declared variables 
	public static WebDriver driver;  
	public static WebElement buttonElmt; 
	String baseUrl = "http://webapps.tekstac.com/Shopify/";
	    
	    
	public WebDriver createDriver() {    // DO NOT CHANGe THE METHOD SIGNATURE 
	    
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    driver=DriverSetup.getWebDriver();

	    driver.manage().window().maximize();
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);

	    return driver;
	}
	
	public WebElement getIDLocator() {    // DO NOT CHANGe THE METHOD SIGNATURE
       
       // identify and locate a 'Register' button  using an 'id' locator
       // Store the element in the static variable 'buttonElmt' and return it
       // print the element text 
		buttonElmt=driver.findElement(By.id("reg"));
		
       return buttonElmt;
	}
	
	public static void main(String[] args) throws InterruptedException {    // DO NOT CHANGe THE METHOD SIGNATURE
	    
	    Locator idlocator = new Locator();
	    
	    idlocator.createDriver();
	    WebElement buttonElmt=idlocator.getIDLocator();
	    
	    System.out.println("The button text value is "+buttonElmt.getText());
	    Thread.sleep(2000);
	    driver.close();
	}

}

