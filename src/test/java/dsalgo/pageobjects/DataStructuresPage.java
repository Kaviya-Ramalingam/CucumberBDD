package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.utilities.ConfigReader;

public class DataStructuresPage extends BasePage {

	protected String dataStructureUrl = ConfigReader.getProperty("DataStructurePageUrl");
	protected String practiceQuestionsUrl = ConfigReader.getProperty("PracticeQuestionsUrl");
	protected String timeComplexityUrl = ConfigReader.getProperty("TimeComplexityUrl");
	protected String tryEditorUrl = ConfigReader.getProperty("TryEditorPage");
	
	public DataStructuresPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath ="//a[@href='time-complexity']")
	private WebElement DStimecomplex ;
    @FindBy(xpath="//a[text()='Practice Questions']")
	private WebElement PracticeQues;
	@FindBy(xpath="//a[contains (text(), 'Try here')]")
	private WebElement tryHere;
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	private WebElement textInput; 
	@FindBy(xpath="//button[@type='button']")
	private WebElement run;
	@FindBy(xpath = "//pre[@id='output']")
	private WebElement outputText;
	
	@Override
	public boolean isAt() {
		return getCurrentUrl().equals(dataStructureUrl);
	}

	@Override
	public void openPage() {
		goToUrl(dataStructureUrl);
		
	}

	
	public void clickTimeComplexity() {
		click(DStimecomplex);
	}
	
	public void clickPracticeQuestions() {
		click(PracticeQues);
	}
	
	public void clickTryHere() {
		tryHere.click();
	}
	
	public void clickRunButton() {
		run.click();
	}
	
	public void EnterCode(String PythonCode) {
		textInput.sendKeys(PythonCode);
	}

	public String getOutputText() {
		return outputText.getText();
	}
	public boolean isAtPracticeQuestions() {
	    return getCurrentUrl().equals(practiceQuestionsUrl);
	}

	public boolean isAtTimeComplexity() {
	    return getCurrentUrl().equals(timeComplexityUrl);
	}
	
	public boolean isAtTryEditor() throws InterruptedException {
		
	    return getCurrentUrl().equals(tryEditorUrl);
	}

}
