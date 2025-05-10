package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
    private WebDriver driver;
    private DsAlgoIPortalPage dsalgoIntroPage;
    private HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public DsAlgoIPortalPage getDsalgoIntroPage() {
        if (dsalgoIntroPage == null) {
            dsalgoIntroPage = new DsAlgoIPortalPage(driver);
        }
        return dsalgoIntroPage;
    }

    public HomePage getHomepage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }
}