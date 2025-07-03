import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;

public class Slider {  //DO NOT Change the class Name

    // Use the below declared variables
    public static WebDriver driver;
    public static String productInfo;
    public static String quantityInfo;
    public static String priceInfo;
    String baseUrl = "http://webapps.tekstac.com/OnlineShopping/fashion.html";

    public WebDriver createDriver() {    //DO NOT change the method signature

        // Invoke the getWebDriver() method from the DriverSetup File 
        // Store it in static variable 'driver', navigate and return it
        driver = DriverSetup.getWebDriver();
        driver.get(baseUrl); // Do NOT remove this line
        return driver;
    }

    public void implDragnDrop() {   //DO NOT change the method signature

        // Locate source (e.g., Shirts) and target (basket) elements
        WebElement source = driver.findElement(By.id("draggable1"));
        WebElement target = driver.findElement(By.id("droppable"));

        // Perform drag-and-drop using Actions class
        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).build().perform();
    }

    public void implMoveSlider() {   //DO NOT change the method signature

        Actions action = new Actions(driver);

        // Locate the slider element
        WebElement slider = driver.findElement(By.id("myRange"));

        // Move slider to value 5 => xOffset = -60 (from instructions)
        action.dragAndDropBy(slider, -60, 0).build().perform();
    }

    public String getProductDetail() { //DO NOT change the method signature

        WebElement product = driver.findElement(By.id("product"));
        productInfo = product.getText();
        return productInfo;
    }

    public String getQuantityDetail() { //DO NOT change the method signature

        WebElement quantity = driver.findElement(By.id("No"));
        quantityInfo = quantity.getText();
        return quantityInfo;
    }

    public String getPriceDetail() {  //DO NOT change the method signature

        WebElement price = driver.findElement(By.id("price"));
        priceInfo = price.getText();
        return priceInfo;
    }

    public static void main(String[] args) { //DO NOT change the method signature

        Slider ex = new Slider();
        ex.createDriver();
        ex.implDragnDrop();
        ex.implMoveSlider();

        System.out.println("Product: " + ex.getProductDetail());
        System.out.println("Quantity: " + ex.getQuantityDetail());
        System.out.println("Price: " + ex.getPriceDetail());

        driver.quit(); // Close the driver
    }
}
