package main.java.PO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class UnsubscribePage extends Form{
	
	private static String SRC_ATTRIBUTE = "src";
	private static String HREF_ATTRIBUTE = "href";
	private static By UNSUBSCRIBE_PAGE_INDICATOR = By.xpath("//h3[contains(text(),'Newsletter unsubscription')]");
	public static ILink iframeElement = AqualityServices.getElementFactory().getLink(By.className("iframe-preview"),"Iframe");
	private ITextBox  emailUnsubsInputBox = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@id,'email')]"), "Email Gap");
	private IButton confirmUnsubsButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(text(),'Confirm unsubscription')]"), "Unsubs confirm button");
	private ILabel unsubsMessageILabel = AqualityServices.getElementFactory().getLabel(By.xpath("//strong[normalize-space()='You are unsubscribed.']"), "Unsubscribe message");

	public UnsubscribePage() {
		super(UNSUBSCRIBE_PAGE_INDICATOR, "Unsubscribe Page Indicator");
	}
	
	public String getPreviewLink() {
		return iframeElement.getAttribute(SRC_ATTRIBUTE);
	}
	
	public String getUnsubsLink() {
		AqualityServices.getLogger().info("Getting unsubscription link..");
		HttpResponse<String> htmlResponse = Unirest.get(getPreviewLink()).header("accept", "application/json").asString();
		Document document = Jsoup.parse(htmlResponse.getBody());
		return document.select("a:contains(clicking here)").attr(HREF_ATTRIBUTE);
	}
	
	public void inputUnsubsEmail(String email) {
		emailUnsubsInputBox.clearAndType(email);
	}
	
	public void clickUnsubsConfirmButton() {
		confirmUnsubsButton.clickAndWait();
	}
	
	public boolean isUnsubsMessageUp() {
		return unsubsMessageILabel.state().isDisplayed();
	}

}