import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;


public class AbsoluteXpathLocator {  //DO NOT Change the class Name
    
    // Use the below declared variables
	public static WebDriver driver;
	String baseUrl = "http://webapps.tekstac.com/SeleniumApp1/EventManagement/index.html";
	
	public WebDriver createDriver() {   // DO NOT CHANGE THE METHOD SIGNATURE
 	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    driver = DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		return driver;
	}
	
	public WebElement getAbsoluteXpathLocator(WebDriver driver) { //DO NOT change the method signature
	
	   /*Replace this comment by the code statement to get the Web element of logo */
	   /*Find and return the element */ 
		
		
		
		
		
	   return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/nav[1]/a[1]/img[1]"));
	}
	
	public String getName(WebElement element) {   //DO NOT change the method signature
	
	    //Get the attribute value from the element and return it
	    return element.getAttribute("src");
	}	 	  	  		 	     	     	      	 	

    public static void main(String[] args){
	    AbsoluteXpathLocator pl=new AbsoluteXpathLocator();
	   //Add required code    
	    WebDriver driver = pl.createDriver();
	    WebElement a =pl.getAbsoluteXpathLocator(driver);
	    System.out.println(pl.getName(a));   
	}

}

