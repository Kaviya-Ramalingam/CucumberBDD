package dsalgo.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.utilities.ConfigReader;

public class HomePage extends BasePage {
	
	protected String homeUrl = ConfigReader.getProperty("HomePageUrl");
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/login']")
	private WebElement signIn;

	@FindBy(xpath = "//a[@href='/register']")
	private WebElement Register;

	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	private WebElement DropDownBtn;

	@FindBy(xpath = "//a[@class='dropdown-item']")
	private List<WebElement> dropDownOptions;

	@FindBy(xpath = "//a[text()='Arrays']")
	private WebElement DropDownArray;

	@FindBy(xpath = "//a[text()='Linked List']")
	private WebElement DropDownLL;

	@FindBy(xpath = "//a[text()='Stack']")
	private WebElement DropDownStack;

	@FindBy(xpath = "//a[text()='Queue']")
	private WebElement DropDownQueue;

	@FindBy(xpath = "//a[text()='Graph']")
	private WebElement DropDownGraph;

	@FindBy(xpath = "//a[text()='Tree']")
	private WebElement DropDowntree;

	@FindBy(xpath = "//div[@class='col']//a")
	private List<WebElement> getStartedBtns;

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	private WebElement getStartedDataStructure;

	@FindBy(xpath = "//a[@href='array']")
	private WebElement getStartedArray;

	@FindBy(xpath = "//a[@href='linked-list']")
	private WebElement getStartedLL;

	@FindBy(xpath = "//a[@href='stack']")
	private WebElement getStartedStack;

	@FindBy(xpath = "//a[@href='tree']")
	private WebElement getStartedTree;

	@FindBy(xpath = "//a[@href='graph']")
	private WebElement getStartedGraph;

	@FindBy(xpath = "//a[@href='queue']")
	private WebElement getStartedQueue;

	@FindBy(xpath = "//div[contains(text(),'You are not logged in')]")
	private WebElement errorMessage;

	public boolean signInBtnDisplayed() {
		return isDisplayed(signIn);

	}
	public void clickSignIn() {
		click(signIn);
	}

	public boolean RegisterBtnDisplayed() {
		return isDisplayed(Register);

	}

	public void clickDropDownBtn() {
		click(DropDownBtn);
	}

	public List<String> getDropdownOptionsText() {
		List<String> optionsText = new ArrayList<>();
		for (WebElement option : dropDownOptions) {
			optionsText.add(option.getText().trim());
		}
		return optionsText;
	}

	public void selectFromDropdown(String optionText) {
		WebElement option = driver.findElement(By.xpath("//a[text()='" + optionText + "']"));
		click(option);
	}

	public String getErrorMessage() {
		return getText(errorMessage);

	}

	public List<String> getGetStartedText() {
		List<String> getStartedText = new ArrayList<>();
		for (WebElement Text : getStartedBtns) {
			getStartedText.add(Text.getText().trim());
		}
		return getStartedText;
	}

	public void clickGetStarted(String text) {
		WebElement getStartedbtn = driver.findElement(By.xpath("//a[@href='" + text + "']"));
		click(getStartedbtn);
	}
	
	public void clickRegister() {
		click(Register);
	}

	@Override
	public boolean isAt() {
		
		    return getCurrentUrl().equals(homeUrl);
		}
	

	@Override
	public void openPage() {
		goToUrl(homeUrl);
		
	}

	
}
