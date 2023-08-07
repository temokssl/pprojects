package main.java.setupdata;

import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestData {
	
	public static JsonSettingsFile testDataFile = new JsonSettingsFile("testdata.json");
	
	public static String username = testDataFile.getValue("/USERNAME").toString();
	public static String password = testDataFile.getValue("/PASSWORD").toString();
	public static String variant = testDataFile.getValue("/VARIANT").toString();
	public static String imagePath = testDataFile.getValue("/IMAGE_PATH").toString();
	public static String newTestName = testDataFile.getValue("/NEW_TEST_NAME").toString();
	public static String newMethodName = testDataFile.getValue("/NEW_METHOD_NAME").toString();
	public static String projectName = testDataFile.getValue("/PROJECT_NAME").toString();
	public static String newLogMessage = testDataFile.getValue("/NEW_LOG_MESSAGE").toString();
	public static int charactersRange = Integer.parseInt(testDataFile.getValue("/CHARS_RANGE").toString());
	
}
