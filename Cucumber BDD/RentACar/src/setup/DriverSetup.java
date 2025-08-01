package setup;

//CHANGE THE GECKODRIVER FILE PATH WHEN YOU ARE WORKING LOCALLY

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverSetup
{ 
    private static WebDriver driver;
    public static WebDriver getDriver()
	{
	    if(driver == null){
            System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            FirefoxProfile profile=new FirefoxProfile();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            firefoxOptions.setProfile(profile);
            driver=new FirefoxDriver(firefoxOptions);
	    }
        return driver;
	}
}
