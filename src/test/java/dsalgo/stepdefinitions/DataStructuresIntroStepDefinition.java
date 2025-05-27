package dsalgo.stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import dsalgo.pageobjects.DataStructuresPage;
import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.LoginPage;
import dsalgo.utilities.ConfigReader;
import dsalgo.utilities.TestContext;
import dsalgo.utilities.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataStructuresIntroStepDefinition {

	private static final Logger logger = LoggerFactory.getLogger(DataStructuresIntroStepDefinition.class);
	TestContext context;
	DataStructuresPage dataStructuresPage;
	LoginPage loginPage;
	HomePage homePage;
	TestData testData;
	

	public DataStructuresIntroStepDefinition(TestContext context) {

		this.context = context;
		dataStructuresPage = context.getPageObjectManager().getDataStructuresPage();
		loginPage = context.getPageObjectManager().getLoginPage();
		homePage = context.getPageObjectManager().getHomepage();
		testData = context.getTestData();
	}


	@When("The user is in the Home page after logged in")
	public void the_user_is_in_the_home_page_after_logged_in() {
		
		homePage.clickSignIn();
		String userName = ConfigReader.getProperty("username");
		String password = ConfigReader.getProperty("password");
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		logger.info("The user is on the Home page");
	}

	@When("The user clicks the Get Started button in Data Structures - Introduction")
	public void the_user_clicks_the_get_started_button_in_data_structures_introduction() {
		
		homePage.clickGetStartedDataStructures();
		logger.info("user clicks the get started button in data structures");
	}

	@Then("The user should land in Data Structures- Introduction Page")
	public void the_user_should_land_in_data_structures_introduction_page() {
		
		Assert.assertTrue(dataStructuresPage.isAt(), "the user is not in data structures-introduction page");
	}

	@Given("The user is in Data structures-indroduction page")
	public void the_user_is_in_data_structures_indroduction_page() {
		
		dataStructuresPage.openPage();
		logger.info("user is in Data structures introduction page");
	}

	@When("The user clicks the Time Complexity button")
	public void the_user_clicks_the_time_complexity_button() {
		
		dataStructuresPage.clickTimeComplexity();
	}

	@Then("The user should be redirected to Time Complexity of Data Structures - Introduction")
	public void the_user_should_be_redirected_to_time_complexity_of_data_structures_introduction() {
		
		Assert.assertTrue(dataStructuresPage.isAtTimeComplexity(), "User is not at Time Complexity page");
		logger.info("user is in time-complexity of data structures-introduction");
	}

	@When("The user clicks the Practice Questions button")
	public void the_user_clicks_the_practice_questions_button() {
		
		dataStructuresPage.clickPracticeQuestions();
	}

	@Then("The user should be redirected to Practice Questions of Data Structures - Introduction")
	public void the_user_should_be_redirected_to_practice_questions_of_data_structures_introduction() {
		
		Assert.assertTrue(dataStructuresPage.isAtPracticeQuestions(), "User is not at Practice Questions page");

	}

	@When("The user clicks the Try Here button")
	public void the_user_clicks_the_try_here_button() {
		
		dataStructuresPage.clickTryHere();
	}

	@Then("The user should be redirected to a page having a try Editor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_a_try_editor_with_a_run_button_to_test() throws InterruptedException {
		
		Assert.assertTrue(dataStructuresPage.isAtTryEditor(), "User is not at Try editor page");

	}

	@When("The user clicks the Run button without entering the code in the Editor")
	public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor() {
		
		dataStructuresPage.clickRunButton();
		logger.info("user clicks run button without entering code in editor");
	}

	@Then("The user should see an error message in alert window")
	public void the_user_should_see_an_error_message_in_alert_window() throws InterruptedException  {
		
		dataStructuresPage.getAlertTextAndAccept();
	}
	@When("The user writes code for {string} from {string} in the Editor and clicks the Run button.")
	public void the_user_writes_for_from_in_the_editor_and_clicks_the_run_button(String testCaseName,
			String SheetName) throws IOException, InterruptedException {
		
		  Map<String, String> dataStructuresData = testData.getDataStructuresData(SheetName, testCaseName);
		logger.info("dataStructuresData: " + dataStructuresData);
		dataStructuresPage.EnterCode(dataStructuresData.get("PyCode"));
		dataStructuresPage.clickRunButton();
		logger.info("user clicks run button with" +testCaseName+ "in editor");

	}

	@When("The user writes code for {string} from {string} in the Editor and clicks the Run button")
	public void the_user_writes_code_for_from_in_the_editor_and_clicks_the_run_button(String testCaseName,
			String SheetName) throws IOException, InterruptedException {
		
		  Map<String, String> dataStructuresData = testData.getDataStructuresData(SheetName, testCaseName);
		logger.info("dataStructuresData: " + dataStructuresData);
		dataStructuresPage.EnterCode(dataStructuresData.get("PyCode"));
		dataStructuresPage.clickRunButton();
		logger.info("user clicks run button with" +testCaseName+ "in editor");

	}

	@Then("The user should see expected error for {string} from {string} in the alert window")
	public void the_user_should_see_expected_error_for_from_in_the_alert_window(String testCaseName, String SheetName)
			throws IOException, InterruptedException {
		
		  Map<String, String> dataStructuresData  = testData.getDataStructuresData(SheetName, testCaseName);
		String expectedError = dataStructuresData.get("RunResult");
		String actualError = dataStructuresPage.getAlertTextAndAccept();
		logger.info("actual text from alert:" + actualError);
		Assert.assertTrue(actualError.contains(expectedError));
		dataStructuresPage.navigateBack();
	}

	@Then("The user should see expected output for {string} from {string} in the console")
	public void the_user_should_see_expected_output_for_from_in_the_console(String testCaseName, String SheetName)
			throws IOException {
		
		  Map<String, String> dataStructuresData =  testData.getDataStructuresData(SheetName, testCaseName);
		  
		String actualOutput = dataStructuresPage.getOutputText();
		
		String ExpectedOutput = dataStructuresData.get("RunResult");
		Assert.assertEquals(actualOutput, ExpectedOutput);
		dataStructuresPage.navigateBack();
	}

}