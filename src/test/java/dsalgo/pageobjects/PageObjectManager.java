package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	WebDriver driver;
	public DsAlgoIPortalPage dsalgoIntroPage;
	public HomePage homePage;
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver=driver;
	}

	public DsAlgoIPortalPage getDsalgoIntroPage() {
		return dsalgoIntroPage=new DsAlgoIPortalPage(driver);
		
	}
	
	public HomePage getHomepage() {
		if(homePage==null) {
			homePage =new HomePage(driver);
		}
		return homePage;
	}

}
