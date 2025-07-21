package mypack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Invoke {
	
	public static void main(String[] args) {
		String firstname = "Johnson";
		String lastname = "Charles";
		String username = "john";
		String city = "Chennai";
		String gender = "Male";
		String password = "Password@12345";
		 
		
		
		try {
			//Create driver Object
			//create SetCustomerDetails passing driver as parameter
			//Invoke all the setter methods and then submit the form
			WebDriver driver = DriverSetup.getDriver();
            SetCustomerDetails setDetails = new SetCustomerDetails(driver);

            setDetails.setFirstName(firstname);
            setDetails.setLastname(lastname);
            setDetails.setUsername(username);
            setDetails.setCity(city);
            setDetails.setGender(gender);
            setDetails.setPassword(password);
            setDetails.setRegisterBtn();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}