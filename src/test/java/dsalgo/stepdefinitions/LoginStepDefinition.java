package dsalgo.stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.LoginPage;
import dsalgo.utilities.TestContext;
import dsalgo.utilities.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	private static final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
	TestContext context;
	LoginPage loginPage;
	TestData testData;
	HomePage homePage;
	private Map<String, String> loginData;

	public LoginStepDefinition(TestContext context) {
		this.context = context;
		loginPage = context.getPageObjectManager().getLoginPage();
		homePage = context.getPageObjectManager().getHomepage();
		testData = context.getTestData();
	}

	@Given("The user is on the DS Algo Home Page")
	public void the_user_is_on_the_ds_algo_home_page() {

		logger.info("user is on the ds algo home page");
	}

	@When("The user clicks the Sign in link")
	public void the_user_clicks_the_sign_in_link() {

		homePage.clickSignIn();
	}

	@Then("The user should be redirected to the Sign in page")
	public void the_user_should_be_redirected_to_the_sign_in_page() {

		Assert.assertTrue(loginPage.isAt());
	}

	@Given("The user is on the DS Algo Sign in Page")
	public void the_user_is_on_the_ds_algo_sign_in_page() {

		logger.info("user is on dsalgo signin page");
	}

	@When("The user attempts to login with {string} from sheet {string}")
	public void the_user_attempts_to_login_with_from_sheet(String testcaseName, String sheetName) throws IOException {

		homePage.clickSignIn();
		loginData = testData.getLoginData(sheetName, testcaseName);
		loginPage.enterUsername(loginData.get("UserName"));
		loginPage.enterPassword(loginData.get("Password"));
		loginPage.clickLogin();
	}

	@Then("The user should see a error message {string} from sheet {string}")
	public void the_user_should_see_a_error_message_from_sheet(String testcaseName, String sheetName)
			throws IOException {

		loginData = testData.getLoginData(sheetName, testcaseName);
		String expectedMesg = loginData.get("ExpectedMesg");
		String actualMesg = loginPage.getSuccessMesg();
		Assert.assertEquals(actualMesg, expectedMesg, "error message did not match");
	}

	@Then("The user should land in Data Structure Home Page with success message {string} from sheet {string}")
	public void the_user_should_land_in_data_structure_home_page_with_success_message_from_sheet(String testcaseName,
			String sheetName) throws IOException {

		loginData = testData.getLoginData(sheetName, testcaseName);
		String expectedMesg = loginData.get("ExpectedMesg");
		String actualMesg = loginPage.getSuccessMesg();
		Assert.assertEquals(actualMesg, expectedMesg, "Success message did not match");

	}

	@When("The user clicks logout")
	public void the_user_clicks_logout() {

		homePage.clickLogout();
		logger.info("user clicks logout");
	}

	@Then("The user should be redirected to home page with message {string}")
	public void the_user_should_be_redirected_to_home_page_with_message(String expectedMesg) {
		
		Assert.assertEquals(loginPage.getSuccessMesg(), expectedMesg, "logout message is not found");
	}

}
