package dsalgo.stepdefinitions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import dsalgo.pageobjects.HomePage;
import dsalgo.utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDefinition {
	TestContext context;
	HomePage homePage;

	public HomeStepDefinition(TestContext context) {
		this.context = context;
		homePage = context.getPageObjectManager().getHomepage();

	}


	private static final Logger logger = LoggerFactory.getLogger(HomeStepDefinition.class);

	@Given("The user is on the Home page")
	public void the_user_is_on_the_home_page() {
		
		 if (!homePage.isAt()) {
		        homePage.openPage();
		    }
		    Assert.assertTrue(homePage.isAt(), "User is not on the Home page!");
		    logger.info("The user is on the Home page");
	}

	@When("The user clicks the Data Structures dropdown")
	public void the_user_clicks_the_data_structures_dropdown() {
		                           
		homePage.clickDropDownBtn();
		logger.info("user clicks the data structures dropdown");
	}

	@Then("The user should see the following options in the dropdown:")
	public void the_user_should_see_the_following_options_in_the_dropdown(io.cucumber.datatable.DataTable dataTable) {

		List<String> expectedOptions = dataTable.asList();
		List<String> actualOptions = homePage.getDropdownOptionsText();
		Assert.assertEquals(actualOptions, expectedOptions, "Dropdown options do not match expected list!");
	}

	@When("The user selects {string} from the drop down without Sign in.")
	public void the_user_selects_from_the_drop_down_without_sign_in(String dropdownOptions) {
		
		logger.info("The user selects " + dropdownOptions + " from the dropdown without signIn");
		homePage.clickDropDownBtn();
		homePage.selectFromDropdown(dropdownOptions);
	}

	@Then("The user should able to see an warning message {string}")
	public void the_user_should_able_to_see_an_warning_message(String expectedWarningMessage) {

		String actualWarningMessage = homePage.getErrorMessage();
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Warning message did not match!");
	}

	@When("The user clicks Get Started buttons of {string} on the homepage without Sign in")
	public void the_user_clicks_get_started_buttons_of_on_the_homepage_without_sign_in(String getStartedBtn) {
		
		logger.info("The user clicks get started buttons of " + getStartedBtn + " on the homepage without sign in");
		homePage.clickGetStarted(getStartedBtn);
	}

}