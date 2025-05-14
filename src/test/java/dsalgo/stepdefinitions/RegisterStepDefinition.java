package dsalgo.stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.RegisterPage;
import dsalgo.utilities.TestContext;
import dsalgo.utilities.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinition {
	private static final Logger logger = LoggerFactory.getLogger(RegisterStepDefinition.class);
	TestContext context;
	RegisterPage registerPage;
	TestData testData;

	private Map<String, String> registerData;// to hold scenario data
	HomePage homePage;

	public RegisterStepDefinition(TestContext context) {
		this.context = context;
		registerPage = context.getPageObjectManager().getRegisterPage();
		homePage = context.getPageObjectManager().getHomepage();
		testData = context.getTestData();
	}

	@Given("The user is on the user registration page")
	public void the_user_is_on_the_user_registration_page() {
		logger.info("user is in the registration page");
	}

	@When("The user clicks Register link on the Home page")
	public void the_user_clicks_register_link_on_the_home_page() {
		homePage.clickRegister();
		logger.info("user clicks register link on the home page");
	}

	@Then("The user should be redirected to Register form")
	public void the_user_should_be_redirected_to_register_form() {
		Assert.assertTrue(registerPage.isAt(), "The user is not in register page");
	}

	@When("The user enters registration details from sheet {string} and scenario {string}")
	public void the_user_enters_registration_details_from_sheet_and_scenario(String sheetname, String testcaseName)
			throws IOException {
		homePage.clickRegister();
		Map<String, String> registerData = testData.getRegisterData(sheetname, testcaseName);
		registerPage.enterUsername(registerData.get("UserName"));
		registerPage.enterPassword(registerData.get("Password"));
		registerPage.enterConfirmPassword(registerData.get("ConfirmPassword"));
		registerPage.clickRegisterBtn();
	}

	@Then("The user should be redirected to Home Page of DS Algo with account created message")
	public void the_user_should_be_redirected_to_home_page_of_ds_algo_with_account_created_message()
			throws IOException {
		registerData = testData.getRegisterData("Register", "RegisterValid");
		String expectedMessage = registerData.get("ExpectedMsg");

		String actualMessage = registerPage.getSuccessMessage();

		Assert.assertEquals("Success message did not match", expectedMessage, actualMessage);

	}

	@Then("The user should see the registration error message for {string} from {string}")
	public void the_user_should_see_the_registration_error_message_for_from(String testcaseName,String sheetName)
			throws IOException {
		registerData = testData.getRegisterData(sheetName,testcaseName);
		String expectedMessage = registerData.get("ExpectedMsg");
		String actualMessage = registerPage.getErrorMessage();
		Assert.assertEquals(actualMessage, expectedMessage,
				" error message did not match for scenario: " + testcaseName);
	}

	@Then("The user should see the registration warning message for {string} from {string}")
	public void the_user_should_see_the_registration_warning_message_for_from(String testcaseName,String sheetName)
			throws IOException {
		registerData = testData.getRegisterData(sheetName,testcaseName);
		String expectedWarning = registerData.get("ExpectedMsg");
		String actualWarning = "";
		switch (testcaseName) {
		case "EmptyUsername":
			actualWarning = registerPage.usernameValidationMessage();
			break;
		case "EmptyPassword":
			actualWarning = registerPage.passwordValidationMessage();
			break;
		case "EmptyConfirmPassword":
			actualWarning = registerPage.confirmPasswordValidationMessage();
			break;
		default:
			throw new IllegalArgumentException("Unknown field: " + testcaseName);
		}
		Assert.assertEquals(actualWarning, expectedWarning,
				"Warning message did not match for scenario: " + testcaseName);
	}

}
