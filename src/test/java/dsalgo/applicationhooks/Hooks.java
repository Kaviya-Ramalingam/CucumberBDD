package dsalgo.applicationhooks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.utilities.ConfigReader;
import dsalgo.utilities.TextContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private static WebDriver driver;
	private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

	@Before
	public static void initialization() throws IOException {

		ConfigReader.ReadDataFromConfig();
		String browser = ConfigReader.getProperty("browser");
		String url = ConfigReader.getProperty("url");
		DriverFactory.browserSetup(browser);
		logger.info("Hook: Initializing driver for browser :" + browser);
		driver = TextContext.getDriverFactory().getdriver();
		driver.get(url);
		logger.info("hooks: url opened successfully:" + url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@After
	public static void tearDown(Scenario scenario) {

		if (driver != null && scenario.isFailed()) {
			final byte screenshot[] = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");// This will attach screenshot to html report
		}

		logger.info("Closing driver from hook's teardown method...");
		TextContext.getDriverFactory().cleanupDriver();

	}

}
