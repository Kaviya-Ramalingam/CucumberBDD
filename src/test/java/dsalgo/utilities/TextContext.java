package dsalgo.utilities;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.pageobjects.PageObjectManager;

public class TextContext {

	private DriverFactory driverFactory;
	private PageObjectManager pageObjectManager;


	// Constructor injection for better testability and DI support
	public TextContext() {
		this.driverFactory = new DriverFactory();
		pageObjectManager = new PageObjectManager(driverFactory.getdriver());//initialising pageobjectmanager with driver
	}

	public DriverFactory getDriverFactory() {
		return driverFactory;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}

