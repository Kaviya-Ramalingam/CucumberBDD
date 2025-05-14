package dsalgo.utilities;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.pageobjects.PageObjectManager;

public class TestContext {

	private DriverFactory driverFactory;
	private PageObjectManager pageObjectManager;
	 private TestData testData;


	// Constructor injection for better testability and DI support
	public TestContext() {
		   this.testData = new TestData();
		this.driverFactory = new DriverFactory();
		pageObjectManager = new PageObjectManager(DriverFactory.getdriver());//initialising pageobjectmanager with driver
	}

	public TestData getTestData() {
		return testData;
	}

	
	public DriverFactory getDriverFactory() {
		return driverFactory;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}

