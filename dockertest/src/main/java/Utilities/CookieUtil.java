package main.java.Utilities;
import org.openqa.selenium.Cookie;

import main.java.setupdata.ConfigData;
import tests.BaseTest;

public class CookieUtil {
	
	private static String cookieName = ConfigData.cookieName;
	
	public static void setToken(String accessToken) {
		BaseTest.logger.info("Passing token using cookie...");
	    Cookie cookie = new Cookie(cookieName,accessToken);
	    BaseTest.browser.getDriver().manage().addCookie(cookie);
	}
	
}