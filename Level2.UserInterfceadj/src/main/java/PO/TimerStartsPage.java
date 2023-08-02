package main.java.PO;

import org.openqa.selenium.By;

import aquality.selenium.forms.Form;

public class TimerStartsPage extends Form {
	
	private static By TIMER_PAGE_INDICATOR = By.xpath("//div[contains(@class,'timer') and contains(text(), '00:00:00')]");
	
	public TimerStartsPage() {
		super(TIMER_PAGE_INDICATOR, "Timer");	
	}
}
