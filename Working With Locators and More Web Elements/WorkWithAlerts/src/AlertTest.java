import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;

public class AlertTest {   // DO NOT Change the class Name

    // Use the below declared variables 
    public static WebDriver driver;
    String baseUrl = "http://webapps.tekstac.com/MultipleWindow/";  // remove space before http

    public WebDriver createDriver() { // DO NOT change the method signature

        // Invoke the getWebDriver() method from the DriverSetup File 
        // Store it in static variable 'driver', navigate and return it
        driver = DriverSetup.getWebDriver(); // use DriverSetup
        driver.get(baseUrl);                 // navigate to the URL
        return driver;
    }

    public Alert getAlertElement(WebDriver driver) { // DO NOT change the method signature

        // Find the 'Click' button and click it
        driver.findElement(By.name("submit")).click();  // button with onclick="myFunction()"

        // Locate and return the alert
        return driver.switchTo().alert();
    }

    public static void main(String[] args) throws InterruptedException { // DO NOT change the method signature

        AlertTest at = new AlertTest();

        WebDriver driver = at.createDriver();
        Alert alert = at.getAlertElement(driver);

        // Optional: Print the alert text for verification
        System.out.println(alert.getText());

        // Accept the alert so it doesn’t block further execution
        alert.accept();

        // Close the browser after a short wait
        Thread.sleep(2000);
        driver.quit();
    }
}
