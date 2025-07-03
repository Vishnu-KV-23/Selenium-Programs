import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ExceptionManipulation {
	
	public static WebDriver driver; 
	static String baseUrl = "https://webapps.tekstac.com/Users/";
	
	public ExceptionManipulation() {}
	public ExceptionManipulation(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public WebDriver createDriver() {
       //Create driver by calling 'getDriver' method,store it in static variable driver, navigate to baseUrl and return it
       driver = DriverSetup.getDriver();
       driver.get(baseUrl);
       
        return driver;
    }	
	
	public Exception handleException(String invalidLocator) {
	    // Attempts to locate an element using the passed parameter and returns null if no exception found.
	    // Otherwise, catches the NoSuchElementException and returns the same.
	    
	    try {
	        WebElement element = driver.findElement(By.id(invalidLocator));
	        return null;
	    } catch (NoSuchElementException e) {
	        return e;
	    }
	    
	}
	
	
	public static void main(String[] args) throws Exception {
		ExceptionManipulation mainObj = new ExceptionManipulation();
		mainObj.createDriver();
		System.out.println(mainObj.handleException("nonExistentElement"));
         
     
    }
	
}