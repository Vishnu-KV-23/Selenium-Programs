import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import junit.framework.Assert;

//ADD the required TestNG annotations on respective methods

//@Listeners(FeatureTest.class)   // Do not change or remove this line
public class Ex3TestNG {
	
	//Use the below declared variable
    public static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/SeleniumApp2/Pandemic/DistrictPass.html";
	
	//Apply the required annotation
	@BeforeSuite // Annotation to run once before all tests in the suite
	public void setUpDriver() {           //DO NOT change the method signature
		
		// Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate 
	    driver = DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		
    }
	
	//Add data provider annotation with name 'testNGData'
	@DataProvider(name = "testNGData")
	public Object[][] testNGData() {         //DO NOT change the method signature

	    //Do not change the values
	    return new Object[][] { { "Suresh", "suresh@123.com","122","532","2345", "Chennai", "Male", "123456789123", "Wedding"}};
	    
	}

	//Add data provider annotation with name 'testNGData'
	@Test(dataProvider = "testNGData") // Connects this test method to the data provider
	public void testValidData(String name,String email,String mobile1,String mobile2,String mobile3, 
	            String district, String gender, String aadhaarNo, String reason) throws InterruptedException {
		
		// Apply the array values to the respective form element
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("mobile1")).sendKeys(mobile1);
		driver.findElement(By.id("mobile2")).sendKeys(mobile2);
		driver.findElement(By.id("mobile3")).sendKeys(mobile3);

		Select districtDropdown = new Select(driver.findElement(By.id("district")));
		districtDropdown.selectByVisibleText(district);

		if (gender.equals("Male")) {
			driver.findElement(By.id("gender_male")).click();
		} else {
			driver.findElement(By.id("gender_female")).click();
		}
		
		driver.findElement(By.id("aadhaar")).sendKeys(aadhaarNo);
		driver.findElement(By.id("reason")).sendKeys(reason);

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Test the tabled data against the data specified in the array
		assertEquals(name, driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/table/tbody/tr[1]/td[2]")).getText());
        assertEquals(email, driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/table/tbody/tr[2]/td[2]")).getText());
        assertEquals(mobile1 + "-" + mobile2 + "-" + mobile3, driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/table/tbody/tr[3]/td[2]")).getText());
        assertEquals(district, driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/table/tbody/tr[4]/td[2]")).getText());
        assertEquals(gender, driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/table/tbody/tr[5]/td[2]")).getText());
        assertEquals(aadhaarNo, driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/table/tbody/tr[6]/td[2]")).getText());
        assertEquals(reason, driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/table/tbody/tr[7]/td[2]")).getText());
	}
	
    //PLEASE DO NOT MODIFY THE CODE IN 	invokeTest() METHOD 
	public void invokeTest() {
	    
	    try {
			TestNG testng = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add("testng.xml");
			
			testng.setTestSuites(suites);
			testng.run();		
		
		} catch (Exception e) {
			
		} 
	    
	}
	
	public static void main(String[] args) {
		Ex3TestNG test=new Ex3TestNG();
		// Add Required Code
		test.invokeTest();
	}

}