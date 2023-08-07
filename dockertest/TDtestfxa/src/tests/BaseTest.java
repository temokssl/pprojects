package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.logging.Logger;
import main.java.Utilities.StringUtil;
import main.java.setupdata.ConfigData;
import main.java.setupdata.TestData;
public class BaseTest {
	
	
	public static Browser browser;
	public static RemoteWebDriver driver;
	public static Logger logger;
	private String web = StringUtil.getAuthURL(ConfigData.baseWeb,TestData.username,TestData.password);

    @BeforeMethod
    protected void beforeTest() {
    	logger = Logger.getInstance();
    	browser = AqualityServices.getBrowser();
    	driver = browser.getDriver();
    	browser.maximize();
		browser.goTo(web);
		browser.waitForPageToLoad();
    }
    @AfterMethod
    protected void afterTest() {
    	browser.quit();
    }
}