package dsalgo.runner;

import org.numpyninja.jira.JiraManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import dsalgo.applicationhooks.Hooks;
import dsalgo.utilities.JiraIntegration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@RegisterPage", features = { "src/test/resources/features" }, glue = {
		"dsalgo.stepdefinitions", "dsalgo.applicationhooks" }, // if hooks are in same package as step definition,
		// no need to explicitly add them.or else add package name of hooks
		monochrome = !true, // formats console output for readability
		dryRun = false, // checks unimplemented steps
		plugin = { "pretty", "html:target/cucumber-reports/reports.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				  })

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	/*@AfterMethod
    public void AfterEachMethod(ITestResult result) {
		String scenarioName = Hooks.getScenarioName();
	    String status = result.isSuccess() ? "PASSED" : "FAILED";
	    String summary = "Test Result: " + scenarioName + " - " + status;
	    String description = "Scenario: " + scenarioName + "\nStatus: " + status;
	    String failureMessage = result.getThrowable() != null ? result.getThrowable().getMessage() : "";
	    String screenshotPath = Hooks.getScreenshotPath();
	    String projectKey = "DSALG0";
	    String issueType = status.equals("PASSED") ? "Task" : "Bug";

	    // 1. Check if already reported
	    String existingIssueKey = JiraIntegration.getIssueBySummary(projectKey, scenarioName);

	    if (existingIssueKey != null) {
	        // 2. Update existing issue
	        JiraIntegration.updateIssue(existingIssueKey, failureMessage, issueType,screenshotPath);
	       
	    } else {
	        // 3. Create new issue
	    	JiraIntegration.createJiraIssue(projectKey, summary, screenshotPath, status, failureMessage,scenarioName);
	       
	    }*/
	 @AfterMethod
	    public void afterTest(ITestResult result) {
	       
	        String status = result.isSuccess() ? "PASSED" : "FAILED";
	        String scenarioName =Hooks.getScenarioName();
	        String summary = "Test Result: " + scenarioName + " - " + status;
	        String failureMessage = result.getThrowable() != null ? result.getThrowable().getMessage() : "No error message available.";
	        String screenshotPath = Hooks.getScreenshotPath();

	        JiraManager.handleIssue(summary, status, failureMessage, screenshotPath);
	    }
	}


