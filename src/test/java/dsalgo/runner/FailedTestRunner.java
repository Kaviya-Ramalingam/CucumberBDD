package dsalgo.runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "@target/failed_scenarios.txt" }, glue = {
		"dsalgo.stepdefinitions", "dsalgo.applicationhooks" }, // if hooks are in same package as step definition,
		// no need to explicitly add them.or else add package name of hooks
		monochrome = !true, // formats console output for readability
		dryRun = false, // checks unimplemented steps
		plugin = { "pretty", "html:target/cucumber-reports/failed_scenarios.html"
				 })

public class FailedTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
