package dsalgo.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.utilities.ConfigReader;

public class LoginPage extends BasePage{
	
	protected String loginUrl = ConfigReader.getProperty("loginPageUrl");
	

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement login;
	@FindBy(xpath = "//input[@id='id_username']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='id_password']")
	private WebElement password;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	private WebElement alertMesg;

	@Override
	public boolean isAt() {
		return getCurrentUrl().equals(loginUrl);
	}

	@Override
	public void openPage() {
		goToUrl(loginUrl);
		
	}
	
	public void enterUsername(String text) {
		sendInput(username, text);
	}

	public void enterPassword(String value) {
		sendInput(password, value);
	}
	
	public void clickLogin() {
		click(login);
	}

	public String getSuccessMesg() {
		return getText(alertMesg);
	}
}
