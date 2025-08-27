package dsalgo.utilities;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.jira.JiraCredential;
import dsalgo.pageobjects.PageObjectManager;

public class TestContext {

	private DriverFactory driverFactory;
	private PageObjectManager pageObjectManager;
	private TestData testData;
	private JiraCredential jiraCredential;

	// Constructor injection for better testability and DI support
	public TestContext() {
		this.testData = new TestData();
		this.driverFactory = new DriverFactory();
		this.pageObjectManager = new PageObjectManager(DriverFactory.getdriver());// initialising pageobjectmanager with																			// driver
		this.jiraCredential = new JiraCredential();
	}

	public JiraCredential getJiraCredential() {
		return jiraCredential;
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

