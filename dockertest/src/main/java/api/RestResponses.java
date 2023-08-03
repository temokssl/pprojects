package main.java.api;

import java.util.UUID;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import main.java.Utilities.EncodingUtil;
import main.java.Utilities.TimeUtil;
import main.java.setupdata.ConfigData;
import main.java.setupdata.TestData;
import tests.BaseTest;

public class RestResponses {
	
	private static String attachmentType = "image/jpg";
	private static String browserName = BaseTest.browser.getBrowserName().toString();
	private static String startTime = TimeUtil.getStartTime();
	private static String machineHostname = System.getProperty("user.name");
	private static String sessionId = UUID.randomUUID().toString();
	private static String encodedImage = EncodingUtil.getBase64EncodedImage(TestData.imagePath);
	
	public static HttpResponse<String> getAccessToken() {
		BaseTest.logger.info("Getting access token variant: "+TestData.variant);
		return Unirest.post(ConfigData.accessTokenUri).header("accept", "application/json").header("Content-Type","application/json").queryString("variant",TestData.variant).asString();
	}
	
	public static HttpResponse<JsonNode> getJSONTestsList(){
		BaseTest.logger.info("Getting list of tests in JSON format");
		BaseTest.logger.info("Connecting to: "+ConfigData.jsonListOfTestsURI+" endpoint");
		return Unirest.post(ConfigData.jsonListOfTestsURI).header("accept", "application/json").header("Content-Type","application/json").queryString("projectId",1).asJson();
	}
	
	public static HttpResponse<String> postTest(String newProjectName){
		BaseTest.logger.info("Posting "+newProjectName+" project");
		BaseTest.logger.info("Connecting to: "+ConfigData.putUri+" endpoint");
		return Unirest.post(ConfigData.putUri).header("accept", "application/json").field("SID",sessionId).field("projectName",newProjectName).field("testName",TestData.newTestName).field("methodName",TestData.newMethodName).field("env",machineHostname)
				.field("startTime",startTime).field("browser",browserName).asString();
	}
	
	public static HttpResponse<String> postLog(String testId){
		BaseTest.logger.info("Posting log in "+testId+" project");
		BaseTest.logger.info("Connecting to: "+ConfigData.putLogUri+" endpoint");
		return Unirest.post(ConfigData.putLogUri).header("accept", "application/json").header("Content-Type","application/json").queryString("testId",testId).queryString("content",TestData.newLogMessage).asString();
	}	
	
	public static HttpResponse<String> postImage(String testId){
		BaseTest.logger.info("Posting attachment in "+testId+" project");
		BaseTest.logger.info("Connecting to: "+ConfigData.putAttachmentUri+" endpoint");
		return Unirest.post(ConfigData.putAttachmentUri).queryString("testId",testId).field("content",encodedImage).field("contentType",attachmentType).asString();
	}
	
}