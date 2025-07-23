
/** DO NOT CHANGE THIS CLASS. THIS CLASS IS FOR REFERENCE ONLY  **/

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(dryRun = false, plugin = { "pretty", "junit:target/cucumber-reports/Cucumber.xml" })
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

    // Accept e-mail and password from TestNG, make them globally visible
    @BeforeClass
    @Parameters({ "email", "password" })
    public void setParameters(String email, String password) {
        System.setProperty("email", email);
        System.setProperty("password", password);
    }
}
