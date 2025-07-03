import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameLocator { // DO NOT change the class name

    // Use the below declared variable
    public static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/Handling_Regular_Expression/";

    public WebDriver createDriver() { // DO NOT CHANGE THE METHOD SIGNATURE
        driver = DriverSetup.getWebDriver();
        driver.get(baseUrl);
        return driver;
    }

    public void setFormValues(WebDriver driver) { // DO NOT CHANGE THE METHOD SIGNATURE
        // Set value "Shamili" in the input box and click the Search button
        driver.findElement(By.id("userId")).sendKeys("Shamili");
        driver.findElement(By.id("track")).click();
    }

    public WebElement getEmailResultElement(WebDriver driver) { // DO NOT CHANGE THE METHOD SIGNATURE
        // Return the email WebElement displayed after form submission
        return driver.findElement(By.xpath("//div[@id='e- mail']"));
    }

    public boolean validateEmail(String eMailID) { // DO NOT CHANGE THE METHOD SIGNATURE
        // Validate the email using the provided regex pattern
        String regex = "\\b[A-Z0-9a-z-]+@[a-z]+\\.[a-z]{2,4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(eMailID);
        return matcher.matches();
    }

    public static void main(String[] args) { // DO NOT CHANGE THE METHOD SIGNATURE
        NameLocator reg = new NameLocator();
        WebDriver driver = reg.createDriver();
        reg.setFormValues(driver);

        WebElement emailElement = reg.getEmailResultElement(driver);
        String emailText = emailElement.getText();

        System.out.println("Email Text: " + emailText);
        boolean isValid = reg.validateEmail(emailText);
        System.out.println("Valid Email? " + isValid);

        driver.quit();
    }
}
