import org.openqa.selenium.WebDriver;

public class VerifyPageTitle {      // DO NOT CHANGE THE CLASS NAME

	// Use the below declared variables 
	public static WebDriver driver;  	    
	static String pageTitle;
	static String baseUrl = "https://webapps.tekstac.com/RentaCar/";
	
     public static WebDriver createDriver() {    // DO NOT CHANGE THE METHOD SIGNATURE 
	    
	    // Invoke the getDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver', navigate to basrUrl and return it
    	 //public static   WebDriver driver ;
    	 
    	 driver=DriverSetup.getDriver();
    	 
    	 driver.navigate().to(baseUrl);
    	 
	    return driver;
	}

	public static String getPageTitle() {    // DO NOT CHANGE THE METHOD SIGNATURE

		// identify and page title and Store into the static variable and return it
		pageTitle=driver.getTitle();
		return pageTitle;
	}

	public static void main(String[] args) {    // DO NOT CHANGE THE METHOD SIGNATURE

		createDriver();
		getPageTitle();

		System.out.println("Page title is: " + pageTitle);


	}	 	  	      	 		     	     	        	 	

}

