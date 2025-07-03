import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locator {  // Do not change the class name

    // Use the below declared variables
	public static WebDriver driver; 
	public static String fileNametxt, successtxt;  
	String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_stud.html";
	
	public WebDriver setupDriver() {  // Do not change the method signature
	    
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver' and return it
		driver= DriverSetup.getWebDriver();
		//driver.get(baseUrl);
	    return driver;
	   
	}
	
	
	public void pageNavigate(){
	    driver.navigate().to(baseUrl);
	    // navigate to the URL 'https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_stud.html'
	}
	
	public String getPageTitle() {
		
		// get the page title and return it
		return driver.getTitle();
	}
	
	
	public void clickPhotoUploadBtn() {
		
		// Click the 'Photo Upload' Button in the page
		driver.findElement(By.xpath("//input[@type='button']")).click();
		WebDriverWait wait = new WebDriverWait(driver ,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("completed")));
		// Handle Selenium wait for element to be visible 
		// Wait for 3 seconds
	}
	

	public String getFileName() {
		
		// After wait of 3 seconds in method clickPhotoUploadBtn(), file name will be displayed.
		// Locate the WebElement corresponding to the uploaded file name. 
		// get the text, store it in a static variable 'fileNametxt' and return it. 
		
		fileNametxt= driver.findElement(By.id("filename")).getText();
		
		return fileNametxt;
	}
	
	
	public String getSuccessMessage() {
		
		// After wait of 3 seconds in method clickPhotoUploadBtn(), photo upload success message will be displayed.
		// Locate the WebElement corresponding to the uploaded success message. 
		// get the text, store it in a static variable 'successtxt' and return it.  
		successtxt= driver.findElement(By.id("completed")).getText();
		
		return successtxt;
		
	}
	
	
	public void closeBrowser(){
	    
	    driver.quit();
	}

	
	public static void main(String[] args) {  // Do not change the method signature
	    
	    Locator locator=new Locator();
	    locator.setupDriver();
	    
	    locator.pageNavigate();
	    System.out.println(locator.getPageTitle());
	    
	    locator.clickPhotoUploadBtn();
	    locator.getFileName();
	    locator.getSuccessMessage();
	    
	    locator.closeBrowser();
	    
	}

}

