/*PLEASE DO NOT MAKE ANY CHANGES OR MOFICATIONS IN THIS PROGRAM */
package mypack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
 
public class DriverSetup {  // DO NOT CHANGE THE CLASS NAME
    private static WebDriver driver;
    public static WebDriver getDriver() {    // DO NOT CHANGE THE METHOD SIGNATURE
	    System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		driver = new FirefoxDriver();
		String baseUrl = "https://webapps.tekstac.com/Shopify/";
		driver.get(baseUrl);
	    return driver;
 
	}
}