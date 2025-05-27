package dsalgo.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import dsalgo.driverfactory.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = { "src/test/resources/features" }, glue = { "dsalgo.stepdefinitions",
		"dsalgo.applicationhooks" }, // if hooks are in same package as step definition,
		// no need to explicitly add them.or else add package name of hooks
		monochrome = !true, // formats console output for readability
		dryRun = false, // checks unimplemented steps
		plugin = { "pretty", "html:target/cucumber-reports/reportsparallel.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })

public class TestRunnerParallel extends AbstractTestNGCucumberTests {
	private static final Logger logger = LoggerFactory.getLogger(TestRunnerParallel.class);
	private static long suiteStartTime;
	private static long suiteEndTime;
	private long testStartTime;
	private long testEndTime;

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeMethod
	@Parameters({ "browser" })

	public void defineBrowser(String browser) throws Throwable {

		logger.info("setting browser:: " + browser);
		DriverFactory.setBrowserName(browser);

	}
	
	@AfterMethod
	@Parameters({ "browser" })
	public void closeBrowser(String browser) {
	
		DriverFactory.cleanUpBrowser();
		logger.info("closing browser::" +browser);
	}

	@BeforeSuite
	public void beforeSuite() {
		suiteStartTime = System.currentTimeMillis();
		logger.info("Test Suite started at: " + new java.util.Date(suiteStartTime));
	}

	@AfterSuite
	public void afterSuite() {
		suiteEndTime = System.currentTimeMillis();
		logger.info("Test Suite ended at: " + new java.util.Date(suiteEndTime));
		long duration = suiteEndTime - suiteStartTime;
		System.out.println("Total execution time (ms): " + duration);
		System.out.println("Total execution time (s): " + (duration / 1000));
	}

	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browser) {
		testStartTime = System.currentTimeMillis();
		logger.info("[" + browser + "] Test started at: " + new java.util.Date(testStartTime));

	}

	@AfterTest
	@Parameters("browser")
	public void afterTest(String browser) {
		testEndTime = System.currentTimeMillis();
		logger.info("[" + browser + "] Test ended at: " + new java.util.Date(testEndTime));
		long duration = testEndTime - testStartTime;
		logger.info("[" + browser + "] Total execution time (ms): " + duration);
		logger.info("[" + browser + "] Total execution time (s): " + (duration / 1000));
	}
}
