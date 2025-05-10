package dsalgo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@HomePage",features = { "src/test/resources/features" }, 
                 glue = { "dsalgo.stepdefinitions","dsalgo.applicationhooks"},//if hooks are in same package as step definition, 
                 //no need to explicitly add them.or else add package name of hooks 
                 monochrome = true, //formats console output for readability
                 dryRun = false, //checks unimplemented steps
                 plugin = { "pretty", "html:target/cucumber-reports/reports.html",
                		   "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = false)
	public Object[][]scenarios(){
		return super.scenarios();
	}
}


