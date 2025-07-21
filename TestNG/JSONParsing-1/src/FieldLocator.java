import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FieldLocator //DO NOT Change the class Name
{
	//use the below declared variables
	public static WebDriver driver;
	public static Object obj;
	public static JSONObject jo;
	public static JSONArray address;
	String baseUrl = "http://webapps.tekstac.com/AddressBook/";
	
	public WebDriver createDriver() { //DO NOT change the method signature
	
	   // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate and return it
	    
		driver = DriverSetup.getWebDriver();
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		
		return driver;
	}
	
	public JSONArray ReadFile(String fileName) {   //DO NOT change the method signature
    
        //Implement code to read and return addresses as JSON array 
		try {
            JSONParser parser = new JSONParser();
            obj = parser.parse(new FileReader(fileName));
            jo = (JSONObject) obj;
            address = (JSONArray) jo.get("Addresses"); // Get the "Addresses" array
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
		//return null;
    }
    
    public String getNickName(int id) {
	
        //Implement code to return nickname from address
    	JSONObject entry = (JSONObject) address.get(id);
        return entry.get("NickName").toString();
    	//return null;
    }

	public String getContactName(int id) {
		//Implement code to return contactname from address
		JSONObject entry = (JSONObject) address.get(id);
        return entry.get("ContactName").toString();
		//return null;
	}

	public String getCity(int id) {
		//Implement code to return city from address
		JSONObject entry = (JSONObject) address.get(id);
        return entry.get("City").toString();
		//return null;
	}

	public String getType(int id) {
		//Implement code to return type from address
		JSONObject entry = (JSONObject) address.get(id);
        return entry.get("Type").toString();
		//return  null;
	}

	public String getMessage() {
		//Implement code to submit form with values got from json and return the success message printed on the page.
		driver.findElement(By.id("nickname")).sendKeys(getNickName(0));
        driver.findElement(By.id("contact")).sendKeys(getContactName(0));
        driver.findElement(By.id("city")).sendKeys(getCity(0));
        driver.findElement(By.id("type")).sendKeys(getType(0));
        driver.findElement(By.id("submit")).click();
        return driver.findElement(By.id("res")).getText();
		//return null;
	}

	public static void main(String[] args) {
		FieldLocator fieldLocator=new FieldLocator();
	    //Implement the required code
	    //Close the driver
		fieldLocator.createDriver();
		fieldLocator.ReadFile("AddressBook.json");
		String msg = fieldLocator.getMessage();
        System.out.println("Form Submission Message: " + msg);
        driver.quit();
	}

}

