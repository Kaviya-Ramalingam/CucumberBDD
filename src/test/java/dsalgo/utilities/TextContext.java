package dsalgo.utilities;

import dsalgo.driverfactory.DriverFactory;

public class TextContext {

	public static DriverFactory driverFactory;
	

	// Constructor injection for better testability and DI support
	public TextContext() {
		this.driverFactory = new DriverFactory();
		

	}

	public static DriverFactory getDriverFactory() {
		return driverFactory;
	}

}

