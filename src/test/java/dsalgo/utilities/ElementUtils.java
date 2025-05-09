package dsalgo.utilities;

import org.openqa.selenium.WebDriver;

public class ElementUtils {
	WebDriver driver;
	
public ElementUtils(WebDriver driver)	{
	this.driver = driver;
}
	
	
	public static void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

}
