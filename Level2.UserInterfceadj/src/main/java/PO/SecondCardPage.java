package main.java.PO;

import java.util.List;
import org.openqa.selenium.By;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import main.java.Utilities.RandomValuesUtil;

public class SecondCardPage extends Form {
	

	private ITextBox  passwordBox = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Choose Password')]"), "Password Gap");
	private ITextBox  emailBox = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Your email')]"), "Email Gap");
	private ITextBox  domainBox = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"), "Domain Gap");
	private IButton   tLDDomainComboBoxButton = AqualityServices.getElementFactory().getButton(By.cssSelector(".dropdown__field"), "TLD Domain ComboBox");
	private ICheckBox termsandConditionsCheckBox = AqualityServices.getElementFactory().getCheckBox(By.xpath("//span[contains(@class,'checkbox__box')]"), "Terms & Conditions CheckBox");
	private IButton nextButton = AqualityServices.getElementFactory().getButton(By.xpath("//a[contains(text(),'Next')]"), "Next Button");
	private static By SECOND_CARD_INDICATOR_LOCATOR = By.xpath("//button[contains(text(),'Download image')]");
	private static By TLDD_DOMAIN_LIST_LOCATOR = By.className("dropdown__list-item");
	private int MINIMUM_VALID_COMBOBOX_INDEX = 1;
	

	public SecondCardPage() {
		super(SECOND_CARD_INDICATOR_LOCATOR, "Second Card Indicator");
	}
	private List<ITextBox> getTLDDomainList(){
		return getElementFactory().findElements(TLDD_DOMAIN_LIST_LOCATOR,ElementType.TEXTBOX);
	}
	
	public void inputValidPassword(String Password) {
		passwordBox.clearAndType(Password);
	}
	public void inputEmail(String email) {
		emailBox.clearAndType(email);
	}
	public void inputDomain(String RandomDomain) {
		domainBox.clearAndType(RandomDomain);
	}
	public void inputTLDDomain() {
		tLDDomainComboBoxButton.click();
		List<ITextBox> tLDDomainList = getTLDDomainList();
		int numberOfElementsOnDomainComboBox = tLDDomainList.size();
		int randomDomainIndex = RandomValuesUtil.getRandomNumber(MINIMUM_VALID_COMBOBOX_INDEX, numberOfElementsOnDomainComboBox);
		tLDDomainList.get(randomDomainIndex).click();
	}
	public void unselectTermsandConditionsCheckBox() {
		termsandConditionsCheckBox.check();
	}
	public void clickNextButton() {
		nextButton.getMouseActions().moveMouseToElement();
		nextButton.clickAndWait();
	}
}
