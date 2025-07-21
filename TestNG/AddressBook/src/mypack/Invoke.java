package mypack;
 
import java.io.IOException;
 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class Invoke {
	
	//Use the below declared variables
	public static WebDriver driver;
	public static RespositoryParser parser;
	//public static String nicknameText,contactText,companyText,cityText,countryText,typeText;
	
	public static void main(String[] args) throws Exception {
		Invoke invoke = new Invoke();
		invoke.setUpDriver();
		driver.get("https://webapps.tekstac.com/AddressBook/");
		System.out.println("Selenium started");
		String[][] excelValues = ExcelUtils.readExcelData("./contacts.xlsx", "contacts_valid");
		invoke.setNickName(excelValues[0][0]);
		invoke.setContactName(excelValues[0][1]);
		invoke.setCompany(excelValues[0][2]);
		invoke.setCity(excelValues[0][3]);
		invoke.setCountry(excelValues[0][4]);
		invoke.setType(excelValues[0][5]);
		invoke.clickAddButton();
// 		nicknameText = invoke.getNickName();
// 		contactText = invoke.getContactName();
// 		companyText = invoke.getCompany();
// 		cityText = invoke.getCity();
// 		countryText = invoke.getCountry();
// 		typeText = invoke.getType();
		invoke.closeBrowser();
	}
	
	public void setUpDriver() throws Exception{ // Do not change the method signature
		driver = new DriverSetup().getDriver();
		parser = new RespositoryParser("ObjectRepo.properties");
	}	 	  	    	 	    	     	 	
	
	public String getNickName() {// Do not change the method signature
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[1]")).getText();
	}
	
	public String getContactName() {// Do not change the method signature
	    //return null;
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[2]")).getText();
	}
	
	public String getCompany() {// Do not change the method signature
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[3]")).getText();
	
//	return null;
	}
	
	public String getCity() {// Do not change the method signature
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[4]")).getText();
	
	   // return null;
	}
	
	public String getCountry() {// Do not change the method signature
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[5]")).getText();
	
//	return null;
	    
	}
	
	public String getType() {// Do not change the method signature
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table/tbody/tr[2]/td[6]")).getText();
	}
	
	
	public void setNickName(String nickName) {
		WebElement nickNameElement = driver.findElement(By.xpath(parser.getObjectLocator("nickname")));
		nickNameElement.sendKeys(nickName);
	}
	
	public void setContactName(String contact) {
		WebElement contactNameElement = driver.findElement(By.xpath(parser.getObjectLocator("contact")));
		contactNameElement.sendKeys(contact);
	}	 	  	    	 	    	     	 	
	
	public void setCompany(String company) {
	    System.out.println("driver " + driver+" "+parser);
		WebElement companyElement = driver.findElement(By.xpath(parser.getObjectLocator("company")));
		companyElement.sendKeys(company);
	}
	
	public void setCity(String city) {
		WebElement cityElement = driver.findElement(By.xpath(parser.getObjectLocator("city")));
		cityElement.sendKeys(city);
	}
	
	public void setCountry(String country) {
		WebElement countryElement = driver.findElement(By.xpath(parser.getObjectLocator("country")));
		countryElement.sendKeys(country);
	}
	
	public void setType(String type) {
		WebElement typeElement = driver.findElement(By.xpath(parser.getObjectLocator("type")));
		typeElement.sendKeys(type);
	}
	
	public void clickAddButton() {
		driver.findElement(By.xpath(parser.getObjectLocator("add"))).click();
	}
	
	public void closeBrowser() {// Do not change the method signature
		driver.close();
	}
 
}