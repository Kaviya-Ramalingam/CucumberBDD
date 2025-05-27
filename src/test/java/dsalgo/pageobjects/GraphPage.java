package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.utilities.ConfigReader;

public class GraphPage extends BasePage {
	protected String GraphPageUrl = ConfigReader.getProperty("GraphPage");
	protected String PractiseQuestionGraph = ConfigReader.getProperty("PractiseQuestionGraph");
	
	public GraphPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}



	@FindBy(xpath="//a[@href='graph']")
	WebElement graph;
	
	@FindBy(xpath="//a[text()='Graph Representations']")
	WebElement graphRepresentation;
	
	
	
	public void clickGraph() {
		click(graph);
	}
	public void clickGraphRep() {
		click(graphRepresentation);
	}
	
	public boolean isAtPracticeQuestions() {
	    return getCurrentUrl().equals(PractiseQuestionGraph);
	}
	



	@Override
	public boolean isAt() {
		return getCurrentUrl().equals(GraphPageUrl);
	}



	@Override
	public void openPage() {
		goToUrl(GraphPageUrl);
		
	}
}
