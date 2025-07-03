import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Alert;

public class ExceptionManipulation {
    public static WebDriver driver;
    static String baseUrl = "https://webapps.tekstac.com/HotelApplication/booking.html";
    
    public ExceptionManipulation() {}
    
    public ExceptionManipulation(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebDriver createDriver() {
        driver = DriverSetup.getDriver();
        driver.get(baseUrl);
        return driver;
    }
    
    public Exception handleException() {
        try {         
            Alert alert = driver.switchTo().alert();
            return null;
            
        } catch (NoAlertPresentException e) {
            return e;
        }
    }
    
    public static void main(String[] args) throws Exception {
        ExceptionManipulation mainObj = new ExceptionManipulation();
        mainObj.createDriver();
        System.out.println(mainObj.handleException());
    }
}