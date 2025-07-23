import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFormSteps {

    public static WebDriver driver;
    public static String result;

    /*
     * -------------------------------------------------
     * 1. Launch browser and open the URL
     * -------------------------------------------------
     */
    @Given("Start firefox browser and open the application")
    public void navigateToUrlPage() {
        driver = DriverSetup.getDriver(); // headless Firefox from the util class
        driver.get("https://webapps.tekstac.com/selenium/LOGIN_WEBPAGE/index.html");
    }

    /*
     * -------------------------------------------------
     * 2. Submit the credentials sent by TestNG
     * -------------------------------------------------
     */
    @When("User enters login credentials from testNG parameter")
    public void submitUserCredentials() {
        String email = System.getProperty("email"); // set in runner
        String password = System.getProperty("password");

        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    /*
     * -------------------------------------------------
     * 3. Read the result text after submission
     * -------------------------------------------------
     */
    @Then("Get the result from the web page")
    public void getResult() {
        WebElement resElement = driver.findElement(By.id("result"));
        result = resElement.getText(); // store in static variable
        System.out.println("Result captured: " + result);
    }
}
