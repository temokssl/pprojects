
package main.java.PO;

import java.util.List;
import org.openqa.selenium.By;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.CheckBox;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import main.java.Utilities.RandomValuesUtil;


public class ThirdCardPage extends Form {
	
	private ICheckBox unselectAll= AqualityServices.getElementFactory().getCheckBox(By.xpath("//label[contains(@for,'interest_unselectall')]"), "Unselect All CheckBox");
	private IButton uploadButton = AqualityServices.getElementFactory().getButton(By.className("avatar-and-interests__upload-button"), "Upload Button");
	private IButton nextButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(text(),'Next')]"), "Next Button");
	private static By CHECK_BOX_LIST_XPATH = By.xpath("//div[contains(@class,'avatar-and-interests__interests-list')]//label");
	private static By THIRD_CARD_INDICATOR_LOCATOR = By.xpath("//div[contains(text(),'First name')]");
	private int SELECT_ALL_CHECKBOX_INDEX = 17;
	private int UNSELECT_ALL_CHECKBOX_INDEX = 20;
	
	
	
	
	public ThirdCardPage() {
		super(THIRD_CARD_INDICATOR_LOCATOR, "Third Card Indicator");
	}
	
	private List<CheckBox> getCheckboxList(){
		return AqualityServices.getElementFactory().findElements(CHECK_BOX_LIST_XPATH, ElementType.CHECKBOX);
	}
	private List<Integer> getListOfCheckboxIndexes(int sizeOfCheckboxList,int numberOfInterests){
		return RandomValuesUtil.getListOfRandomCheckboxIndexes(sizeOfCheckboxList,numberOfInterests,SELECT_ALL_CHECKBOX_INDEX,UNSELECT_ALL_CHECKBOX_INDEX);
	}
	
	
	public void unselectAll() {
		unselectAll.check();
	}
	
	
	public void selectInterests(int numberOfInterests) {
		List<CheckBox> checkboxList = getCheckboxList();
		int sizeOfCheckboxList = checkboxList.size();
		List<Integer> checkboxIndexesList = getListOfCheckboxIndexes(sizeOfCheckboxList,numberOfInterests);
		
			for(int i=0;i<numberOfInterests;i++) {
				int randomInterestIndex = checkboxIndexesList.get(i);
				checkboxList.get(randomInterestIndex).clickAndWait();
			}
	}
	
	
	public void clickUploadButton(){
		uploadButton.clickAndWait();
	}
	
	
	public void clickNextButton(){
		nextButton.getMouseActions().moveMouseToElement();
		nextButton.clickAndWait();
	}
}
