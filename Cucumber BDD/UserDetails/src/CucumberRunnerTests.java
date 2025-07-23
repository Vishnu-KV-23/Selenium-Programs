/** DO NOT CHANGE THIS CLASS. THIS CLASS IS FOR REFERENCE ONLY  **/


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(dryRun = false, plugin = {"pretty","junit:target/cucumber-reports/Cucumber.xml"})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    
}