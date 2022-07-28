package Runner_class;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features="featurefile",
                 glue={"Stepdefinitions", "Hooks"},
                 dryRun=false,
                 tags="@au",
                 plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "html:report/htmlreport", "json:report/jsonreport.json", "junit:report/junitreport"},
                 monochrome=true)

public class Runnerclass extends AbstractTestNGCucumberTests {

}
