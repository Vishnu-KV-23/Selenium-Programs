import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoAlertPresentException;
import org.apache.logging.log4j.core.config.Configurator;


public class LoginPage {

	private WebDriver driver;	
	public static String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/login.html";
	
	// Initialize a static logger instance for the LoginPage class using Log4j2
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	
	// Default constructor
	public LoginPage() {	}
	
	// Constructor with WebDriver parameter
	public LoginPage(WebDriver driver) {
		this.driver = driver;
    }
	
	// Method to create and initialize the WebDriver
	public WebDriver createDriver() {
		 // Call the 'getDriver' method to initialize the driver,store it in static variable driver, navigate to baseUrl and return it
		 // Log the successful creation of the driver
		 // Then, Log the error if driver creation or navigation fails
		try {
            driver = DriverSetup.getDriver(); // getDriver() returns a singleton WebDriver
            driver.get(baseUrl);
            logger.info("Driver created and navigated to base URL successfully.");
        } catch (Exception e) {
            logger.error("Error while creating driver or navigating to URL: " + e.getMessage());
        }
        return driver;
	}
	
	// Method to set the Username field
	public void setUsername() {
		// Locate the username field by its ID and enter the value "admin"
		// Log an error message if locating the username field fails
		try {
            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("admin");
            logger.info("Username set successfully.");
            Thread.sleep(2000);    
        } catch (Exception e) {
            logger.error("Error setting username: " + e.getMessage());
        }
	}
	
	// Method to set the Password field
	public void setPassword() {
	// Locate the password field by its ID and enter the value "admin#123"
	// Log an error message if locating the password field fails
		try {
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("admin#123");
            logger.info("Password set successfully.");
            Thread.sleep(2000);    
        } catch (Exception e) {
            logger.error("Error setting password: " + e.getMessage());
        }
	}
	
	// Method to set the Captcha field
	public void solveCaptcha() {
	// Identify and retrieve the WebElement corresponding to the captcha code generated
	// Set the retrieved captcha code into the input field
	// Log an error message if locating the captcha field fails
		try {
            WebElement captchaCode = driver.findElement(By.id("result"));
            String code = captchaCode.getText();
            WebElement captchaInput = driver.findElement(By.id("captcha"));
            captchaInput.sendKeys(code);
            logger.info("Captcha solved successfully. Value: " + code);
            Thread.sleep(2000);    
        } catch (Exception e) {
            logger.error("Error solving captcha: " + e.getMessage());
        }
	}
	
	// Method to set the Submit button field
	public void submitLogin() {
	// Identify and click the WebElement corresponding to the Submit button
	// Log an error message if locating the Submit button fails
		try {
            WebElement submit = driver.findElement(By.id("submit"));
            submit.click();
            logger.info("Login submitted successfully.");
            Thread.sleep(2000);    
        } catch (Exception e) {
            logger.error("Error submitting login: " + e.getMessage());
        }
	}
	
	// Method to handle the alert
	public String alertHandle() throws Throwable
	{
		 // Switch to the alert
		 // Get the text from the alert
		 // Accept the alert (click OK)
		 // Log the alert text
		 // Log an error message if no alert is present
		 // Return the text from the alert
		try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            logger.info("Alert handled. Message: " + alertText);
            return alertText;
        } catch (NoAlertPresentException e) {
            logger.error("No alert present: " + e.getMessage());
            return null;
        }
		 //return null;
	
	}
	
public static void main(String[] args) throws Exception
{
    Configurator.initialize(null, "CustomizedLog/src/main/resources/log4j2.xml"); //Do not remove the line
	LoginPage registerObj = new LoginPage();
	
	WebDriver driver = registerObj.createDriver();
	registerObj.setUsername();
	registerObj.setPassword();
	registerObj.solveCaptcha();
	registerObj.submitLogin();
	try {
		registerObj.alertHandle();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	            
	

}
	

}