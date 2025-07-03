import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MultipleWindows {
    //Do not change the class name
    //Use these declarations to store respective values
    static String parentWinHandle, parentWinTitle;
    static String childWinHandle, childWinTitle;
    Set<String> winHandles;
    
    static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/TrainReservation/login.html";
    
    public WebDriver createDriver() {
        //Do not change the method signature
        // Invoke the getWebDriver() method from the DriverSetup File
        // Store it in static variable 'driver', navigate and return it
        
        driver = DriverSetup.getWebDriver();
        // Please do NOT remove the below URL navigation code
        driver.get(baseUrl);
        
        return driver;
    }
    
    public String getParentWindow() throws Exception {
        //Do not change the method signature
        // Get Parent Window Handle as string and return it
        //Get the page title and store it in 'parentWinTitle'
        
        parentWinHandle = driver.getWindowHandle();
        parentWinTitle = driver.getTitle();
        
        return parentWinHandle;
    }
    
    public String getChildWindow() throws Exception {
        //Do not change the method signature
        // Click the href link. Find the child window's handle and return it.
        //Hint: WAIT for child page to load and find the child window handle.
        //Get the page title and store it in 'childWinTitle'
        
        // Click on "Signup Using Google" button
        WebElement signupButton = driver.findElement(By.linkText("Signup Using Google"));
        signupButton.click();
        
        // Wait for child window to open
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        
        // Get all window handles
        winHandles = driver.getWindowHandles();
        
        // Find the child window handle
        Iterator<String> iterator = winHandles.iterator();
        while (iterator.hasNext()) {
            String windowHandle = iterator.next();
            if (!windowHandle.equals(parentWinHandle)) {
                childWinHandle = windowHandle;
                break;
            }
        }
        
        // Switch to child window to get its title
        driver.switchTo().window(childWinHandle);
        childWinTitle = driver.getTitle();
        
        return childWinHandle;
    }
    
    public static void main(String[] args) throws Exception {
        //Do not change the method signature
        MultipleWindows win = new MultipleWindows();
        
        // Create driver and navigate to base URL
        win.createDriver();
        
        // Get parent window handle
        String parentHandle = win.getParentWindow();
        System.out.println("Parent Window Handle: " + parentHandle);
        
        // Get child window handle by clicking the signup button
        String childHandle = win.getChildWindow();
        System.out.println("Child Window Handle: " + childHandle);
        
        // Print window titles
        System.out.println("Parent Window Title: " + parentWinTitle);
        System.out.println("Child Window Title: " + childWinTitle);
        
        // Switch back to parent window
        driver.switchTo().window(parentWinHandle);
        
        // Close all windows and quit driver
        driver.quit();
    }
}