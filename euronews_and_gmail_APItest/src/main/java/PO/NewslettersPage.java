package main.java.PO;

import org.openqa.selenium.By;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;

public class NewslettersPage extends Form{
								
	private static By HOME_PAGE_INDICATOR = By.xpath("//span[@class='h1 text-secondary']");
	private static IButton newslettersButton = AqualityServices.getElementFactory().getButton(By.xpath("//span[contains(@data-event,'newsletter-link-header')]"), "Newsletters Button");																					
	private static ITextBox  emailInputBox = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Enter your email')]"), "Email Gap");
	private static ITextBox additionalForm= AqualityServices.getElementFactory().getTextBox(By.xpath("//span[contains(text(),'Thanks! To complete your subscription, please click on the confirmation link(s) we just sent to your email.')]"), "Additional form");
	private static IButton closeButton = AqualityServices.getElementFactory().getButton(By.xpath("//a[@class='close-modal ']"), "Close Button");

	public NewslettersPage() {
		super(HOME_PAGE_INDICATOR, "Newsletters Page Indicator");
	}
	
	public void clickNewslettersButton() {
		newslettersButton.clickAndWait();
	}
	
	public void inputEmail(String email) {
		emailInputBox.clearAndType(email);
	}

	public boolean isAdditionalFormUp() {
		return additionalForm.state().waitForDisplayed();
	}
	
	public void clickCloseAdditionalForm() {
		closeButton.clickAndWait();
	}
}