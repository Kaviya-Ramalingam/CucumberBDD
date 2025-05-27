package dsalgo.stepdefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import dsalgo.pageobjects.GraphPage;
import dsalgo.pageobjects.HomePage;
import dsalgo.utilities.TestContext;
import dsalgo.utilities.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GraphStepDefinition {

	private static final Logger logger = LoggerFactory.getLogger(GraphStepDefinition.class);
	TestContext context;
	HomePage homePage;
	TestData testData;
	GraphPage graphPage;

	public GraphStepDefinition(TestContext context) {

		this.context = context;
		homePage = context.getPageObjectManager().getHomepage();
		graphPage = context.getPageObjectManager().getGraphPage();
		testData = context.getTestData();
	}

	@When("The user clicks the Graph link")
	public void the_user_clicks_the_graph_link() {
		
		homePage.clickGraph();

	}

	@Then("The user should be redirected to the Graph page")
	public void the_user_should_be_redirected_to_the_graph_page() {
		
		Assert.assertTrue(graphPage.isAt());
		logger.info("user is in graph page");
	}

	@Given("The user is on the Graph page")
	public void the_user_is_on_the_graph_page() {
		
		graphPage.openPage();
		graphPage.clickGraph();
	}

	@When("The user clicks the Graph Representations link")
	public void the_user_clicks_the_graph_representations_link() {
		
		graphPage.clickGraphRep();
		logger.info("user is in graph representation page");
	}

	@Then("The user should be redirected to Practice Questions of graph")
	public void the_user_should_be_redirected_to_practice_questions_of_graph() {

		Assert.assertTrue(graphPage.isAtPracticeQuestions(), "User is not at Practice Questions page");

	}

	@Then("The user should be redirected to the Graph Representations page")
	public void the_user_should_be_redirected_to_the_graph_representations_page() {

	}

	@When("The user clicks the Graph Representations page")
	public void the_user_clicks_the_graph_representations_page() {

	}
}
