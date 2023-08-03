package main.java.api;

import tests.BaseTest;
public class RestUtil {

	public static void addTestDataFromApi(String projectName) {
		BaseTest.logger.info("Adding test data,log and image from API....");
		String testId = RestResponses.postTest(projectName).getBody().toString();
		RestResponses.postLog(testId);
		RestResponses.postImage(testId);
	}
	
}