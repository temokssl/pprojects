package main.java.PO;

import org.openqa.selenium.By;

import aquality.selenium.forms.Form;

public class NewTestPage extends Form {

	public NewTestPage() {
		super(By.cssSelector("td a:not([href^='history'])"), "New test page indicator");
	}
	
}
