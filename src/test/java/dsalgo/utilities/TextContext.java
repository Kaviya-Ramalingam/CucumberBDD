package dsalgo.utilities;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.pageobjects.PageObjectManager;

public class TextContext {

	public static DriverFactory driverFactory;
	public static PageObjectManager pageObjectManager;


	// Constructor injection for better testability and DI support
	public TextContext() {
		this.driverFactory = new DriverFactory();
		
	}

	public static DriverFactory getDriverFactory() {
		return driverFactory;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}

