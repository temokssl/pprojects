package main.java.setupdata;

import aquality.selenium.core.utilities.JsonSettingsFile;
import main.java.Utilities.StringUtil;

public class ConfigData {
	
	public static JsonSettingsFile configurationFile = new JsonSettingsFile("config.json");
	public static String baseWeb = configurationFile.getValue("/BASE_WEB").toString();
	
	public static String putEndpoint = ConfigData.configurationFile.getValue("/PUT_ENDPOINT").toString();
	public static String putLogEndpoint = ConfigData.configurationFile.getValue("/PUT_LOG_ENDPOINT").toString();
	public static String putAttachmentEndpoint = ConfigData.configurationFile.getValue("/PUT_ATTACHMENT_ENDPOINT").toString();
	public static String putUri = StringUtil.getURI(putEndpoint);
	public static String putLogUri = StringUtil.getURI(putLogEndpoint);
	public static String putAttachmentUri = StringUtil.getURI(putAttachmentEndpoint);
	public static String jsonTestsListEndpoint = ConfigData.configurationFile.getValue("/JSON_TESTS_LIST_ENDPOINT").toString();
	public static String jsonListOfTestsURI = StringUtil.getURI(jsonTestsListEndpoint);
	public static String accessTokenEndpoint= ConfigData.configurationFile.getValue("/ACCESS_TOKEN_ENDPOINT").toString();
	public static String accessTokenUri = StringUtil.getURI(accessTokenEndpoint);
	public static String cookieName = ConfigData.configurationFile.getValue("/COOKIE_NAME").toString();	
}
