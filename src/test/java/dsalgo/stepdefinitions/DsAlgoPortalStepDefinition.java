package dsalgo.stepdefinitions;

import dsalgo.pageobjects.DsAlgoIPortalPage;
import dsalgo.utilities.TextContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DsAlgoPortalStepDefinition {
	TextContext context;
	DsAlgoIPortalPage dsalgoPortalPage;
	
	public DsAlgoPortalStepDefinition(TextContext context) {
		this.context = context;
		dsalgoPortalPage=context.getPageObjectManager().getDsalgoIntroPage();
	}
	
	
	@Given("The user has browser open")
	public void the_user_has_browser_open() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user enter correct dsAlgo portal URL")
	public void the_user_enter_correct_ds_algo_portal_url() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be able to land on dsAlgo portal with Get Started button")
	public void the_user_should_be_able_to_land_on_ds_algo_portal_with_get_started_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The user opens the browser, enters the DS Algo portal")
	public void the_user_opens_the_browser_enters_the_ds_algo_portal() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks the Get Started button")
	public void the_user_clicks_the_get_started_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be navigated to the Data Structure Introduction page, which displays the Register and Sign in links")
	public void the_user_should_be_navigated_to_the_data_structure_introduction_page_which_displays_the_register_and_sign_in_links() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("The user enters an incorrect dsAlgo portal URL")
	public void the_user_enters_an_incorrect_ds_algo_portal_url() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should see an error message or a {string} screen")
	public void the_user_should_see_an_error_message_or_a_screen(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
