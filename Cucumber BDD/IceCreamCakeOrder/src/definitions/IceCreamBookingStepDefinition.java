package definitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import setup.DriverSetup; // Assuming you have this utility class for driver setup

public class IceCreamBookingStepDefinition {
   
        public WebDriver driver;
      public String baseUrl = "https://webapps.tekstac.com/IceCakes/icecreams.html";
     
   
       @Given("Navigate to IceCream Page")
       public WebDriver navigate_to_ice_cream_page() {
           driver = DriverSetup.getDriver();
           driver.get(baseUrl);
   		return driver;
    }
   
     @Then("Select IceCream Flavors")
     public List<String> select_ice_cream_flavors(DataTable dataTable) {	 	  	      	 	    	   	 	       	 	
         List<List<String>> dataTableList = dataTable.cells();
           List<String> flavors = new ArrayList<>();
        //    System.out.println(flavors);
    
           for (List<String> row : dataTableList) {
                for (String flavor : row) {
                    flavors.add(flavor);
                 //   System.out.println("@@@"+flavor);
                    
               //     driver.get(baseUrl);
                   if(flavor.equals("Kulfi")) {
                  //  WebElement flavorElement = driver.findElement(By.xpath("//h1[contains(text(), '" + flavor + "')]"));
                  //  WebElement flavorElement = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/h1"));
                    WebElement flavorElement = driver.findElement(By.xpath("//h1[contains(text(), 'Kulfi')]"));
                   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", flavorElement);
                    Actions actions = new Actions(driver);
                    actions.doubleClick(flavorElement).perform();
                    }
                    if(flavor.equals("Ice Popsicle")) {
                        //  WebElement flavorElement = driver.findElement(By.xpath("//h1[contains(text(), '" + flavor + "')]"));
                    	WebElement flavorElement = driver.findElement(By.xpath("//h1[contains(text(), 'Ice Popsicle')]"));
                         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", flavorElement);
                          Actions actions = new Actions(driver);
                          actions.doubleClick(flavorElement).perform();
                          }
                    if(flavor.equals("Frozen Yogurt")) {
                        //  WebElement flavorElement = driver.findElement(By.xpath("//h1[contains(text(), '" + flavor + "')]"));
                    	WebElement flavorElement = driver.findElement(By.xpath("//h1[contains(text(), 'Frozen Yogurt')]"));
                         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", flavorElement);
                          Actions actions = new Actions(driver);
                         actions.doubleClick(flavorElement).perform();
                         }
                }
                
            }
            return flavors;
            }	 	  	      	 	    	   	 	       	 	
     }