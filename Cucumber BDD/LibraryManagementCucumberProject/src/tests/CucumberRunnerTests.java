/** DO NOT CHANGE THIS CLASS. THIS CLASS IS FOR REFERENCE ONLY  **/

package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
    features = "src/features",
    glue = "definitions",
    plugin = {"pretty", "junit:target/cucumber-reports/Cucumber.xml"}
)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    
}