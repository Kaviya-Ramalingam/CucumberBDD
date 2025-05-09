package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.utilities.ConfigReader;

public class DsAlgoIPortalPage {

	WebDriver driver;

	protected String baseUrl = ConfigReader.getProperty("url");

	public DsAlgoIPortalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Get Started']")
	private WebElement GetStartedBtn;

	public String getUrl() {
		driver.get(baseUrl);
		return baseUrl;

	}

	public boolean isGetStartedButtonDisplayed() {
		return GetStartedBtn.isDisplayed();

	}

	public String getStartedText() {
		return GetStartedBtn.getText();

	}

	public void clickGetStartedBtn() {
		GetStartedBtn.click();
	}

}
