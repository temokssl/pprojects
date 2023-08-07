package main.java.PO;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import main.java.models.TestDTO;
import main.java.setupdata.TestData;
import tests.BaseTest;

public class AllTestsPage extends Form {

	private By namesColumnLocator = By.cssSelector("td a:not([href^='history'])");
	private By startDateColumnLocator = By.cssSelector("table tr td:nth-child(4)");
	private ILabel newTestAdded = AqualityServices.getElementFactory().getLabel(By.cssSelector("td a:not([href^='history'])"), "New test added label");
	private List<ILabel> namesColumnElements = getColumn(namesColumnLocator);
	private List<ILabel> startDateColumnElements = getColumn(startDateColumnLocator);

	public AllTestsPage() {
		super(By.xpath("//li[contains(., '"+TestData.projectName+"')]"),"All tests page Indicator");
	}
	
	private List<ILabel> getColumn(By locator) {
		AqualityServices.getElementFactory().getLabel(locator,"Element").state().waitForDisplayed();
		return AqualityServices.getElementFactory().findElements(locator,ILabel.class);
	}
	
	public List<TestDTO> getTestsPageList() {
		BaseTest.logger.info("Getting tests from page....");
		List<TestDTO> tableDtoList = new ArrayList<>();
		for(int i=0;i<namesColumnElements.size();i++) {
			TestDTO testDTO = new TestDTO();
			testDTO.setName(namesColumnElements.get(i).getText());
			testDTO.setStartTime(startDateColumnElements.get(i).getText());
			tableDtoList.add(testDTO);
		}
		return tableDtoList;
	}
	
	public List<String> getStartDateTimeInSeconds(){
		List<String> startTimeList = new ArrayList<>();
		for(int i=0;i<startDateColumnElements.size();i++) {
			String startTime = startDateColumnElements.get(i).getText();
			int spaceIndex = startTime.indexOf(' ');
			startTimeList.add(startTime.substring(spaceIndex));
		}
		return startTimeList;
	}

	public boolean isNewTestAdded() {
		return newTestAdded.state().waitForDisplayed();
	}
	
}