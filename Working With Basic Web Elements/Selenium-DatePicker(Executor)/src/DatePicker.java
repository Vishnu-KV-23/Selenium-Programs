import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class DatePicker extends DriverSetup {
    public static WebDriver driver;
    public static String baseUrl = "https://webapps.tekstac.com/Registration/";
    public static String Date = "2024-02-02";
    
    public DatePicker(WebDriver driver) {
        this.driver = driver;
    }
    
    public DatePicker() {
    }
    
    public WebDriver createDriver() {
        // Create driver using DriverSetup's getDriver method
        driver = getDriver();
        
        // Navigate to the base URL
        driver.get(baseUrl);
        
        // Return the driver instance
        return driver;
    }
    
    public void setElement(String date) {
        try {
            // Locate the Date of Birth input element
            // Common selectors for date input fields
            WebElement dateElement = null;
            
            // Try multiple locator strategies to find the date input
            try {
                // Try by input type="date"
                dateElement = driver.findElement(By.cssSelector("input[type='date']"));
            } catch (Exception e) {
                try {
                    // Try by name attribute (common for date fields)
                    dateElement = driver.findElement(By.name("dob"));
                } catch (Exception e2) {
                    try {
                        // Try by id (if it has an id)
                        dateElement = driver.findElement(By.id("dateOfBirth"));
                    } catch (Exception e3) {
                        try {
                            // Try by placeholder text
                            dateElement = driver.findElement(By.xpath("//input[@placeholder='Date Of Birth' or @placeholder='dd/mm/yyyy' or @placeholder='mm/dd/yyyy']"));
                        } catch (Exception e4) {
                            // Try generic approach - find input near "Date Of Birth" text
                            dateElement = driver.findElement(By.xpath("//label[contains(text(),'Date Of Birth')]/following-sibling::input | //text()[contains(.,'Date Of Birth')]/following::input[1]"));
                        }
                    }
                }
            }
            
            // Click on the date element to trigger the date picker (if needed)
            dateElement.click();
            
            // Create JavaScript Executor instance
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            
            // Set the date using JavaScript Executor
            // Method 1: Direct value assignment
            jsExecutor.executeScript("arguments[0].value = arguments[1];", dateElement, date);
            
            // Method 2: Trigger change event to ensure the form recognizes the change
            jsExecutor.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", dateElement);
            
            // Alternative method using setAttribute (uncomment if needed)
            // jsExecutor.executeScript("arguments[0].setAttribute('value', arguments[1]);", dateElement, date);
            
            // Optional: Remove focus from the element
            jsExecutor.executeScript("arguments[0].blur();", dateElement);
            
            System.out.println("Date set successfully: " + date);
            
        } catch (Exception e) {
            System.err.println("Error setting date: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        DatePicker reg = new DatePicker();
        reg.createDriver();
        reg.setElement("2024-02-02");
        
        // Optional: Keep the browser open for verification
        try {
            Thread.sleep(3000); // Wait 3 seconds to see the result
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Close the browser (uncomment if you want to close automatically)
        // driver.quit();
    }
}