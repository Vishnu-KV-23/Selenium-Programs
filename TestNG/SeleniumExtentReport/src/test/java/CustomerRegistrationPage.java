import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CustomerRegistrationPage {
	public static WebDriver driver;

	public CustomerRegistrationPage(){}

	public CustomerRegistrationPage(WebDriver driver){
		this.driver = driver;
	}

    public void setName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void setMobileNumber(String mobileNumber) {
        driver.findElement(By.id("mobile")).sendKeys(mobileNumber);
    }

    public void setDOB(String dob) {
        driver.findElement(By.id("dob")).sendKeys(dob);
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            driver.findElement(By.id("male")).click();
        } else if (gender.equalsIgnoreCase("Female")) {
            driver.findElement(By.id("female")).click();
        }
    }

    public void setAddress(String address) {
        driver.findElement(By.id("address")).sendKeys(address);
    }

    public void clickSubmitButton() {
        driver.findElement(By.id("register")).click();
    }

    public String getResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));
        return resultElement.getText();
    }
}