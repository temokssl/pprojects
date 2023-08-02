package main.java.PO;

import org.openqa.selenium.By;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;

public class HideHelpPage extends Form {
	
	
	private IButton sendToBottomButton = AqualityServices.getElementFactory().getButton(By.xpath("//span[contains(@class,'highlight')]"),"Send to bottom button");
	private static By HIDE_HELP_PAGE_INDICATOR = By.xpath("//h2[contains(@class,'help-form__title') and contains(text(),'How can we help?')]");
	
	public HideHelpPage() {
		super(HIDE_HELP_PAGE_INDICATOR, "Help Form Indicator");

	}
	public void clickSendToBottomButton() {
		sendToBottomButton.clickAndWait();
	}
}
