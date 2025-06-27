import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptExecutor{ //Do not change the class name

    //Use the below declarations
    public static WebDriver driver;
    public static Object jsname,jshod, jsphone, jsemaiId, jscount, jsstatus,jsadd;
    String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_dept.html";

    public WebDriver createDriver() { // DO NOT CHANGE THE METHOD SIGNATURE
        // Invoke the getWebDriver() method from the DriverSetup File
        // Store it in static variable 'driver', navigate and return it
        driver = DriverSetup.getWebDriver();

        // Please do NOT remove the below URL navigation code
        driver.get(baseUrl);

        return driver;
    }

    public void submitForm(String name,String hod, String phone, String email, int count,String status) { // DO NOT CHANGE THE METHOD SIGNATURE
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Using javascript executor, locate the elements of 'name','hod','phone','email'
        //'count','status' and send the received values.
        //Submit the form
        jse.executeScript("document.getElementById('deptName').value = '" + name + "';");
        jse.executeScript("document.getElementById('deptHead').value = '" + hod + "';");
        jse.executeScript("document.getElementById('phoneNo').value = '" + phone + "';");
        jse.executeScript("document.getElementById('emaiId').value = '" + email + "';");
        jse.executeScript("document.getElementById('studentCount').value = '" + count + "';");
        jse.executeScript("document.getElementById('status').value = '" + status + "';");
        jse.executeScript("document.getElementById('addDept-now').click();");
    }

    public String getMessage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Using javascript executor, locate the name displayed and return it
        String rowText = (String) jse.executeScript(
            "return document.querySelector('#deptTable tbody tr:last-child').innerText;");
        return rowText;
    }

    public static void main(String[] args) {
        // FIXED: Use your class name JavaScriptExecutor (capital S), not JavascriptExecutor (lowercase s)
        JavaScriptExecutor at = new JavaScriptExecutor();
        at.createDriver();
        //Use this values to submit the form
        at.submitForm("Mechanical","Dr. Alex","9876543210","alex@rockyuniv.edu",85,"Active");
        String name = at.getMessage();
        System.out.println("Department Added: "+ name);
    }
}