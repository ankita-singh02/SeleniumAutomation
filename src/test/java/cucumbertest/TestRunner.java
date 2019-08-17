package cucumbertest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "Feature/SignupFlow/Signup_flow_V2.feature", glue = {
				"stepdefinition" }, dryRun = false, monochrome = true, plugin = { "pretty",
						"html:target/cucumber-reports/cucumber-pretty",
						"json:target/cucumber-reports/CucumberTestReport.json" })

public class TestRunner {

}
