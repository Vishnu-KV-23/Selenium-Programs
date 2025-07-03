
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class ImplicitWait {

	public static WebDriver driver;
	WebElement Nametxt;
	String baseUrl = "https://webapps.tekstac.com/PurchaseApp/";
	static String text;

	public ImplicitWait(WebDriver driver) {
		this.driver = driver;
	}

	public ImplicitWait() {
	}

	public WebDriver setupDriver() {
		//Create driver,store it in static variable driver, navigate to baseUrl and return it
        driver=DriverSetup.getDriver();
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get(baseUrl);
        return driver;
	}

	public String getPageTitle() {
		// get the page title
        //return pageTitle;
		System.out.print(driver.getTitle());
		return driver.getTitle();
		//return null;
	}

	public WebElement clickBtn() {
		//Locate Corresponding Web Element and Enter quantity in the input field
		List<WebElement> textBoxes=driver.findElements(By.xpath("//input[@type='text']"));
		for (WebElement i : textBoxes)
		{
			i.sendKeys("1");
		}
		//Locate Corresponding Web Element and Click on the checkbox
		
		
		List<WebElement> checkBoxes=driver.findElements(By.xpath("//input [@type='checkbox']"));
		for ( WebElement j : checkBoxes)
		{
			j.click();
		}
		//driver.findElements(By.xpath("//input [@type='checkbox']")).click();
        //Locate Corresponding Web Element and Click on the show button
		driver.findElement(By.xpath("//*[@id=\'show\']")).click();
        //Set an implicit wait of 50 seconds to handle dynamic content loading
		 
        //Find and return the table values that describe the purchased items as WebElement.
		
		return driver.findElement(By.xpath("//*[@id=\"showOrHide\"]/table"));
	}
	public static void main(String[] args) {
		ImplicitWait locator = new ImplicitWait();
		locator.setupDriver();
		locator.getPageTitle();
		locator.clickBtn();
		//System.out.println(hehe.getText());
	}
}
