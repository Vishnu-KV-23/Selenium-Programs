import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchFrameException;

public class ExceptionManipulation {

	public static WebDriver driver;
	static String baseUrl = "https://webapps.tekstac.com/PurchaseApp/";

	public ExceptionManipulation() {}

	public ExceptionManipulation(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver createDriver() {
		driver = DriverSetup.getDriver();
		driver.get(baseUrl);
		return driver;
	}

	public Exception handleException(String locator) {
		try {
			driver.switchTo().frame(locator);
			return null;
		} catch (NoSuchFrameException e) {
			return e;
		}
	}

	public static void main(String[] args) throws Exception {
		ExceptionManipulation mainObj = new ExceptionManipulation();
		mainObj.createDriver();
		System.out.println(mainObj.handleException("nonFrameElement"));
	}
}
