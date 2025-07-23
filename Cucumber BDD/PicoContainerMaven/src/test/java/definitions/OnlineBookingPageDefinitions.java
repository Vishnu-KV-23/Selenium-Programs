package definitions;  import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;  import io.cucumber.java.en.And; import io.cucumber.java.en.Then; import io.cucumber.java.en.When;
 import setup.ApplicationHooks;
 
 
 public class OnlineBookingPageDefinitions {
     
     public  WebDriver driver;
     public static String verifyName;
     
     public OnlineBookingPageDefinitions(ApplicationHooks hooks) {
         this.driver = hooks.getDriver();
     } 
 
 	@When("the booking form is filled with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
 	public void enterUserDetails(String name, String gender, String age, String address, String email, String mobile, String travelClass, String source, String destination, String date) {
 		driver.findElement(By.id("customername")).sendKeys(name);
 		if(gender.equalsIgnoreCase("Male"))
      		driver.findElement(By.id("type1")).click();
 		else if(gender.equalsIgnoreCase("Female"))
 			driver.findElement(By.id("type2")).click();	
     		driver.findElement(By.id("customerage")).sendKeys(age);
   		driver.findElement(By.id("customeraddress")).sendKeys(address);
   		driver.findElement(By.id("email")).sendKeys(email);
   		driver.findElement(By.id("mobile")).sendKeys(mobile);   		
        driver.findElement(By.id("travelclass")).sendKeys(travelClass);
   		driver.findElement(By.id("source")).sendKeys(source);
   		driver.findElement(By.id("destination")).sendKeys(destination);
   		driver.findElement(By.id("dot")).sendKeys(date);
 	}	 	  	      	 	    	   	 	       	 	
 
 	
 
 	@And("booking form is submitted")
 	public void clickSubmission() {
 		WebElement submit=driver.findElement(By.name("submit"));
 		submit.click();
 	}
 
 	@Then("confirmation table should be visible")
 	public void getConfirmationTable() {
 		By dname=By.xpath("/html/body/center/div/table/tbody/tr[2]/td[1]");
 	      WebElement textship = driver.findElement(dname) ;
          	      verifyName = textship.getText();
    			System.out.println(verifyName);
   }
    	}