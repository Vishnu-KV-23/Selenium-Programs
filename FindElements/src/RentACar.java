import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class RentACar { // DO NOT CHANGE THE CLASS NAME
    static WebDriver driver;
    String baseUrl = "https://webapps.tekstac.com/RentaCar/";
    static int textBoxCount, checkBoxCount;
    static List<WebElement> textBoxList, checkBoxList;
    static By textBoxXpath, checkBoxXpath;

    public WebDriver createDriver() {
        driver = DriverSetup.getDriver();
        driver.get(baseUrl);
        return driver;
    }

    public List<WebElement> getTextBoxCount() {
        // DO NOT CHANGE THE METHOD SIGNATURE
        textBoxXpath = By.xpath("//input[@type='text']");
        textBoxList = driver.findElements(textBoxXpath);
        return textBoxList;
    }

    public List<WebElement> getCheckBoxCount() {
        // DO NOT CHANGE THE METHOD SIGNATURE
        checkBoxXpath = By.xpath("//input[@type='checkbox']");
        checkBoxList = driver.findElements(checkBoxXpath);
        return checkBoxList;
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        RentACar printOptions = new RentACar();
        printOptions.createDriver();
        printOptions.getTextBoxCount();
        printOptions.getCheckBoxCount();
        printOptions.closeBrowser();
    }
}
