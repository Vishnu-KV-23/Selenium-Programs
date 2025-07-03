import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;


public class RelativeXpathLocator {   //DO NOT Change the class Name

    // Use the below declared variables
	public static WebDriver driver;
	String baseUrl = "http://webapps.tekstac.com/SeleniumApp2/Pandemic/Pandemic.html";
	
		public WebDriver createDriver()  {  //DO NOT change the method signature
	
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    driver = DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
        return driver;
	}
	
	public WebElement getRelativeXpathLocator(WebDriver driver) { //DO NOT change the method signature

	   /*Replace this comment by the code statement to get the Web element */
	   /*Find and return the element of 'Submit' button */
		driver.findElement(By.xpath("//input [@type='submit'][@id='VirusTest']"));
		
		
		
    return driver.findElement(By.xpath("//input [@type='submit'][@id='VirusTest']"));
	}
	
	public String getAttributeValue(WebElement element) {   //DO NOT change the method signature
	
	    //Get the attribute value from the element and return it
	    return element.getAttribute("value");
	}	 

    public static void main(String[] args) {
	    RelativeXpathLocator pl=new RelativeXpathLocator();
	    //Add required code
	    
	    WebDriver dri = pl.createDriver();
	    WebElement a= pl.getRelativeXpathLocator(dri);
	    System.out.println("AAAAAAAAAA"+pl.getAttributeValue(a));
	}
}

