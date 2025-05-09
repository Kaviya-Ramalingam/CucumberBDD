package dsalgo.stepdefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.pageobjects.DsAlgoIPortalPage;
import dsalgo.pageobjects.HomePage;
import dsalgo.utilities.TextContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DsAlgoPortalStepDefinition {
	TextContext context;
	DsAlgoIPortalPage dsalgoPortalPage;
	HomePage homePage;
	private static final Logger logger = LoggerFactory.getLogger(DsAlgoPortalStepDefinition.class);

	public DsAlgoPortalStepDefinition(TextContext context) {
		this.context = context;
		dsalgoPortalPage = context.getPageObjectManager().getDsalgoIntroPage();
		homePage = context.getPageObjectManager().getHomepage();
	}

	@Given("The user has browser open")
	public void the_user_has_browser_open() {

		String browser = DriverFactory.getBrowserName();
		logger.info("Running on browser: " + browser);

	}

	@When("The user enter correct dsAlgo portal URL")
	public void the_user_enter_correct_ds_algo_portal_url() {

		String currentUrl = dsalgoPortalPage.getUrl();
		logger.info("The user is in dsaldoPortalUrl:" + currentUrl);

	}

	@Then("The user should be able to land on dsAlgo portal with Get Started button")
	public void the_user_should_be_able_to_land_on_ds_algo_portal_with_get_started_button() {
		Assert.assertTrue(dsalgoPortalPage.isGetStartedButtonDisplayed(),
				"The 'Get Started' button is not visible on the portal page.");
		Assert.assertEquals(dsalgoPortalPage.getStartedText(), "Get Started",
				"The 'Get Started' button text is not as expected.");

	}

	@Given("The user opens the browser, enters the DS Algo portal")
	public void the_user_opens_the_browser_enters_the_ds_algo_portal() {
		
		String currentUrl = dsalgoPortalPage.getUrl();
		logger.info("The user is in dsaldoPortalUrl:" + currentUrl);
	}

	@When("The user clicks the Get Started button")
	public void the_user_clicks_the_get_started_button() {
		dsalgoPortalPage.clickGetStartedBtn();;
	}

	@Then("The user should be navigated to the Data Structure Introduction page, which displays the Register and Sign in links")
	public void the_user_should_be_navigated_to_the_data_structure_introduction_page_which_displays_the_register_and_sign_in_links() {
		Assert.assertTrue(homePage.RegisterBtnDisplayed(), "The Register button is not displayed");
		Assert.assertTrue(homePage.signInBtnDisplayed(), "The sign in button is not displayed");
	}

}
