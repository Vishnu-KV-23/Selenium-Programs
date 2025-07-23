// DO NOT CHANGE THE PACKAGE NAME
package definitions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import io.cucumber.java.en.*;
import io.cucumber.java.After;
import setup.DriverSetup;

public class StepDefinitions {

	WebDriver driver;
	static String verifyTitle;
	static String verifyName;

	/* ---------- helper getters --------- */
	public static String getVerifyTitle() {
		return verifyTitle;
	}

	public static String getVerifyName() {
		return verifyName;
	}

	/* ---------- GIVEN ---------- */
	@Given("^Start firefox browser and open the application$")
	public WebDriver setUp() {
		driver = DriverSetup.getDriver();
		driver.get("https://webapps.tekstac.com/LibraryManagementCucumber/");
		driver.manage().window().maximize();
		return driver;
	}

	/* ---------- WHEN #1 ---------- */
	@When("^check the title \"([^\"]*)\"$")
	public void checkTitle(String Title) {
		String heading = driver.findElement(By.tagName("h1")).getText().trim();
		verifyTitle = heading;
		Assert.assertEquals(Title, heading);
	}

	/* ---------- WHEN #2 ---------- */
	@When("^enter borrower details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enterBorrowerDetail(String Name, String Type, String Date,
			String BookName, String BookAuthor, String BookCategory) {

		driver.findElement(By.id("borrowername")).clear();
		driver.findElement(By.id("borrowername")).sendKeys(Name);

		if (Type.equalsIgnoreCase("Member"))
			driver.findElement(By.id("type1")).click();
		else
			driver.findElement(By.id("type2")).click();

		driver.findElement(By.id("borrowerdate")).clear();
		driver.findElement(By.id("borrowerdate")).sendKeys(Date);

		driver.findElement(By.id("bookname")).clear();
		driver.findElement(By.id("bookname")).sendKeys(BookName);

		driver.findElement(By.id("bookauthor")).clear();
		driver.findElement(By.id("bookauthor")).sendKeys(BookAuthor);

		new Select(driver.findElement(By.id("bookcategory")))
				.selectByVisibleText(BookCategory);
	}

	/* ---------- THEN ---------- */
	@Then("^register \"([^\"]*)\"$")
	public void register(String name) throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		Thread.sleep(500); // small wait for table update
		WebElement cell = driver.findElement(
				By.xpath("//div[@id='result']//table//tr[2]/td[1]"));
		verifyName = cell.getText().trim();
		Assert.assertEquals(name, verifyName);
	}

	/* ---------- CLEAN-UP ---------- */
	//@After
	//public void tearDown() {
	//	if (driver != null)
	//		driver.quit();
	//}
}
