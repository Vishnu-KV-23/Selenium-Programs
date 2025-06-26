import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Navigation { // DO NOT CHNAGE THE CLASS NAME 
    
    // Use the below declared cariables 
	static String page1, page2,page3,page4,page5,baseUrl;
	static WebDriver driver;
	
	public WebDriver setupDriver() {    // DO NOT CHANGE THE METHOD SIGNATURE
	    // Invoke the getWebDriver() method from the DriverSetup File 
	    // Store it in static variable 'driver' and return it
	    driver = DriverSetup.getWebDriver();
	    return driver;
	}
	
	public void navigate1() {   // DO NOT CHANGE THE METHOD SIGNATURE
	    /*Replace this comment by the code statement to navigate to baseUrl 'https://selenium.dev/' */
		
		
		baseUrl="https://selenium.dev/";
		driver.navigate().to("https://selenium.dev/");
	    
	}
	
	public void getPageTitle1()	{   // DO NOT CHANGE THE METHOD SIGNATURE
	    /*Replace this comment by the code statement to get page title of  "https://selenium.dev/"*/
	    /* Assign the page title to static variable 'page1' */
	    page1=driver.getTitle();
	}
	
	public void navigate2()	{   // DO NOT CHANGE THE METHOD SIGNATURE
	    /*Replace this comment by the code statement to navigate to https://www.google.co.in/ */
		
		driver.navigate().to("https://www.google.co.in/");
		
		
        
	}
	
	public void getPageTitle2() {   // DO NOT CHANGE THE METHOD SIGNATURE
	    /*Replace this comment by the code statement to get page title of  https://www.google.co.in/ */
	    /* Assign the page title to static variable 'page2' */
		page2= driver.getTitle();
        
	}
	
	public void navigateBack() {    // DO NOT CHANGE THE METHOD SIGNATURE
	    /*Replace this comment by the code statement to navigate back */
		
		driver.navigate().back();
       
	}
	
	public void getPageTitle3() {   // DO NOT CHANGE THE METHOD SIGNATURE
	    /*Replace this comment by the code statement to get page title of backed page */
	    /* Assign the page title to static variable 'page3' */
		
		page3=driver.getTitle();
		
		
        
	}
	
	public void navigateForward() { // DO NOT CHANGE THE METHOD SIGNATURE
	    /*Replace this comment by the code statement to navigate forward */
		
		driver.navigate().forward();
		
        
	}
	
	public void getPageTitle4() {   // DO NOT CHANGE THE METHOD SIGNATURE
	    /*Replace this comment by the code statement to get page title of the forwarded page */
	    /* Assign the page title to static variable 'page4' */
		
		
		page4=driver.getTitle();
        
	}
	
	public void refreshPage() { // DO NOT CHANGE THE METHOD SIGNATURE
	    /*Replace this comment by the code statement to refresh the page */
		
		driver.navigate().refresh();
       
	}
	
	public void getPageTitle5() {   // DO NOT CHANGE THE METHOD SIGNATURE
	    /*Replace this comment by the code statement to get page title of refreshed page */
	    /* Assign the page title to static variable 'page5' */
		
		page5=driver.getTitle();
		
        
	}

	
	public static void main(String[] args) {    // DO NOT CHANGE THE METHOD SIGNATURE
	    Navigation nav=new Navigation();
	    nav.setupDriver();
	    nav.navigate1();
	    nav.getPageTitle1();
	    nav.navigate2();
	    nav.getPageTitle2();
	    nav.navigateBack();
	    nav.getPageTitle3();
	    nav.navigateForward();
	    nav.getPageTitle4();
	    nav.refreshPage();
	    nav.getPageTitle5();
	}

}

