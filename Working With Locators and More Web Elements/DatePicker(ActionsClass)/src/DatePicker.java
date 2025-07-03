
import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class DatePicker extends DriverSetup {
	public static WebDriver driver;
	public static String baseUrl = "https://webapps.tekstac.com/Registration/";

//public static String Date= "02-02-2024";
	public DatePicker(WebDriver driver) {
		this.driver = driver;
	}

	public DatePicker() {
	}

	public WebDriver createDriver() {
		//Create driver,store it in static variable driver, navigate to baseUrl and return it
		
		
		driver= DriverSetup.getDriver();
		driver.get(baseUrl);
		
		
        return driver;
	}

	public void setDate(String date) throws AWTException, InterruptedException {

		
		 WebElement dateInput = driver.findElement(By.name("dob")); 
		
	//Locate the WebElement corresponding to 'Date' using specific locators and Click.
	    // Create a new Actions instance, use this instance to set value for the Date field

		 dateInput.click();
		 
		 Actions actions = new Actions(driver);
		 
		 actions.click(dateInput).perform();
	        dateInput.clear();
	        dateInput.sendKeys(date);
	        
	        
	        Thread.sleep(1000);
	        
	        
	        System.out.println("Date: " + date);
		 
		 
	}

	public static void main(String[] args) throws AWTException, InterruptedException {
		DatePicker reg = new DatePicker();
		reg.createDriver();
		reg.setDate("02-02-2024");
	}

}
