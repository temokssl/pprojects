package main.java.PO;

import org.openqa.selenium.By;

import aquality.selenium.forms.Form;

public class FirstCardPage extends Form {
	
	private static By FIRST_CARD_INDICATOR_LOCATOR = By.xpath("//input[contains(@placeholder,'Choose Password')]");
	
	public FirstCardPage() {
		super(FIRST_CARD_INDICATOR_LOCATOR, "First Card Indicator");
	}
}
