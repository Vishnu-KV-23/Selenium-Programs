import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.manager.SeleniumManager;


public class ConfigSetup
{ 
    //Please do not make any changes on variables and method signature
	public static String browserName, driverName, driverPath; 
	
    public static String getBrowserName() // DO NOT CHANGE THE METHOD SIGNATURE
    {
        //Implement you code here
    	browserName="firefox";
    	return browserName;
    	
	}	
    
    public static String getDriverName() // DO NOT CHANGE THE METHOD SIGNATURE
    {
        
    	driverName ="webdriver.gecko.driver";
    	return driverName;
	}	
    
    public static String getDriverPath() // DO NOT CHANGE THE METHOD SIGNATURE
    {
        //Implement you code here
    	//FirefoxOptions options = new FirefoxOptions();

        // Optional: Get GeckoDriver path using Selenium Manager (for logging/debugging)
        driverPath = "/usr/bin/geckodriver";
    	return driverPath;
	}	
}