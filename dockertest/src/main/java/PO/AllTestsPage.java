package main.java.PO;

import java.util.List;

import org.openqa.selenium.By;

import aquality.selenium.forms.Form;
import aquality.selenium.elements.interfaces.ILabel;
import main.java.Utilities.ComparisonUtil;
import main.java.Utilities.DataUtil;
import main.java.models.TestDTO;
import main.java.setupdata.TestData;

public class AllTestsPage extends Form {

	private By namesColumnLocator = By.cssSelector("td a:not([href^='history'])");
	private By startDateColumnLocator = By.cssSelector("table tr td:nth-child(4)");
	
	List<ILabel> namesColumnElements = DataUtil.getColumn(namesColumnLocator);
	List<ILabel> startDateColumnElements = DataUtil.getColumn(startDateColumnLocator);
	List<String> startTimeListInSeconds = DataUtil.getStartDateTimeInSeconds(startDateColumnElements);
	
	List<TestDTO> dtoTestPageList = DataUtil.getDtoTestTable(namesColumnElements, startDateColumnElements);
	List<TestDTO> jsonTestsList = DataUtil.getApiTestsAsJson();

	public AllTestsPage() {
		super(By.xpath("//li[contains(., '"+TestData.projectName+"')]"),"All tests page Indicator");
	}
	
	public boolean isSorted() {
		return ComparisonUtil.checkDescendingOrderOfDateTime(startTimeListInSeconds);
	}
	
	public boolean pageTestsEqualToApis() {
		return ComparisonUtil.compareTwoDtoTestsLists(jsonTestsList, dtoTestPageList);
	}
	
}
