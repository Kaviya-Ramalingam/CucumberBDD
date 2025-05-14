package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.utilities.ConfigReader;

public class RegisterPage extends BasePage {

	protected String registerUrl = ConfigReader.getProperty("RegisterPageUrl");

	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@type='submit']")
	WebElement registerBtn;
	@FindBy(xpath = "//input[@id='id_username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='id_password1']")
	WebElement password;
	@FindBy(xpath = "//input[@id='id_password2']")
	WebElement confirmPassword;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement alertMesg;
	@FindBy(xpath = "//a[text()='Sign out']")
	WebElement signOut;

	@Override
	public boolean isAt() {
		return getCurrentUrl().equals(registerUrl);
	}

	@Override
	public void openPage() {
		goToUrl(registerUrl);

	}
	
	public void enterRegistrationDetails(String user,String pass,String confirmPass) {
		sendInput(username, user);
		sendInput(password, pass);
		sendInput(confirmPassword, confirmPass);
	}

	public void enterUsername(String text) {
		sendInput(username, text);
	}

	public void enterPassword(String value) {
		sendInput(password, value);
	}

	public void enterConfirmPassword(String value) {
		sendInput(confirmPassword, value);
	}

	public String getSuccessMessage() {
		return getText(alertMesg);

	}

	public void clickRegisterBtn() {
		click(registerBtn);
	}

	public String getErrorMessage() {
		return getText(alertMesg);
	}
	public String usernameValidationMessage() {
	    return getValidationMessage(username);
	}

	public String passwordValidationMessage() {
	    return getValidationMessage(password);
	}

	public String confirmPasswordValidationMessage() {
	    return getValidationMessage(confirmPassword);
	}
}


