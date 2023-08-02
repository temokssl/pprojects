package main.java.PO;

import org.openqa.selenium.By;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;

public class AcceptCookiesPage extends Form {

	private ITextBox cookiesBanner = AqualityServices.getElementFactory().getTextBox(By.xpath("//button[contains(text(),'Not really, no')]"),"Accept Cookies Button");
	private static By COOKIES_PAGE_INDICATOR_LOCATOR = By.xpath("//div[contains(@class,'cookies')]");
	
	public AcceptCookiesPage() {
		super(COOKIES_PAGE_INDICATOR_LOCATOR, "Cookies Banner Indicator");
	}
	public void clickAcceptCookies() {
		cookiesBanner.clickAndWait();
	}

}
