package definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.interactions.Actions;


import setup.DriverSetup;

public class CakeBookingStepDefinition {

    private WebDriver driver;
    private String baseUrl = "https://webapps.tekstac.com/IceCakes/cakes.html";
    
    @Given("Navigate to CakesPage")
    public WebDriver navigate_to_cakes_page(){
        driver=DriverSetup.getDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        return driver;
    }
    
    @Then("Double Click on Cake {string}")
    public String double_click_on_cake(String flavour){
        String xpath=String.format("//img[contains(@longdesc,'%s')]",flavour);
        WebElement img=driver.findElement(By.xpath(xpath));
        
        new Actions(driver).doubleClick(img).perform();
        
        WebElement title=img.findElement(By.xpath("../../div[contains(@class,'flip-card-back')]/h1"));
        String text=title.getText();
        System.out.println("Selected cake: "+text);
        return text;
    }
  
    //Add Step definitions here as per description
    

}