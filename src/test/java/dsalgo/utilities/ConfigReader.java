package dsalgo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop = new Properties();

	public static void ReadDataFromConfig() throws IOException {
		//instead of giving full path using class leader to load data from file
	    try (InputStream input = ConfigReader.class.getClassLoader()
	            .getResourceAsStream("properties/config.properties")) {
	        if (input == null) {
	            throw new FileNotFoundException("config.properties file not found in resources/properties");
	        }
	        prop.load(input);
	    }
	}

	public static String getProperty(String key) {
		String value = prop.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Missing required property: " + key);
		}
		return value;

	}

}
