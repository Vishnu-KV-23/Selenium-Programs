import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.*;
import org.openqa.selenium.By;

public class FileExplorer {
	
	public static WebDriver driver; 
	static String baseUrl = "https://webapps.tekstac.com/Users/";
	String[] userDetails = new String[4];
	
	
	public FileExplorer() {}
	public FileExplorer(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebDriver createDriver() {
       //Create driver by calling 'getDriver' method,store it in static variable driver, navigate to baseUrl and return it
		driver = DriverSetup.getDriver();
	    driver.get(baseUrl);
	    return driver;
        //return null;
    }	
	
	public String[] readFile(String fileName) throws Exception {
	    // Reads data from a text file specified by the fileName parameter.
        // Each line of the file is split by ", " and assigned to userDetails array.
        // Prints the data read from the file and returns userDetails array.
		BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line = br.readLine();  // Assuming only 1 line
	    if (line != null) {
	        userDetails = line.split(", ");
	        for (String detail : userDetails) {
	            System.out.println(detail);  // Optional debug print
	        }
	    }
	    br.close();
	    return userDetails;
	}
	
	public void setUserName()
	{
	    // Locate the WebElement corresponding to 'Name' using specific locators.
	    // Using sendKeys method, fill the WebElement 'Name' with userDetails[0].
		WebElement nameField = driver.findElement(By.id("name"));
	    nameField.sendKeys(userDetails[0]);	
	}
	
	public void setAddress()
	{
	    // Locate the WebElement corresponding to 'Address' using specific locators.
	    // Using sendKeys method, fill the WebElement 'Address' with userDetails[1].
		WebElement addressField = driver.findElement(By.id("address"));
	    addressField.sendKeys(userDetails[1]);
	}
	
	public void setMobileNumber()
	{
	    // Locate the WebElement corresponding to 'Mobile Number' using specific locators.
	    // Using sendKeys method, fill the WebElement 'Mobile Number' with userDetails[2].
		WebElement mobileField = driver.findElement(By.id("mobile"));
	    mobileField.sendKeys(userDetails[2]);
	}
	
	public void setEmail()
	{
	    // Locate the WebElement corresponding to 'E-mail Id' using specific locators.
	    // Using sendKeys method, fill the WebElement 'E-mail Id' with userDetails[3].
		WebElement emailField = driver.findElement(By.id("email"));
	    emailField.sendKeys(userDetails[3]);
	}
	
	public void clickSubmit()
	{
	    // Using click method, click on the WebElement 'submit'
		WebElement submitButton = driver.findElement(By.id("submit"));
	    submitButton.click();
	}
	
	public String getResult()
	{
		// Retrieves the result from the webpage and returns it as a string.
		WebElement resultElement = driver.findElement(By.id("result"));
	    return resultElement.getText();
		//return null;
	}
	
	public void writeFile(String fileName) throws Exception
	{
	    // Retrieves the result using the getResult() method and writes it to the text file 'resultData.txt' specified by the fileName parameter.
		String result = getResult();
	    FileWriter writer = new FileWriter(fileName);
	    writer.write(result);
	    writer.close();
	}
	
	public static void main(String[] args) throws Exception {
		FileExplorer fileObj = new FileExplorer();
        fileObj.createDriver();

            fileObj.readFile("userData.txt");
            fileObj.setUserName();
            fileObj.setAddress();
            fileObj.setMobileNumber();
            fileObj.setEmail();
            fileObj.clickSubmit();
                                                
            System.out.println("RESULT "+fileObj.getResult());
            fileObj.writeFile("resultData.txt");
     
    }
	
}
