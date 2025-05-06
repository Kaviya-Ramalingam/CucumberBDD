package dsalgo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, 
                 glue = { "DsAlgo.StepDefinitions"},//if hooks are in same package as step definition, no need to explicitly add them.
                 monochrome = true, //formats console output for readability
                 dryRun = true, //checks unimplemented steps
                 plugin = { "pretty", "html:target/cucumber-reports/reports.html","pretty",
                		   "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][]scenarios(){
		return super.scenarios();
	}
}


