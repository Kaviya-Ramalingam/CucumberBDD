package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
    private WebDriver driver;
    private DsAlgoIPortalPage dsalgoIntroPage;
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private DataStructuresPage dataStructuresPage;
    private GraphPage graphPage;

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
    
    public RegisterPage getRegisterPage() {
    	if(registerPage==null) {
    		registerPage=new RegisterPage(driver);
    	}
		return registerPage;
    }
    
    public LoginPage getLoginPage() {
    	if(loginPage==null) {
    		loginPage = new LoginPage(driver);
    	}
		return loginPage;
    	
    }
    
    public DataStructuresPage getDataStructuresPage() {
    	if(dataStructuresPage==null) {
    		dataStructuresPage = new DataStructuresPage(driver);
    	}
		return dataStructuresPage;
    	
    }
    
    public GraphPage getGraphPage() {
    	if(graphPage == null) {
    		graphPage = new GraphPage(driver);
    	}
		return graphPage;
    }
}