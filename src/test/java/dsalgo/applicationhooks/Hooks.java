package dsalgo.applicationhooks;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

	@Before
	public void initialization(Scenario scenario) throws IOException {
	
		logger.info("------Thread ID in @Before: {}", Thread.currentThread().getId());
		logger.info(scenario.getSourceTagNames() + " : " + scenario.getName());
		ConfigReader.ReadDataFromConfig();
		String browser = DriverFactory.getBrowserName();// to read from testng.xml file
		DriverFactory.browserSetup(browser);
	    logger.info("Hook: Initializing driver for browser :" + browser);

		WebDriver driver = DriverFactory.getdriver();
		driver.manage().window().maximize();

	}

	@After
	public void tearDown(Scenario scenario) {
		WebDriver driver = DriverFactory.getdriver();
		if (driver != null && scenario.isFailed()) {
			final byte screenshot[] = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");// This will attach screenshot to html report
		}

		logger.info("Closing driver from hook's teardown method...");

		DriverFactory.cleanupDriver();
		logger.info("---------------------------------------------------------------------------");

	}

}
