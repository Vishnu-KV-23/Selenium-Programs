import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RegistrationPage {

    private static WebDriver driver;
    private String baseUrl = "https://webapps.tekstac.com/Agent_Registration/";

    public RegistrationPage() {}
    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public WebDriver createDriver()
    {
        driver = DriverSetup.getDriver();
        driver.get(baseUrl);
        return driver;
    }

    public void setFirstName(String firstName) {
        WebElement lastNameElement = driver.findElement(By.name("lastname"));
        WebElement firstNameElement = driver.findElement(RelativeLocator.with(By.name("firstname")).above(lastNameElement));
        firstNameElement.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebElement firstNameElement = driver.findElement(By.name("firstname"));
        WebElement lastNameElement = driver.findElement(RelativeLocator.with(By.name("lastname")).near(firstNameElement));
        lastNameElement.sendKeys(lastName);
    }

    public void setUserName(String userName) {
        WebElement lastNameElement = driver.findElement(By.name("lastname"));
        WebElement userNameElement = driver.findElement(RelativeLocator.with(By.name("username")).below(lastNameElement));
        userNameElement.sendKeys(userName);
    }

    public void setPassword(String password) {
        WebElement userNameElement = driver.findElement(By.name("username"));
        WebElement passwordElement = driver.findElement(RelativeLocator.with(By.name("password")).below(userNameElement));
        passwordElement.sendKeys(password);
    }

    public void setPhoneNumber(String phoneNumber) {
        WebElement passwordElement = driver.findElement(By.name("password"));
        WebElement phoneNumberElement = driver.findElement(RelativeLocator.with(By.name("phonenumber")).below(passwordElement));
        phoneNumberElement.sendKeys(phoneNumber);
    }

    public void setEmail(String email) {
        WebElement submitButton = driver.findElement(By.id("submit"));
        WebElement emailElement = driver.findElement(RelativeLocator.with(By.name("email")).above(submitButton));
        emailElement.sendKeys(email);
    }

    public void submit() {
        WebElement resetButton = driver.findElement(By.id("reset"));
        WebElement submitButton = driver.findElement(RelativeLocator.with(By.id("submit")).toLeftOf(resetButton));
        submitButton.click();
    }

    public WebElement getName() {
        WebElement nameLabel = driver.findElement(By.xpath("//td[text()='Name']"));
        WebElement nameValue = driver.findElement(RelativeLocator.with(By.tagName("td")).toRightOf(nameLabel));
        return nameValue;
    }

    public static void main(String[] args) {
        RegistrationPage reg=new RegistrationPage();
        reg.createDriver();
        reg.setFirstName("John");
        reg.setLastName("S");
        reg.setUserName("JohnSmith");
        reg.setPassword("vvs");
        reg.setPhoneNumber("9898989898");
        reg.setEmail("john.smith@gmail.com");
        reg.submit();
    }
}