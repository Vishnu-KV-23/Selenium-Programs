import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
    public static WebDriver driver;
    
    public BaseClass() {
    }
    public BaseClass(WebDriver driver)
    {
    	this.driver=driver;
    }
    public void openBrowser() {
        
        // Invoke the getDriver method from DriverSetup, store the returned driver object in a static variable 'driver'.
        driver = DriverSetup.getDriver();
    }
    public void navigateTo(String url) {
        
        // Navigates to the specified URL using the provided 'url' parameter.
        driver.get(url);
    }
    public void click(String locatorType, String locatorValue) {
        
        // This method clicks on a web element using the provided locator type and value.

        // Use the "id" locator for identifying and interacting with the element.
        if (locatorType.equalsIgnoreCase("id")) {
            driver.findElement(By.id(locatorValue)).click();
        }
    }
    
    public void selectDropdown(String locatorType, String locatorValue, String data) {
      
        // Selects an option from a dropdown menu based on the provided locator type and value. Dynamically selects the option specified by the data parameter.

        // Use the "id" locator for identifying and interacting with the element.
        if (locatorType.equalsIgnoreCase("id")) {
            Select dropdown = new Select(driver.findElement(By.id(locatorValue)));
            dropdown.selectByVisibleText(data);
        }
    }

    public void sendKeys(String locatorType, String locatorValue, String data) {
    	
        // Enters the value from the data parameter into a web element, identified using the provided locatorType and locatorValue.

        // Use the "id" locator for identifying and interacting with the element.
        if (locatorType.equalsIgnoreCase("id")) {
            driver.findElement(By.id(locatorValue)).sendKeys(data);
        }
    }
    public String verifyConfirmMessage(String locatorType, String locatorValue) {
        
        // Retrieve and return the text of a web element identified by the provided locatorType and locatorValue.
        // Use the 'id' locator to locate the element and fetch its text.
        if (locatorType.equalsIgnoreCase("id")) {
            return driver.findElement(By.id(locatorValue)).getText();
        }
        return null;
    }
}
