package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DsAlgoIPortalPage extends BasePage {

	public DsAlgoIPortalPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[text()='Get Started']")
	private WebElement GetStartedBtn;

	public String getUrl() {
		goToUrl(baseUrl);
		return baseUrl;

	}

	public boolean isGetStartedButtonDisplayed() {
		return isDisplayed(GetStartedBtn);

	}

	public String getStartedText() {
		return getText(GetStartedBtn);

	}

	public void clickGetStartedBtn() {
		click(GetStartedBtn);
	}

	@Override
	public boolean isAt() {
		return isDisplayed(GetStartedBtn); 
		}

	@Override
	public void openPage() {
		goToUrl(baseUrl);
	}

}
