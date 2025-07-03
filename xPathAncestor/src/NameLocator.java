import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class NameLocator {     //DO NOT Change the class name

    //Use the declared variables for stroing required values
	static String fName;
	static WebDriver driver;
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/TrainReservation/index.html";
	
	public WebDriver setupDriver() {  //DO NOT Change the method Signature
	
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    driver=DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		
		return driver;

	}
	public String getNameLocator() {  //DO NOT Change the method Signature
	
	   /*Using the driver, Find the element ancestor and its text and assign the text to 'fName' */
       /*Close the driver*/
		WebElement totalElement = driver.findElement(By.xpath("//h4[text()='Total']/ancestor::div[@class='booking-form']"));
		fName = totalElement.getText();
		driver.quit();
		return fName;
		
		//driver.findElement(By.xpath(""))
		
	//    return null;
	}
	
	public static void main(String[] args) {    //DO NOT Change the method Signature
	
	    NameLocator namLocator=new NameLocator();
	    //Add required code here
	    namLocator.setupDriver();
	    namLocator.getNameLocator();
	   
	}

}

