package Test_Scenario_GET;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;
import org.json.*;

//DO NOT CHANGE THE CLASS NAME. DO NOT CHANGE THE METHOD SIGNATURE

public class Get_Request {

	public static Response response;
	public static int statusCode;
	public static String contentType;
    public static String roomType;
	public static Response handleRequest()
	{
	    
	// Write the code here
    // Sends a GET request to a specified URL with a query parameter for "roomType" set to "SINGLE"
    // Get the Response,print the response and store it in static variable 'response' and return it.
    // Use Hamcrest Matcher for assertions on status code and content type
	return null;
	}
	

	// Add required annotation
	public void validateResponse()
	{
		
		//Calls the necessary methods to send the GET request
        //Get the status code from the resonse and store it in static variable 'statusCode' 
        //Get the content type from the response and store it in static variable 'contentType' 
	    //Get the room type from the response and store it in static variable 'roomType' 
	   
    

	}

}
