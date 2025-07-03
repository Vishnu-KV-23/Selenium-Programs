import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseApp {	//DO NOT change the class name

    //Use the below declared variable
    private static WebDriver driver;
    private String baseUrl = "https://webapps.tekstac.com/PurchaseApp/";
	
	public PurchaseApp() {}
	public PurchaseApp(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver createDriver() {
		//Create driver, store it in static variable driver, navigate to baseUrl and return it
		driver = DriverSetup.getDriver();
		driver.get(baseUrl);
		return driver;
	}
	
	public String chooseItemPreQuantity() {
		// Clicks on the "Computer" checkbox and gets the error message
		WebElement computerCheck = driver.findElement(By.id("ComputerCheck"));
		computerCheck.click();
		WebElement errorMsg = driver.findElement(By.id("errormsg"));
		return errorMsg.getText();
	}
	
	public void chooseItemPostQuantity(String computerQuantity, String laptopQuantity, String mobileQuantity, String televisionQuantity, String refrigeratorQuantity) {
		// Set quantity and check each item
		WebElement compQty = driver.findElement(By.id("ComputerQuantity"));
		compQty.sendKeys(computerQuantity);
		driver.findElement(By.id("ComputerCheck")).click();
		
		WebElement lapQty = driver.findElement(By.id("LaptopQuantity"));
		lapQty.sendKeys(laptopQuantity);
		driver.findElement(By.id("LaptopCheck")).click();
		
		WebElement mobQty = driver.findElement(By.id("MobileQuantity"));
		mobQty.sendKeys(mobileQuantity);
		driver.findElement(By.id("MobileCheck")).click();
		
		WebElement tvQty = driver.findElement(By.id("TelevisionQuantity"));
		tvQty.sendKeys(televisionQuantity);
		driver.findElement(By.id("TelevisionCheck")).click();
		
		WebElement fridgeQty = driver.findElement(By.id("RefrigeratorQuantity"));
		fridgeQty.sendKeys(refrigeratorQuantity);
		driver.findElement(By.id("RefrigeratorCheck")).click();
	}
	
	public void enablePurchasedProduct() {
		// Click the "show" radio button
		driver.findElement(By.id("show")).click();
	}
	
	public String getComputerQuantity() {
		// Wait and get Computer quantity from the table
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement compQty = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='itemtable']/tbody/tr[2]/td[5]/input")));
		return compQty.getAttribute("value");
	}
	
	public String getLaptopQuantity() {
		// Get Laptop quantity
		WebElement lapQty = driver.findElement(By.xpath("//table[@id='itemtable']/tbody/tr[3]/td[5]/input"));
		return lapQty.getAttribute("value");
	}
	
	public String getMobileQuantity() {
		// Get Mobile quantity
		WebElement mobQty = driver.findElement(By.xpath("//table[@id='itemtable']/tbody/tr[4]/td[5]/input"));
		return mobQty.getAttribute("value");
	}
	
	public String getTelevisionQuantity() {
		// Get Television quantity
		WebElement tvQty = driver.findElement(By.xpath("//table[@id='itemtable']/tbody/tr[5]/td[5]/input"));
		return tvQty.getAttribute("value");
	}
	
	public String getRefrigeratorQuantity() {
		// Get Refrigerator quantity
		WebElement fridgeQty = driver.findElement(By.xpath("//table[@id='itemtable']/tbody/tr[6]/td[5]/input"));
		return fridgeQty.getAttribute("value");
	}
	
	public void disablePurchasedProduct() {
		// Click the "hide" radio button
		driver.findElement(By.id("hide")).click();
	}
	
	public String getTotalPrice() {
		// Get total price from the result paragraph
		WebElement totalPrice = driver.findElement(By.id("result"));
		return totalPrice.getText();
	}

	public static void main(String[] args) {
		PurchaseApp obj1 = new PurchaseApp();
		WebDriver driver = obj1.createDriver();
		String res = obj1.chooseItemPreQuantity();
		System.out.println("Error message: " + res);
		
		obj1.chooseItemPostQuantity("2", "7", "10", "4", "3");
		obj1.enablePurchasedProduct();
		
		System.out.println("Computer Qty: " + obj1.getComputerQuantity());
		System.out.println("Laptop Qty: " + obj1.getLaptopQuantity());
		System.out.println("Mobile Qty: " + obj1.getMobileQuantity());
		System.out.println("Television Qty: " + obj1.getTelevisionQuantity());
		System.out.println("Refrigerator Qty: " + obj1.getRefrigeratorQuantity());
		
		obj1.disablePurchasedProduct();
		System.out.println("Total Price: " + obj1.getTotalPrice());
	}
}
