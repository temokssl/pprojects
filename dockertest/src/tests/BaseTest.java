package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.logging.Logger;
import main.java.Utilities.StringUtil;
import main.java.setupdata.ConfigData;
import main.java.setupdata.TestData;
public class BaseTest {
	
	
	public static Browser browser = AqualityServices.getBrowser();
	public static RemoteWebDriver driver = browser.getDriver();
	public static Logger logger = Logger.getInstance();
	private static String web = StringUtil.getAuthURL(ConfigData.baseWeb,TestData.username,TestData.password);

    @BeforeMethod
    protected void beforeTest() {
    	browser.maximize();
		browser.goTo(web);
		browser.waitForPageToLoad();
    }
    @AfterClass
    protected void afterTest() {
    	browser.quit();
    }
}