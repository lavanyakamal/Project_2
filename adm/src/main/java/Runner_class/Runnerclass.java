package Runner_class;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features="featurefile",
                 glue="stepdefinitions",
                 dryRun=false,
                 tags="@profileActivation",
                 plugin= {"html:report/htmlreport", "json:report/jsonreport.json", "junit:report/junitreport"},
                 monochrome=true)

public class Runnerclass {

}
