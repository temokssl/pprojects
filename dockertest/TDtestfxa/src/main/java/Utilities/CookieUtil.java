package main.java.Utilities;
import org.openqa.selenium.Cookie;

import main.java.setupdata.ConfigData;
import tests.BaseTest;

public class CookieUtil {
		
	public static void setToken(String accessToken) {
		BaseTest.logger.info("Passing token using cookie...");
	    Cookie cookie = new Cookie(ConfigData.cookieName,accessToken);
	    BaseTest.driver.manage().addCookie(cookie);
	}
	
}