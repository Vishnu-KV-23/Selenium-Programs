/** DO NOT CHANGE THIS CLASS. THIS CLASS IS FOR REFERENCE ONLY  **/

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;


public class Invoke {   // DO NOT change the class name
	
	public void checkAgent() {            // DO NOT change the method signature
	    //Invoke the test using TestNG ONLY HERE.
    	try {
    		TestNG testng = new TestNG();
    		List<String> suites = Lists.newArrayList();
    		String workingDir = System.getProperty("user.dir");
    		System.out.println("user.dir "+ workingDir);
    		suites.add(workingDir + "/testng.xml");
    		
    		testng.setTestSuites(suites);
    		testng.run();
		} catch (Exception e) {	 	  	  		 	     	     	      	 	
			//e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	    Invoke iv=new Invoke();
	    iv.checkAgent();
	}
}
	
	
	



