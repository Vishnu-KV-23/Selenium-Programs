import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Set;

public class TabExploration { // Do not change the class name

    // Use these declarations to store respective values
    static String parentWinHandle, parentWinTitle;
    static String childWinHandle, childWinTitle;
    static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/PurchaseApp/";

    public WebDriver createDriver() { // Do not change the method signature
        // Invoke the getDriver() method from the DriverSetup File
        // Store it in static variable 'driver', navigate to baseurl and return it
        driver = DriverSetup.getDriver();
        driver.get(baseUrl);
        return driver;
    }

    public String getParentWindow() throws Exception { // Do not change the method signature
        // Get the handle of the parent window as a string and store it in static variable 'parentWinHandle'
        // Get the title of the current page, store it in 'parentWinTitle' and return it.
        parentWinHandle = driver.getWindowHandle();
        parentWinTitle = driver.getTitle();
        return parentWinTitle;
    }

    public WebElement getChildWindow() throws Exception { // Do not change the method signature
        // Click the href link to open the child window 'Computer'
        driver.findElement(By.xpath("//*[@id=\"itemtable\"]/tbody/tr[2]/td[2]/a")).click();

        // Wait for the child window to open (adjust the wait time as needed)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Find the child window handle
        for (String handle : allWindowHandles) {
            if (!handle.equals(parentWinHandle)) {
                childWinHandle = handle;
                break;
            }
        }

        // Switch to the child window
        driver.switchTo().window(childWinHandle);
        
        // Get and store the child window title
        childWinTitle = driver.getTitle();

        // The WebElement corresponding to the first <h3> tag is retrieved and returned
        WebElement h3Element = driver.findElement(By.tagName("h3"));

        return h3Element;
    }

    public static void main(String[] args) throws Exception { //Do not change the method signature
        TabExploration win = new TabExploration();
        // Implement code here
        win.createDriver();
        win.getParentWindow();
        WebElement h3Element = win.getChildWindow();
        
        // Optional: Print the h3 element text for verification
        System.out.println("H3 Element Text: " + h3Element.getText());
        
        // Close the driver
        driver.quit();
    }
}