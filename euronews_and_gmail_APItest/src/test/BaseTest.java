package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.JsonSettingsFile;


public class BaseTest {
	
	public static JsonSettingsFile configurationFile = new JsonSettingsFile("config.json");
	private static String URL = configurationFile.getValue("/URL").toString();
	public static JsonSettingsFile testDataFile = new JsonSettingsFile("testdata.json");
	private static Browser browser = AqualityServices.getBrowser();
	
    @BeforeMethod
    protected void beforeMethod() {
    	browser.maximize();
    	browser.goTo(URL);
    	browser.waitForPageToLoad();
    }
    @AfterClass
    protected void afterTest() {
    	browser.quit();
    }
}
