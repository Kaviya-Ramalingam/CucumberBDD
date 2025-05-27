package dsalgo.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.utilities.ConfigReader;
import dsalgo.utilities.Timeouts;

public abstract class BasePage {

	private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
	protected String baseUrl = ConfigReader.getProperty("url");
	protected WebDriver driver = DriverFactory.getdriver();
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		logger.info(Thread.currentThread() + this.toString());
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Timeouts.LONG.getDuration());

	}

	public void goToUrl(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getAlertTextAndAccept() throws InterruptedException {

		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();

		String text = alert.getText();

		alert.accept();
		return text;

	}

	public void click(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			logger.info("Clicked on: " + element.toString());
		} catch (Exception e) {
			logger.error("Failed to click on: " + element.toString(), e);
		}
	}

	public void ScrolltoElementandClick(WebElement element) {

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Actions action = new Actions(this.driver);
			action.moveToElement(element).click().perform();
		} catch (Exception e) {
			logger.error("actionScrolltoElement::The element " + element.toString()
					+ " may not scrolled to element. Exception is: " + e.getMessage());
		}

	}

	public void sendInput(WebElement element, String textToBeTyped) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));

			element.clear();
			element.click();
			element.sendKeys(textToBeTyped);
			logger.info("Entered text into: " + element.toString());
		} catch (Exception e) {
			logger.error("Cannot send input to " + element.toString(), e);
		}
	}

	public String getText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}

	public boolean isDisplayed(WebElement element) {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		} catch (Exception e) {
			logger.warn("Element not displayed: " + element.toString());
			return false;
		}
	}

	public String getValidationMessage(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return arguments[0].validationMessage;", element);
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public abstract boolean isAt();

	public abstract void openPage();
}
