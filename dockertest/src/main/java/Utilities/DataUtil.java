package main.java.Utilities;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;

import com.google.gson.Gson;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import kong.unirest.json.JSONArray;
import main.java.api.RestResponses;
import main.java.models.TestDTO;

public class DataUtil {
	
	public static List<ILabel> getColumn(By locator) {
		AqualityServices.getElementFactory().getLabel(locator,"Element").state().waitForDisplayed();
		return AqualityServices.getElementFactory().findElements(locator,ILabel.class);
		
	}
	
	public static List<TestDTO> getDtoTestTable(List<ILabel> namesColumnElements,List<ILabel> startDateColumnElements) {
		List<TestDTO> tableDtoList = new ArrayList<>();
		for(int i=0;i<namesColumnElements.size();i++) {
			TestDTO testDTO = new TestDTO();
			testDTO.setName(namesColumnElements.get(i).getText());
			testDTO.setStartTime(startDateColumnElements.get(i).getText());
			tableDtoList.add(testDTO);
		}
		return tableDtoList;
	}
	
	public static List<String> getStartDateTimeInSeconds(List<ILabel> startDateColumnElements){
		List<String> startTimeList = new ArrayList<>();
		for(int i=0;i<startDateColumnElements.size();i++) {
			String startTime = startDateColumnElements.get(i).getText();
			int spaceIndex = startTime.indexOf(' ');
			startTimeList.add(startTime.substring(spaceIndex));
		}
		return startTimeList;
	}
	
	public static List<TestDTO> getApiTestsAsJson(){
		JSONArray jsonTestsArray = RestResponses.getJSONTestsList().getBody().getArray();
		return Arrays.asList(new Gson().fromJson(jsonTestsArray.toString() ,TestDTO[].class ));
	}
	
}