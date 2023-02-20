package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;


@CucumberOptions (features = "src/test/java/features/End2End_Tests.feature" , glue = {"stepsdefinition"} ,
plugin = {"pretty","html:target/cucumber-html-report"}) 


public class TestRunner extends TestBase {

}
