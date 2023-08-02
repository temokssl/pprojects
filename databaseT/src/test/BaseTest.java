package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class BaseTest {
	
	public static JsonSettingsFile TEST_DATA_FILE = new JsonSettingsFile("testdata.json");
	public static JsonSettingsFile SQL_QUERIES_FILE = new JsonSettingsFile("sqlqueries.json");
	public static Browser browser;

    @BeforeClass
    protected void beforeTest() {
    	browser = AqualityServices.getBrowser();
    }
    @AfterClass
    protected void afterTest() {
    	browser.quit();
    }
}