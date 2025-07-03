import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
 
public class CssSelectors {
	public static WebDriver driver;
	String baseUrl = "https://webapps.tekstac.com/ItemDetails/";
 
	public CssSelectors(WebDriver driver) {
		this.driver = driver;
	}
 
	public CssSelectors() {
	}
 
	public WebDriver setupDriver() { // Do not change the method signature
 
		// Invoke the getWebDriver() method from the DriverSetup File
		// Store it in static variable 'driver' and return it
		driver = DriverSetup.getDriver();
		driver.get(baseUrl);
		return driver;
// 		return null;
	}
 
	public void setItemId(String itemid) {
		driver.findElement(By.cssSelector("input#itemid")).sendKeys(itemid);
	}
 
	public void setItemName(String itemname) {
		driver.findElement(By.cssSelector("input.input-product")).sendKeys(itemname);
	}
 
	public void setItemDescription(String description) {
	    // Locate the WebElement corresponding to 'Item Description' using Attribute Css Selector.
    
    // Using sendKeys method, fill the WebElement  'Item Description' with 'description'
		driver.findElement(By.cssSelector("textarea[id=itemdesc]")).sendKeys(description);
	}	 	  	      	  	      	 	   	    	 	
 
	public void setItemCategory(String category) {
		Select item = new Select(driver.findElement(By.cssSelector("select.menu-product[id=itemtype]")));
		item.selectByVisibleText(category);
	}
	
	public void setItemQuantity(String quantity) {
		driver.findElement(By.id("itemqty")).sendKeys(quantity);
	}
	
	public void setPrice(String price) {
		driver.findElement(By.id("itemprice")).sendKeys(price);
	}
	
	
	public void setSubmit() {
		driver.findElement(By.cssSelector("button:only-of-type")).click();
	}
	
	public WebElement getMessage() {
		WebElement textElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div"));
		String text = textElement.getText();
		System.out.println(text);
		return textElement;
// return null;
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
		WebElement message = reg.getMessage();
System.out.println("Message: " + message.getText());
	}	 	  	      	  	      	 	   	    	 	
}