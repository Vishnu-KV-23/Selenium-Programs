package setup;

/* IMPORTANT:- DriverSetup --getWebDriver()
-------------------------------------------------
PLEASE DO NOT MAKE ANY CHANGES OR MOFICATIONS IN THIS PROGRAM */

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
    if(driver == null)
    {
        /*  For Chrome Browser,
    please modify the below driver setup code
        */
    System.setProperty("webdriver.gecko.driver", "D:/Gayathri/Softwares/geckodriver-v0.33.0-win64/geckodriver.exe");
            FirefoxBinary firefoxBinary = new FirefoxBinary();
          //  firefoxBinary.addCommandLineOptions("--headless");
            FirefoxProfile profile=new FirefoxProfile();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            firefoxOptions.setProfile(profile);
            driver=new FirefoxDriver(firefoxOptions);
    }
        return driver;
}
}
