import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locator { // DO NOT CHANGE THE CLASS NAME

    // Use the below declared variables 
    public static WebDriver driver;
    public static WebElement resultElmt;
    String baseUrl = "https://webapps.tekstac.com/Handling_Reg_Expression/";

    public WebDriver createDriver() { // DO NOT CHANGE THE METHOD SIGNATURE

        // Invoke the getWebDriver() method from the DriverSetup File
        driver = DriverSetup.getWebDriver();

        // Navigate to the base URL
        driver.get(baseUrl);

        return driver;
    }

    public void setUsername() { // DO NOT CHANGE THE METHOD SIGNATURE

        // Identify input field using id='userId' and send text "Shamili"
        WebElement inputField = driver.findElement(By.id("userId"));
        inputField.sendKeys("Shamili");
    }

    public void clickSearchBtn() { // DO NOT CHANGE THE METHOD SIGNATURE

        // Identify search button by id='track' and click
        WebElement searchBtn = driver.findElement(By.id("track"));
        searchBtn.click();
    }

    public WebElement getResult() { // DO NOT CHANGE THE METHOD SIGNATURE

        // Identify the result div using id='result' and store in resultElmt
        resultElmt = driver.findElement(By.id("result"));
        return resultElmt;
    }

    public static void main(String[] args) { // DO NOT CHANGE THE METHOD SIGNATURE

        Locator loc = new Locator();

        loc.createDriver();
        loc.setUsername();
        loc.clickSearchBtn();

        WebElement elemt = loc.getResult();
        System.out.println("The displayed result is:\n" + elemt.getText());
    }
}