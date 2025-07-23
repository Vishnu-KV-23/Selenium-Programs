package Test_Scenario_GET;

import java.util.ArrayList;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import Test_Scenario_GET.*;


public class RunWithJunitCore {
	public static void main(String[] args) {
	    try{
	   Result result = JUnitCore.runClasses(Get_Request.class);
	       	  // Print the total number of test cases run
        System.out.println("Test Case Count : " + result.getRunCount());
        // Print the number of test cases that failed
        System.out.println("Failure Count : " + result.getFailureCount());
        // If there are any failures, print additional information
        if (result.getFailureCount() > 0) {
          //  System.out.println("There are test failures. Please check the following:");
            for (Failure failure : result.getFailures()) {
                System.out.println("Test failure: \n" + failure.toString());
            }
           System.out.println("Hint: Check @Test annotation or check logic.");
        } else {
            System.out.println("Test Case is passed successfully!");
        }
		
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}
}