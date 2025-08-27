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
	private static ThreadLocal<String> scenarioName = new ThreadLocal<>();
    private static ThreadLocal<String> screenshotPath= new ThreadLocal<>();
	
    @Before
	public void initialization(Scenario scenario) throws IOException {
		scenarioName.set(scenario.getName());
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
        if (driver != null) {
            if (scenario.isFailed()) {
                // 1. Attach to Cucumber Report
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "image");

                // 2. Save screenshot to file system
                String fileName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + "_" + System.currentTimeMillis() + ".png";
                String fullPath = System.getProperty("user.dir") + "/screenshots/" + fileName;

                try {
                    byte[] fileData = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    java.nio.file.Files.createDirectories(java.nio.file.Paths.get(System.getProperty("user.dir") + "/screenshots"));
                    java.nio.file.Files.write(java.nio.file.Paths.get(fullPath), fileData);

                    // 3. Set in ThreadLocal for Jira usage
                    screenshotPath.set(fullPath);
                    System.out.println("📸 Screenshot saved at: " + fullPath);
                } catch (IOException e) {
                    System.err.println("❌ Failed to save screenshot file: " + e.getMessage());
                }
            }

            logger.info("Closing driver from hook's teardown method...");
            DriverFactory.cleanupDriver();
            logger.info("---------------------------------------------------------------------------");
        }
    }
    public static String getScenarioName() {
        return scenarioName.get();
    }

    public static String getScreenshotPath() {
        return screenshotPath.get();
    }
	
	

}
