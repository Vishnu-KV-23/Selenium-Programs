import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class CustomerRegistration {
 
	private static WebDriver driver;
	private static String baseUrl = "https://webapps.tekstac.com/CustomerRegistration/";
 
	public CustomerRegistration(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 
	public static WebDriver createDriver() {    // DO NOT CHANGE THE METHOD SIGNATURE
 
		// Invoke the getWebDriver() method from the DriverSetup File
		// Store it in static variable 'driver', navigate and return it
 
		driver = DriverSetup.getDriver();
		// Please do NOT remove the below URL navigation code
		driver.get(baseUrl);
 
		return driver;
	}
    
    @FindBy(xpath="/html/body/form/table/tbody/tr[1]/td[2]/input")
	public WebElement name;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td[2]/input")
	public WebElement age;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[3]/td[2]/input")
	public WebElement address;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[4]/td[2]/input")
	public WebElement phoneNumber;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[5]/td[2]/input")
	public WebElement email;
	
	@FindBy(id="submit")
	public WebElement submit;
	
	
	@FindBy(xpath="/html/body/table/tbody/tr[1]/td[2]")
	public WebElement customerName;
	
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td[2]")
	public WebElement customerAge;
	
	@FindBy(xpath="/html/body/table/tbody/tr[3]/td[2]")
	public WebElement customerAddress;
	
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[2]")
	public WebElement customerPhoneNumber;
	
	@FindBy(xpath="/html/body/table/tbody/tr[5]/td[2]")
	public WebElement customerEmail;
 
	public void setCustomerName(String cname) {
		// Locate the WebElement corresponding to 'Customer Name' using specific locators.                                                    
        // Using sendKeys() method, fill WebElement 'Customer Name' with 'cname'
        // driver.findElement(By.name("cname")).sendKeys(cname);
        name.sendKeys(cname);
	}
 
	public void setCustomerAge(String cage) {
		// Locate the WebElement corresponding to 'Age' using specific locators.                                                    
        // Using sendKeys() method, fill WebElement 'Age' with 'cage'
        // driver.findElement(By.name("age")).sendKeys(cage);
        age.sendKeys(cage);
	}
 
	public void setCustomerAddress(String caddress) {
		// Locate the WebElement corresponding to 'Address' using specific locators.                                                    
        // Using sendKeys() method, fill WebElement 'Address' with 'caddress'
        // driver.findElement(By.name("address")).sendKeys(caddress);
        address.sendKeys(caddress);
	}
 
	public void setCustomerPhoneNumber(String cphone) {
		// Locate the WebElement corresponding to 'Phone Number' using specific locators.                                                    
        // Using sendKeys() method, fill WebElement 'Phone Number' with 'cphone'
        // driver.findElement(By.name("phonenumber")).sendKeys(cphone);
        phoneNumber.sendKeys(cphone);
	}
 
	public void setCustomerEmail(String cemail) {
		// Locate the WebElement corresponding to 'Email' using specific locators.                                                    
        // Using sendKeys() method, fill WebElement 'Email' with 'cemail'
        // driver.findElement(By.name("email")).sendKeys(cemail);
        email.sendKeys(cemail);
	}
	
	public void setSubmitForm() {
		// Locate the Web Element corresponding to the 'SUBMIT' (Button) using specific locators.
        // Click the 'SUBMIT' button
        submit.click();
	}
 
	public String getCustomerName() {
	    // Locate the WebElement displaying in the table 'Name' after form submit and return it using getText method
		return customerName.getText();
	}
 
	public String getCustomerAge() {
	    // Locate the WebElement displaying in the table 'Age' after form submit and return it using getText method
		return customerAge.getText();
	}
 
	public String getCustomerAddress() {
	    // Locate the WebElement displaying in the table 'Address' after form submit and return it using getText method
		return customerAddress.getText();
	}
 
	public String getCustomerPhoneNumber() {
	    // Locate the WebElement displaying in the table 'Phone Number' after form submit and return it using getText method
		return customerPhoneNumber.getText();
	}
 
	public String getCustomerEmail() {
	    // Locate the WebElement displaying in the table 'Email' after form submit and return it using getText method
		return customerEmail.getText();
	}
 
	public static void main(String[] args) {    // DO NOT CHANGE THE METHOD SIGNATURE
	
	    createDriver();
 
		CustomerRegistration register = new CustomerRegistration(driver);
 
		register.setCustomerName("Nancy");
		register.setCustomerAge("23");
		register.setCustomerAddress("Los Angeles");
		register.setCustomerPhoneNumber("9874553423");
		register.setCustomerEmail("nancy@gmail.com");
		register.setSubmitForm();
		String result=register.getCustomerName();
 
		System.out.println("The Customer name is "+result);
	}
 
}