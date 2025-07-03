import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOut {
    public static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_stud.html";
    static String text;

    public TimeOut(WebDriver driver) {
        this.driver = driver;
    }

    public TimeOut() {
    }

    public WebDriver setupDriver() {
        driver = DriverSetup.getDriver();
        driver.get(baseUrl);
        return driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public Exception clickPhotoUploadBtn() throws TimeoutException {
        try {
            WebElement uploadBtn = driver.findElement(By.id("file1"));
            uploadBtn.click();

            // WebDriverWait with 1 second timeout (using long value for older Selenium versions)
            WebDriverWait wait = new WebDriverWait(driver, 1);

            // Wait for element with ID "filename" to be visible
            WebElement filenameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename")));

            text = filenameElement.getText();
            System.out.println("Filename text: " + text);

            return null;
        } catch (TimeoutException e) {
            e.printStackTrace();
            return e;
        }
    }

    public static void main(String[] args) {
        TimeOut reg = new TimeOut();
        reg.setupDriver();
        System.out.println("Page Title: " + reg.getPageTitle());
        Exception ex = reg.clickPhotoUploadBtn();
        if (ex != null) {
            System.out.println("Handled Exception: " + ex.getClass().getSimpleName());
        }
        driver.quit();
    }
}