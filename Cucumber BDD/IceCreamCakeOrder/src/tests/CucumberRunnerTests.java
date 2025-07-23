/** DO NOT CHANGE THIS CLASS. THIS CLASS IS FOR REFERENCE ONLY  **/

package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

@Test
@CucumberOptions(
    features = "features",
    glue = "definitions",
    plugin = {"pretty", "junit:target/cucumber-reports/Cucumber.xml"},
    tags = "(@Cake or @Icecream) and (not @ignore)"
)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel=false)
    public Object[][] scenarios(){
    	return super.scenarios();
    }
}