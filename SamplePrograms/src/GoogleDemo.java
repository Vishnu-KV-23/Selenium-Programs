
//Hhehee worked one
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //interface
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; //class -> implements interface
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class GoogleDemo {
	
	public static WebDriver driver;  //declaring the webdriver
	public static String browser = "CHROME";
	
	//USER defined method
	public static void invokeBrowser(String browser)
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// script to invoke/open browser - chrome
		//System.setProperty("webdriver.chrome.driver", "D:/Automation/CTS-2025/tekstac-plugins/drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");
	    //driver = new ChromeDriver();//open the chrome browser
		//invoke firefox browser
		//System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		
		//in linux/mac System.setProperty("webdriver.gecko.driver", "/driver/geckodriver");
		//driver = new FirefoxDriver();
	   // driver = new EdgeDriver();
		invokeBrowser("edge");//calling this method
		driver.manage().window().maximize();//maximise the window size	    
	   
	    //entering the url on the address bar of the browser
	    driver.get("http://webapps.tekstac.com/Shopify/");
	    driver.navigate().to("https://www.amazon.in/");
	    Thread.sleep(2000);//sleep for 2 secs
	    driver.navigate().back();
	    //To identify the register button
	    WebElement registerBtn= driver.findElement(By.id("reg"));
	    String btnName = registerBtn.getText();
	    System.out.println("Name of the registration button is: "+btnName);
	    
	    //close the browser
	    Thread.sleep(2000);//sleep for 2 secs
	    driver.quit();//close the browser
 
	}
 
}