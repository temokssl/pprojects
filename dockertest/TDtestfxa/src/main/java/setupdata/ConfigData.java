package main.java.setupdata;

import aquality.selenium.core.utilities.JsonSettingsFile;
import main.java.Utilities.StringUtil;

public class ConfigData {
	
	public static JsonSettingsFile configurationFile = new JsonSettingsFile("config.json");
	public static String baseWeb = configurationFile.getValue("/BASE_WEB").toString();
	
	public static String putEndpoint = configurationFile.getValue("/PUT_ENDPOINT").toString();
	public static String putLogEndpoint = configurationFile.getValue("/PUT_LOG_ENDPOINT").toString();
	public static String putAttachmentEndpoint = configurationFile.getValue("/PUT_ATTACHMENT_ENDPOINT").toString();
	public static String protocol = configurationFile.getValue("/PROTOCOL").toString();
	public static String baseApi = configurationFile.getValue("/BASE_API").toString();
	public static String cookieName = configurationFile.getValue("/COOKIE_NAME").toString();	
	public static String jsonTestsListEndpoint = configurationFile.getValue("/JSON_TESTS_LIST_ENDPOINT").toString();
	public static String accessTokenEndpoint= ConfigData.configurationFile.getValue("/ACCESS_TOKEN_ENDPOINT").toString();
	public static String putUri = StringUtil.getURI(putEndpoint);
	public static String putLogUri = StringUtil.getURI(putLogEndpoint);
	public static String putAttachmentUri = StringUtil.getURI(putAttachmentEndpoint);
	public static String jsonListOfTestsURI = StringUtil.getURI(jsonTestsListEndpoint);
	public static String accessTokenUri = StringUtil.getURI(accessTokenEndpoint);
	
}