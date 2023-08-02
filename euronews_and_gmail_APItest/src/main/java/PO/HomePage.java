package main.java.PO;

import org.openqa.selenium.By;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;

public class HomePage extends Form{
														
	private static By HOME_PAGE_INDICATOR = By.xpath("//a[@aria-label='Euronews Logo']//h1//*[name()='svg']");
	private IButton agreeButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(@id,'didomi-notice-agree-button')]"), "Agree Button");																					

	public HomePage() {
		super(HOME_PAGE_INDICATOR, "Home Page Indicator");
	}
	public void clickAgreeButton() {
		agreeButton.clickAndWait();
	}
}