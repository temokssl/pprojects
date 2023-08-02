package main.java.PO;

import java.util.List;

import org.openqa.selenium.By;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import main.java.Utilities.RandomValuesUtil;

public class SubscribePage extends Form{

	private static int FIRST_INDEX = 0;
	private static By NEWSLETTERS_PREVIEW_LIST_PATH = By.xpath("//a[contains(., 'Or see previews')]");
	private static By NEWSLETTERS_LIST_XPATH = By.cssSelector("label.btn-tertiary");
	private static By SUBSCRIBE_PAGE_INDICATOR = By.xpath("//h1[contains(text(),'Your subscription has been successfully confirmed.')]");
	private static ITextBox submitForm= AqualityServices.getElementFactory().getTextBox(By.xpath("//p[contains(text(),'Enter your email to subscribe to all selected newsletters.')]"), "Submit form");
	private static IButton submitButton = AqualityServices.getElementFactory().getButton(By.xpath("//input[@value='Submit']"), "Submit Button");
	private static IButton backToSiteButton = AqualityServices.getElementFactory().getButton(By.xpath("//span[contains(text(),'Back to the site')]"), "Back to the site Button");

	public SubscribePage() {
		super(SUBSCRIBE_PAGE_INDICATOR, "Subscribe Page Indicator");
	}
	
	private List<IButton> getButtonList(By PATH){
		return AqualityServices.getElementFactory().findElements(PATH, ElementType.BUTTON);
	}
	
	private int randomIndex = RandomValuesUtil.getRandomNumber(FIRST_INDEX,getButtonList(NEWSLETTERS_LIST_XPATH).size());
	
	private IButton getRandomButton(By PATH,int randomIndex) {
		return getButtonList(PATH).get(randomIndex);
	}
	
	public void clickRandomNewsletterSubsButton() {
		IButton newsletterButton = getRandomButton(NEWSLETTERS_LIST_XPATH,randomIndex);
		newsletterButton.getMouseActions().moveMouseToElement();
		newsletterButton.clickAndWait();
	}
	
	public boolean isSubmitFormUp() {
		return submitForm.state().isDisplayed();
	}
	
	public void clickSubmitButton() {
		submitButton.clickAndWait();
	}
	
	public void clickBackToTheSiteButton() {
		backToSiteButton.clickAndWait();
	}
	
	public void clickRandomNewsletterPreviewButton() {
		IButton newsletterButton = getRandomButton(NEWSLETTERS_PREVIEW_LIST_PATH,randomIndex);
		newsletterButton.getMouseActions().moveMouseToElement();
		newsletterButton.clickAndWait();
	}
}