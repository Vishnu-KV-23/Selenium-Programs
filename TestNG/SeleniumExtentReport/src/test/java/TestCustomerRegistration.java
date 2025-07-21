import java.io.File;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;


public class TestCustomerRegistration extends DriverSetup{

    public static WebDriver driver;
    public static String baseUrl = "https://webapps.tekstac.com/CustomerRegistration_4284/";
    private static CustomerRegistrationPage customer;
    private static String resultTxt;

    public static String getResultTxt() {
		return resultTxt;
	}

	public static void setResultTxt(String resultTxt) {
		TestCustomerRegistration.resultTxt = resultTxt;
	}

    @BeforeClass
    public WebDriver setUp() {
        driver = DriverSetup.getDriver();
        driver.get(baseUrl);
        customer = new CustomerRegistrationPage(driver);
		return driver;
    }

    @DataProvider(name = "testNGData")
    public Object[][] testNGData() {
        return new Object[][] { { "Jeny Doe", "8544338974", "20-07-1998", "Female", "London" } };
    }

    @Test(dataProvider = "testNGData")
    public void enterData(String name, String mobileNo, String dob, String gender, String address) throws InterruptedException {
        customer.setName(name);
        customer.setMobileNumber(mobileNo);
        customer.setDOB(dob);
        customer.setGender(gender);
        customer.setAddress(address);
        customer.clickSubmitButton();
    }

    @Test(dependsOnMethods = {"enterData"})
    public void formValidationTest() {
        setResultTxt(customer.getResult());
    }

    //Do not Modify This code.
    public static void main(String[] args) {
        try {
            TestNG testng = new TestNG();
            List<String> suites = Lists.newArrayList();
            suites.add("testng.xml");
            testng.setTestSuites(suites);
            testng.run();

            String reportPath = System.getProperty("user.dir") + File.separator + "extentReport.html";
            File reportFile = new File(reportPath);

            if (!reportFile.exists()) {
                System.out.println("Extent Report HTML file not found!");
                return;
            }

            Document doc = Jsoup.parse(reportFile, "UTF-8");
            String content = doc.html();

            System.out.println("=== Extent Report HTML Content ===");
            System.out.println(content);
            System.out.println("\n\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}