package com.selenium.tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.XMLUtils;
import com.selenium.pages.ContactPageValues;

//@Listeners(FeatureTest.class)  //Do not change or remove this line.
public class TestContactPage extends DriverSetup {

    public static WebDriver driver;
    public static ContactPageValues addressObj;
    private static String validResult;
    
    private String baseUrl = "https://webapps.tekstac.com/AddressBook/";

    public static String getValidResult() {
		return validResult;
	}

	public static void setValidResult(String validResult) {
		TestContactPage.validResult = validResult;
	}	

    // Apply the required annotation
	@BeforeClass
    public WebDriver setUp() {
        //create the driver using method 'getDriver' in class DriverSetup.
		//Assign it to the variable 'driver' and navigate to the baseUrl
		driver = DriverSetup.getDriver();
	    driver.get(baseUrl);
		//DO NO CHANGE THE BELOW OBJECT CREATION LINE
        addressObj = new ContactPageValues(driver);
        return driver;
    }

	public static String[] getXMLData(String fileName) throws Exception {        
	    
	    //Call the method 'readFile' in class 'XMLUtils' using file name 'address.xml'
	    //return the array
		String xmlValidData[] = XMLUtils.readFile(fileName);
		return xmlValidData;

		//return null;
	}
	

    //Apply the required annotation
	@Test
	public void testValidSubmittedDetails() throws Exception{	
		
    	    //Call the method 'getXMLData()' to read the XML file. 
			String[] xmlValidData = getXMLData("address.xml");
    		//Using 'addressObj' object, call the method 'setNickName' and pass the 'NickName' value read from XML data 
        	//Using 'addressObj' object, call the method 'setContactName' and pass the 'ContactName' value read from XML data
        	//Using 'addressObj' object, call the method 'setCompany' and pass the 'Company' value read from XML data
        	//Using 'addressObj' object, call the method 'setCity' and pass the 'City' value read from XML data
        	//Using 'addressObj' object, call the method 'setCountry' and pass the value 'Country' read from XML data       	
        	//Using 'addressObj' object, call the method 'setType' and pass the 'Type' value read from XML data 
			addressObj.setNickName(xmlValidData[0]);
			addressObj.setContactName(xmlValidData[1]);
			addressObj.setCompany(xmlValidData[2]);
			addressObj.setCity(xmlValidData[3]);
			addressObj.setCountry(xmlValidData[4]);
			addressObj.setType(xmlValidData[5]);

        	// Using 'addressObj' object, submit the form using clickAddButton() method.
		    //addressObj.clickAddButton();

    	    // Using 'addressObj' object, invoke the 'getContactName' method to get the contact name as a result
    	    // Store it in the static variable 'validResult' and set the result.
		    addressObj.clickAddButton();
			validResult = addressObj.getContactName();
			System.out.println("$$$$$$$ " + validResult);
			setValidResult(validResult);

           
    }	 	  	  		 	     	     	      	 	
    
    //Apply the required annotation
	@AfterClass
	public void closeBrowser() {
	    
		//close the driver
		driver.quit();
	}
}
