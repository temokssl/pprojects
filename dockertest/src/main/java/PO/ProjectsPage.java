package main.java.PO;

import java.util.List;

import org.openqa.selenium.By;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import main.java.Utilities.DataUtil;
import main.java.setupdata.TestData;
import tests.BaseTest;

public class ProjectsPage extends Form{

	private ITextBox newAddedTest= AqualityServices.getElementFactory().getTextBox(By.cssSelector("td a:not([href^='history'])"), "New added test");
	private ITextBox  versionFooter= AqualityServices.getElementFactory().getTextBox(By.xpath("//span[starts-with(text(), 'Version: ')]"), "Version "+TestData.variant);
	private IButton  projectButton= AqualityServices.getElementFactory().getButton(By.xpath("//a[contains(text(),'"+TestData.projectName+"')]"),TestData.projectName+" Link");
	private IButton  addButton= AqualityServices.getElementFactory().getButton(By.xpath("//a[contains(text(),'+Add')]"), "Add Button");
	private IButton addDataButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(text(),'+Add')]"), "Add data button");
	
	private By allProjectsLocator = By.cssSelector("a[href^=\"allTests?projectId=\"].list-group-item");
	
	public ProjectsPage() {
		super(By.xpath("//div[contains(text(),'Available projects')]"),"Projects Page Indicator");
	}
	
	public boolean isVariantFooter() {
		return versionFooter.getText().equals("Version: "+TestData.variant);
	}
	public void clickProjectButton() {
		projectButton.clickAndWait();
	}
	
	public void refreshPage() {
		BaseTest.browser.getDriver().navigate().refresh();
	}
	
	public void clickAddButton() {
		addButton.clickAndWait();
	}
	
	public void clickAddDataButton() {
		addDataButton.state().waitForClickable();
		addDataButton.clickAndWait();
	}
	
	public boolean isNewTestDisplayed() {
		return newAddedTest.state().waitForDisplayed();
	}
	
	public void goToCreatedProjectPage(String projectName) {
		List<ILabel> projectsList = DataUtil.getColumn(allProjectsLocator);
		for(ILabel project:projectsList) {
			if(project.getText().contentEquals(projectName)) {
				project.click();
				break;
			}
		}
	}
	
	public boolean appearsNewProject(String projectName) {
		List<ILabel> projectsList = DataUtil.getColumn(allProjectsLocator);
		for(ILabel project:projectsList) {
			if(project.getText().contentEquals(projectName)) {
				return true;
			}
		}
		return false;
	}
	
}