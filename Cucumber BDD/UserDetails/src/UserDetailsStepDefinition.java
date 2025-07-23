import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class UserDetailsStepDefinition {

    public static WebDriver driver;
    public static UserDetailsPage user;
    public static final String BASE_URL = "https://webapps.tekstac.com/Users/";
    private String expectedName; // used for a simple assertion

    /*
     * -------------------------------------------------
     * Given – open the User Details page
     * -------------------------------------------------
     */
    @Given("Navigate to User Details page")
    public void navigate_to_user_details_page() {
        driver = DriverSetup.getDriver(); // headless Firefox (provided util)
        driver.get(BASE_URL);
        user = new UserDetailsPage(driver);
    }

    /*
     * -------------------------------------------------
     * When – fill the four fields (Name, Address, Phone, Email)
     * -------------------------------------------------
     */
    @When("Enter Details: {string}, {string}, {string}, {string}")
    public void enter_details(String name, String address,
            String phoneNumber, String email) {

        expectedName = name; // remember for later check

        user.setName(name);
        user.setAddress(address);
        user.setMobileNumber(phoneNumber);
        user.setEmail(email);
    }

    /*
     * -------------------------------------------------
     * And – submit the form
     * -------------------------------------------------
     */
    @And("Submit the form")
    public void submit_the_form() {
        user.clickSubmitButton();
    }

    /*
     * -------------------------------------------------
     * Then – fetch and print the result
     * -------------------------------------------------
     */
    @Then("Display result")
    public String display_result() {
        String resultText = user.getResultText();
        System.out.println("Result shown on page:\n" + resultText);

        // very light check: the result should contain the name just entered
        Assert.assertTrue(resultText.contains(expectedName),
                "Result area does not contain the submitted name!");
        driver.quit();
        return resultText; // returned per the specification
    }
}
