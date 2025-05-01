package dsalgo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop = new Properties();

	public static void ReadDataFromConfig() throws IOException {

		String path = System.getProperty("user.dir") + File.separator + " src " + File.separator + "test"
				+ File.separator + "resources" + File.separator + "properties" + File.separator + "config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);

	}

	public static String getUrl() {
		String url = prop.getProperty("url");
		return url;

	}

	public static String getProperty(String key) {
		String value = prop.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Missing required property: " + key);
		}
		return value;

	}

}
