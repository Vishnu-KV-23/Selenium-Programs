
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelectors {
	public static WebDriver driver;
	String baseUrl = "https://webapps.tekstac.com/ItemDetails/";

	public CssSelectors(WebDriver driver) {
		this.driver = driver;
	}

	public CssSelectors() {
	}

	public WebDriver setupDriver() { // Do not change the method signature

		//Create driver,store it in static variable driver, navigate to baseUrl and return it
        return null;
	}

	public void setItemId(String itemid) {
    // Locate the WebElement corresponding to 'Item Id' using Id Css Selector. 
    
    // Using sendKeys method, fill the WebElement  'Item Id' with 'itemid'
	}

	public void setItemName(String itemname) {
    // Locate the WebElement corresponding to 'Item Name' using Class Css Selector. 
    
    // Using sendKeys method, fill the WebElement  'Item Name' with 'itemname'
	}

	public void setItemDescription(String description) {
    // Locate the WebElement corresponding to 'Item Description' using Attribute Css Selector. 
    
    // Using sendKeys method, fill the WebElement  'Item Description' with 'description'
	}

	public void setItemCategory(String category) {
    // Locate the WebElement corresponding to 'Item Category' using Tag, Class and Attribute Css Selector .
    
    // Using selectByVisibleText, select the drop down box of the 'Item Category' with 'category'
	}
	
	public void setItemQuantity(String quantity) {
    // Locate the WebElement corresponding to 'Item Quantity' using specific locators. 
    
    // Using sendKeys method, fill the WebElement  'Item Quantity' with 'quantity'
	}
	
	public void setPrice(String price) {
    // Locate the WebElement corresponding to 'Price' using specific locators. 
    
    // Using sendKeys method, fill the WebElement  'Price' with 'price'
	}
	
	
	public void setSubmit() {
    // Locate the WebElement corresponding to 'Confirm' using pseudo-class Css Selector .
    
    // Using click method, click on the WebElement 'Submit'.
	}
	
	public WebElement getMessage() {
	    // Retrieve the text from the WebElement
	    // Get the text content of the WebElement
	    // Return the WebElement containing the text
		return null;
	}
	
	public static void main(String[] args) {
		CssSelectors reg = new CssSelectors();
		reg.setupDriver();
		reg.setItemId("32");
		reg.setItemName("Beetroot");
		reg.setItemDescription("Good For Health");
		reg.setItemCategory("Vegetables");
		reg.setItemQuantity("3");
		reg.setPrice("45");
		reg.setSubmit();
		reg.getMessage();
	}
}
