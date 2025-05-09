package dsalgo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@href='/login']")
	private WebElement signIn;
	
	@FindBy(xpath="//a[@href='/register']")
	private WebElement Register;
	
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	private WebElement DropDownBtn;

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
	
	
	public boolean signInBtnDisplayed() {
		return signIn.isDisplayed();
		
	}
	
	public boolean RegisterBtnDisplayed() {
		return Register.isDisplayed();
		
	}

}
