package main.java.PO;

import org.openqa.selenium.By;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;

public class HomePage extends Form {
														
	private IButton hereToGoButton = AqualityServices.getElementFactory().getButton(By.xpath("//a[contains(text(),'HERE')]"), "Please click HERE to Go to the next page");
	private static By HOME_PAGE_INDICATOR = By.xpath("//div[contains(@class,'logo__icon')]");
	
	public HomePage() {
		super(HOME_PAGE_INDICATOR, "Home Page Indicator");
	}
	public void clickHeretoGoButton() {
		hereToGoButton.clickAndWait();
	}
}
