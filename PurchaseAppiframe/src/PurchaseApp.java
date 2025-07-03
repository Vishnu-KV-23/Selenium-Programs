import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PurchaseApp { // Do not change 
    
    // Use the below declarations
    static WebDriver driver;
    
    static String frameText;
	static int frameSize;  
	String baseUrl = "https://webapps.tekstac.com/PurchaseApp/";

    
	public WebDriver createDriver() {   // Do not change the method signature
	    
		// Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    driver=DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		
		return driver;
		
	}
	
	
	public String LocateIFrameText() {  // Do not change the method signature  
	    
	    
	    // Locate and identify the total number of iframes 
	    // Store it in a globally declared static variable 'frameSize'
        // Print it
	    
		frameSize=driver.findElements(By.xpath("//iframe")).size();
        System.out.println(frameSize);
		
		// Get the WebElement object of the iframe using the id of the iframe.
        // Switch to the iframe using the WebElement object
		
		WebElement iFrame= driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iFrame);
        
        //frameText=driver.findElement((By.xpath(baseUrl))
        // Locate the <h2> element inside the iframe
        // Get the text and store it in a static variable 'frameText'
        // print the text present on the iframe,
        
        // Switch to the defaultContent  (to move back to most parent or main frame)
        
        		
        		
        		
        		
        		
        frameText = driver.findElement(By.xpath("//h2")).getText();
        System.out.println(frameText);

        // Switch to the defaultContent (to move back to most parent or main frame)
        driver.switchTo().defaultContent();

        // Return the frameText
        return frameText;
	    // Return the frameText
	    
	    
	}
	
	public void closeBrowser() {  // Do not change the method signature
	     
		// close the browser
		driver.quit();
	}


	public static void main(String[] args){
		
		PurchaseApp app = new PurchaseApp();  
		
		// Add your code here
		app.createDriver();
		app.LocateIFrameText();
		app.closeBrowser();
	}	 	  	  		 	     	     	      	 	

}




