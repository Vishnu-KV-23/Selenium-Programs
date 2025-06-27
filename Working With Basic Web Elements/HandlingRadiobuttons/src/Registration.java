import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class Registration {   //DO NOT Change the class Name

    // Use the below delcared variable
	public static WebDriver driver;
	String baseUrl = "https://webapps.tekstac.com/CustomerRegistration_4284/";
	
	
	By nameElement = By.name("name");
	By mobileElement = By.name("mobile");
	By dobElement = By.name("dob");
	By genderElement = By.name("gender");
	By addressElement = By.id("address");
	By registerbuttonElement = By.id("register");
	
	public WebDriver createDriver() {    // DO NOT CHANGE THE METHOD SIGNATURE
	    
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver' and return it
	    driver=DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
	    
	    // return driver
	    return driver;
	}
	
	public void formSubmit(String gender) {     // DO NOT CHANGE THE METHOD SIGNATURE
	    // Locate the required WebElements, fill the form with the below values and then submit the form
	    // Use sendKeys() method to fill the content 
	    // For ex. driver.findElement(By.id("name").sendKeys("Rahul");
	    
	    /*  Set Name as "Rahul" 
            Set Mobile Number as 2106543210
            Set DOB 21/12/1985
            Locate the Web Element corresponding to the ‘Gender’ (Radio button Field) using specific locators.
            Use the click() method and choose the radio option
                If gender value is 'Male' locate the web element corresponding to radiobutton1
                if type value is 'Female' locate the web element corresponding to radiobutton2
                Choose the gender based on the parameter passed to this method
            Set Address as 'Coimbatore' */
	      
	    // Submit the form by clicking the 'Register' button
	    
	    // Locate the gender output displayed in output. Get its text and print it in console. 
       
        driver.findElement(nameElement).sendKeys("Rahul");
        driver.findElement(mobileElement).sendKeys("2106543210");
        driver.findElement(dobElement).sendKeys("21/12/1985");
        
        
        if (gender.equalsIgnoreCase("Male"))
        {
        	driver.findElement(By.xpath("//*[@id=\'male\']")).click();
        }
        else if (gender.equalsIgnoreCase("Female"))
        {
        	driver.findElement(By.xpath("//*[@id=\'female\']")).click();
        }
        
        
        
        
        
        driver.findElement(addressElement).sendKeys("Coimbatore");
        driver.findElement(registerbuttonElement).click();
        
        System.out.println(driver.findElement(By.xpath("//*[@id='errorMessage']/table/tbody/tr[5]/td[2]")).getText());
	}
	

	public static void main(String[] args) {    // DO NOT CHANGE THE METHOD SIGNATURE
	
	    Registration reg=new Registration();
	    reg.createDriver();
	    reg.formSubmit("Male");
	   
	}
}

