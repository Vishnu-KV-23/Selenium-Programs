import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
 
public class SeleniumTestForm {   //Do not change the class name
 
    // Use the below declared variable
    public static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/TrainReservation/index.html";
    
    public WebDriver createDriver() {    //Do not change the method signature
    
        // Invoke the getWebDriver() method from the DriverSetup File
	    // Store it in static variable 'driver', navigate and return it
	    driver=DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		
		// return driver
        return driver;
        
    }
 
    public void testSeleniumTestForm() throws Exception{    //Do not change the method signature
    	
    	//Call the method readExcelData(), read the data from excel sheet. Excel file name is 'Reservation.xlsx' and sheet name is 'details'
        //find the elements in the form and set values parsed from excel sheet. Submit the form for registration
        ExcelUtils.readExcelData("Reservation.xlsx");
    	
        driver.findElement(By.id("travelFrom")).sendKeys(ExcelUtils.passengerData[0]);
		driver.findElement(By.id("travelTo")).sendKeys(ExcelUtils.passengerData[1]);
		driver.findElement(By.id("departure")).sendKeys(ExcelUtils.passengerData[2]);
		
		Select classSelect = new Select(driver.findElement(By.id("selectclass")));
		classSelect.selectByVisibleText(ExcelUtils.passengerData[3]);
		
		driver.findElement(By.id("name")).sendKeys(ExcelUtils.passengerData[4]);
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.passengerData[5]);
		driver.findElement(By.id("phone")).sendKeys(ExcelUtils.passengerData[6]);
		
		for(int i =0; i<Integer.parseInt(ExcelUtils.passengerData[7]); i++){	 	  	  		 	     	     	      	 	
			driver.findElement(By.id("fa-plus")).click();
		}
        
		
		driver.findElement(By.id("book-now")).click();
    }
    
    public void closeBrowser() {
        
        //close the browser
        driver.close();
    }
 
    public static void main(String[] args) throws Exception {
	    SeleniumTestForm passenger = new SeleniumTestForm();
	    //Add the required code
        passenger.createDriver();
        passenger.testSeleniumTestForm();
        passenger.closeBrowser();
	}
}
