import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
 
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
 
import junit.framework.Assert;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
 
 
public class DataPro {
    
    //DO NOT CHANGE THE BELOW OBJECT CREATION
    static WebDriver driver;
    
    public static Document doc;
	public static String[][] xmlData = new String[1][5];
	public static WebElement element;
    
	public static String commodityText;   // Store the No.of.commodity in this variable
	public static String totalWeightText; // Store the total weight in this variable
	String baseUrl = "https://webapps.tekstac.com/CommodityDetails/";
 
	//Apply the required annotation
	@BeforeTest
	public WebDriver createDriver()	{
		// Invoke the getWebDriver() method from the DriverSetup File
	    // Store it in static variable 'driver', navigate and return it
	    driver = DriverSetup.getWebDriver();
	    
	    // Please do NOT remove the below URL navigation code
	    driver.get(baseUrl);
		
		// return driver
		return driver;
	}
	
	@DataProvider(name="getData")
	public static Object[][] commodityData() throws Exception {
	    
	    DataPro obj = new DataPro();	
	    xmlData = obj.readXMLFile("Commodity_Valid.xml");
	    return xmlData;
	}
	
    //Add required Annotation
    @Test(dataProvider="getData",priority=0)
	void testCommodity (String name, String weight, String length, String width, String height) throws InterruptedException {
		
		//Method to locate all the input boxes 'name', 'weight', 'length', 'width' & 'height' by id / name
		
		//Pass the form data parsed from excel sheet and submit form
		
		
		System.out.println("**********Name************"+name);
		System.out.println("**********Weight************"+weight);
		System.out.println("**********Length************"+length);
		System.out.println("**********Width************"+width);
		System.out.println("**********Height************"+height);
		
		element = driver.findElement(By.id("name"));
		element.sendKeys(name);
		
		element = driver.findElement(By.id("weight"));
		element.sendKeys(weight);
	
		element = driver.findElement(By.name("length"));
		element.sendKeys(length);
		
		element = driver.findElement(By.name("width"));
		element.sendKeys(width);
	
		element = driver.findElement(By.id("height"));
		element.sendKeys(height);
	
		element = driver.findElement(By.name("add"));
		element.click();
	}
	
	
	//Add required Annotation
	@Test(priority=1)
	public void printData() {                    
		
		// Method to locate the textboxes 'No. of Commodity' and 'Total Weight' by id / name
		// Extract result values from them & print in console output
		
		// Store the No.of.commodity value retrived in a static variable 'commodityText'
		// Store the Total Weight value retrived in a static variable 'totalWeightText'
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("total")));
		
		element = driver.findElement(By.id("count"));
		commodityText = element.getAttribute("value");
		
		
		element = driver.findElement(By.name("total"));
		
		totalWeightText = element.getAttribute("value");
		
		System.out.println("Total No of Commodity : " + commodityText);
		System.out.println("Total Weight : " + totalWeightText);
		
	}
 
	//user defined method
    public String[][] readXMLFile(String fileName) throws Exception { // Do not change the method signature
	
		try   
        {	 	  	  		 	     	     	      	 	
            
            //creating a constructor of file class and parsing an XML file  
            File file = new File(fileName);  
            //an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
            //an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();  
            Document doc = db.parse(file);  
            doc.getDocumentElement().normalize();  
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
            NodeList nodeList = doc.getElementsByTagName("Commodity");  
            // nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++)   
            {
                
                Node node = nodeList.item(itr);  
                System.out.println("\nNode Name :" + node.getNodeName());  
                if (node.getNodeType() == Node.ELEMENT_NODE)   
                {  
                        Element eElement = (Element) node;  
                        
                        xmlData[0][0] = eElement.getElementsByTagName("Name").item(0).getTextContent();
                        xmlData[0][1] = eElement.getElementsByTagName("Weight").item(0).getTextContent();
                        xmlData[0][2] = eElement.getElementsByTagName("Length").item(0).getTextContent();
                        xmlData[0][3] = eElement.getElementsByTagName("Width").item(0).getTextContent();
                        xmlData[0][4] = eElement.getElementsByTagName("Height").item(0).getTextContent();
                        
                }  
            }  
        }   
        catch (Exception e)   
        {	 	  	  		 	     	     	      	 	
            e.printStackTrace();  
        }  
        
        return xmlData;
        
	}
	
	
   
	//Apply the required annotation
	@AfterTest
	public void closeBrowser(){
		//close the driver
		driver.close();
		
	}
}