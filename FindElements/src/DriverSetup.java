import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup { // DO NOT CHANGE THE CLASS NAME

    // DO NOT CHANGE THE METHOD SIGNATURE
    public static WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
