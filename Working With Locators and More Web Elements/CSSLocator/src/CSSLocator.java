import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class CSSLocator {  // Do not change the class name

    // Use the below declared variables
	public static WebDriver driver; 
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/TrainReservation/index.html";
    public static WebElement element;
	public WebDriver setupDriver() {  // Do not change the method signature
	    
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    driver=DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
	    return driver;
	}
	
	public WebElement getCSSLocator(WebDriver driver) {  //DO NOT change the method signature
	
	   /*Replace this comment by the code statement to get the Web element of name*/
	   /*Find and return the element of name input box using cssSelector locator */ 
		element=driver.findElement(By.cssSelector("#name"));
       return element;
	}
	
public String getName(WebElement element) {  //DO NOT change the method signature
	
	    //Get the attribute value from the element and return it
        String nameText = element.getAttribute("placeholder");
		
		return nameText;
	}	

	
	public static void main(String[] args) {  // Do not change the method signature
	    CSSLocator locator=new CSSLocator();
	    driver = locator.setupDriver();
	    
	    WebElement cssLocator = locator.getCSSLocator(driver);
		    
	    String name = locator.getName(cssLocator);
	    System.out.println("The placeholder text using 'cssLocator' locator is "+name);	
	    
	    //Add required code
	    
	}

}

