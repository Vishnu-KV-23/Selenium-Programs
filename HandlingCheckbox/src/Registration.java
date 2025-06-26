import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class Registration {   //DO NOT Change the class Name

    // Use the below delcared variable
	public static WebDriver driver;
	String baseUrl = "https://webapps.tekstac.com/InvoiceUpdates/";
	
	public WebDriver createDriver() {    // DO NOT CHANGE THE METHOD SIGNATURE
	    
	    // Driver instance creation and navigation
	    driver = DriverSetup.getWebDriver();
	    driver.get(baseUrl);
	    
	     return driver;
	}
	
	public void formSubmit(String type) {     // DO NOT CHANGE THE METHOD SIGNATURE
	    
	    /* Locate the Web Element corresponding to the User type 'Old User' or 'New User' (CheckBox) using specific locators.
                If type value is 'OldUser' locate the web element corresponding to checkbox1
                If type value is 'NewUser' locate the web element corresponding to checkbox2
                Choose the user type based on the parameter passed to this method */
		
		if (type.equals("OldUser"))
		{
			driver.findElement(By.id("oldUser")).click();
			
		}
		else if (type.equals("NewUser"))
		{
			driver.findElement(By.id("newUser")).click();
		}
		
	}
	

	public static void main(String[] args) {    // DO NOT CHANGE THE METHOD SIGNATURE
	
	    Registration reg=new Registration();
	    reg.createDriver();
	    reg.formSubmit("OldUser");
	   
	}
}

