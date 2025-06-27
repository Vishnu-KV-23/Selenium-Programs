import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Registration {  // DO NOT CHANGE THE CLASS NAME
    
    // Use the below delcared variable
	public static WebDriver driver;
	public static WebElement element;
	public static Select select;
	String baseUrl = "https://webapps.tekstac.com/Shopify/";

	public WebDriver createDriver() {    // DO NOT CHANGE THE METHOD SIGNATURE
	    
	    // Driver instance creation and navigation
	    driver = DriverSetup.getWebDriver();
	    driver.get(baseUrl);
	     return driver;
	}
	
	public void formSubmit(String city) {     // DO NOT CHANGE THE METHOD SIGNATURE
	   // Write the code for select the city in the respective place
	    element=driver.findElement(By.id("firstname"));
		element.sendKeys("Rahul");
		
		element=driver.findElement(By.name("lname"));
		element.sendKeys("Dravid");
		
		element=driver.findElement(By.name("usrnm"));
		element.sendKeys("Rahul Dravid");
		
		/* Locate the dropdown Web Element corresponding to the 'Select City' using specific locators.
	       Declare the 'Select City' drop-down element as an instance of the Select class.
	       Use 'selectByVisibleText' to select the value passed as parameter to this method
	       city value can either be "Chennai" or "Coimbatore".
	       Hint: getFirstSelectedOption() method returns the first selected option in the dropdown list. */
	       
	       element=driver.findElement(By.xpath("//*[@id=\'selectcity\']"));
	       Select select = new Select(element);
	       select.selectByVisibleText(city);
		
		driver.findElement(By.name("gender")).click();
		element=driver.findElement(By.id("pass"));
		element.sendKeys("123");
		element=driver.findElement(By.id("reg"));
		element.click();
		
	    // Get the result and print it on the console for the verification  
	      
	  
	}
	

	public static void main(String[] args) {    // DO NOT CHANGE THE METHOD SIGNATURE
	
	    Registration reg=new Registration();
	    reg.createDriver();
	    reg.formSubmit("Chennai");
	   
	}

}

