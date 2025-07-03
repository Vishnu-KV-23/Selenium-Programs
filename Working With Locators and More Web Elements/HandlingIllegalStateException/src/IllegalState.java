import org.openqa.selenium.WebDriver;

public class IllegalState {
    private static WebDriver driver;
    private String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_stud.html";

    public IllegalState(WebDriver driver) {
        this.driver = driver;
    }

    public IllegalState() {
    }

    public Exception setupDriver() { // Do not change the method signature
        try {
            // Invoke the getDriver() method from the DriverSetup file
            driver = DriverSetup.getDriver();
            
            // Navigate to the URL specified by the 'baseUrl' variable
            driver.get(baseUrl);
            
            // If no exception occurs, return null
            return null;
   
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof IllegalStateException)
            	return e;
            else return new IllegalStateException("Setup failed", e);
        }
    }

    public static void main(String[] args) { // Do not change the method signature
        IllegalState reg = new IllegalState();
        reg.setupDriver();
    }
}