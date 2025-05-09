package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	WebDriver driver;
	public DsAlgoIPortalPage dsalgoIntroPage;
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver=driver;
	}

	public DsAlgoIPortalPage getDsalgoIntroPage() {
		return dsalgoIntroPage=new DsAlgoIPortalPage(driver);
		
	}

}
