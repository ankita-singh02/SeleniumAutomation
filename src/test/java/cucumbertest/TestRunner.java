package cucumbertest;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	
		features = "Feature/SignupFlow/Signup_flow_V2.feature"
		,glue={"stepdefinition"}
		,  dryRun = false,
		monochrome = true,
		plugin = {"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json"}
		)

public class TestRunner {

}
