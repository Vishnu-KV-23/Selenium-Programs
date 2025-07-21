import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserDetails { // Do not change the class name

	public WebDriver driver;
	public WebElement element;

	public UserDetails() {
	}

	public UserDetails(WebDriver driver) {
		this.driver = driver;
	}

	public void setName(String name) {
		element = driver.findElement(By.id("name"));
		element.clear();
		element.sendKeys(name);
	}

	public void setAddress(String address) {
		element = driver.findElement(By.id("address"));
		element.clear();
		element.sendKeys(address);
	}

	public void setMobile(String mobile) {
		element = driver.findElement(By.id("mobile"));
		element.clear();
		element.sendKeys(mobile);
	}

	public void setEmail(String email) {
		element = driver.findElement(By.id("email"));
		element.clear();
		element.sendKeys(email);
	}

	public void submit() {
		element = driver.findElement(By.id("Submit"));
		element.click();
	}

	public String getSuccessMessage() {
		element = driver.findElement(By.id("result"));
		return element.getText();
	}
}
