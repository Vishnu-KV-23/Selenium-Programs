package setup;


import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {

private WebDriver driver;
 
    @Before
    public void setUp() {
        setDriver();
    }
 
    public void setDriver() {
 
    driver = DriverSetup.getDriver();
    driver.get("https://webapps.tekstac.com/AirlinesBookingCucumber/");
       
    }
 
    public WebDriver getDriver() {
        return driver;
    }
 
    @After
    public void tearDown() {
    //    getDriver().quit();
    }
}

