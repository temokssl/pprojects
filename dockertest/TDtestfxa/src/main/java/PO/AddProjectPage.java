package main.java.PO;

import org.openqa.selenium.By;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import tests.BaseTest;

public class AddProjectPage extends Form {

	private ITextBox enterProjectNameSpace = AqualityServices.getElementFactory().getTextBox(By.cssSelector("input.form-control[name=\"projectName\"]"), "Input project name");
	private IButton saveProjectButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(@class, 'btn-primary')]"), "Save Project Button");
	private ITextBox successBanner = AqualityServices.getElementFactory().getTextBox(By.xpath("//div[contains(@class, 'alert-success')]"), "Success Banner");
	
	public AddProjectPage() {
		super(By.cssSelector("label[for='projectName']"), "Add new project page indicator");
	}
	
	public void enterProjectName(String projectName) {
		BaseTest.driver.switchTo().window(BaseTest.driver.getWindowHandles().toArray()[1].toString());
		enterProjectNameSpace.state().waitForDisplayed();
		enterProjectNameSpace.clearAndType(projectName);
	}
	
	public void clickSaveProjectButton() {
		saveProjectButton.clickAndWait();
	}
	
	public boolean wasSuccesfullySaved(String projectName) {
		return successBanner.getText().contentEquals("Project "+projectName+" saved");
	}
	
	public void quitAddProjectWindow() {
		BaseTest.driver.close();
		BaseTest.driver.switchTo().window(BaseTest.browser.getDriver().getWindowHandles().toArray()[0].toString());
	}

}