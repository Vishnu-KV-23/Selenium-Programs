import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegistration {
	
	public static WebDriver driver;
	public static String result;
	public static String baseurl="https://webapps.tekstac.com/Users/";
	
    public static void registration() {
        
        // Invoke the getDriver() method from the DriverSetup class and Store it in static variable 'driver'.
	    // Navigate to baseurl
         
        // Retrieves user details like Name, Address, Mobile Number, and Email ID from the config.properties file using the Singleton ConfigReader class.
        // Using Selenium WebDriver to locate web elements and fill the form fields with the values fetched from the properties file.
        // Click the "Submit" button.
        // Locates the result displayed after form submission, retrieves its text content, and stores it in the static variable 'result'.
    	driver = DriverSetup.getDriver();
    	driver.get(baseurl);
    	ConfigReader config = ConfigReader.getInstance();
        String name = config.getProperty("Name");
        String address = config.getProperty("Address");
        String mobile = config.getProperty("MobileNumber");
        String email = config.getProperty("EmailId");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("address")).sendKeys(address);
        driver.findElement(By.id("mobile")).sendKeys(mobile);
        driver.findElement(By.id("email")).sendKeys(email);

        driver.findElement(By.id("submit")).click();
        result = driver.findElement(By.id("result")).getText();
    }

    public static void main(String[] args) {
        registration();
        System.out.println("Result message: " + result);
    } // Inserted semicolon here
}