package dsalgo.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	//Encapsulation-Mark driverThreadLocal as private to prevent external modification
    //use static with ThreadLocal so that all threads and all static methods can access the same thread-local variable,
	//while each thread still gets its own independent value
	private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

	public static WebDriver browserSetup(String browser) {

		switch (browser.toLowerCase()) {

		case "chrome":
		default:
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--headless");
			driverThreadLocal.set(new ChromeDriver(co));
			break;

		case "firefox":
			FirefoxOptions fo = new FirefoxOptions();
			fo.addArguments("--headless");
			driverThreadLocal.set(new FirefoxDriver(fo));
			break;

		case "safari":
			driverThreadLocal.set(new SafariDriver());// Safari doesn't support headless mode
			break;

		}

		return getdriver();
	}

	public static WebDriver getdriver() {
		return driverThreadLocal.get();

	}

	public static void cleanupDriver() {
		WebDriver driver = driverThreadLocal.get();
		if (driver != null) {
			driver.quit();
			driverThreadLocal.remove();
		}

	}
}
