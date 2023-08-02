package main.java.PO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.common.io.BaseEncoding;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import main.java.Utilities.APIUtil;
import main.java.Utilities.URLUtil;
import test.BaseTest;

public class EuronewsAPIPage{
	
	private static int FIRST_INDEX = 0;
	private static String HREF_ATTRIBUTE = "href";
	private static String MESSAGE_ID = "id";
	private static String MESSAGES_DATA = "messages";
	private static String PAYLOAD_DATA = "payload";
	private static String PARTS_DATA = "parts";
	private static String BODY_DATA = "body";
	private static String RAW_BODY_DATA = "data";
	private static String ACCESS_TOKEN = BaseTest.testDataFile.getValue("/ACCESS_TOKEN").toString();
	private static String SUBS_QUERY = BaseTest.testDataFile.getValue("/SUBS_QUERY").toString();
	private static String UNSUBS_QUERY = BaseTest.testDataFile.getValue("/UNSUBS_QUERY").toString();
	private static String QUERY_PARAM = BaseTest.testDataFile.getValue("/QUERY_PARAM").toString();
	private static String GET_MESSAGE_ENDPOINT = BaseTest.configurationFile.getValue("/GET_MESSAGE_ENDPOINT").toString();
	private static String MESSAGES_ENDPOINT = BaseTest.configurationFile.getValue("/MESSAGES_ENDPOINT").toString();
	private static String doesSubEmailExistUrl = URLUtil.getURL(MESSAGES_ENDPOINT, QUERY_PARAM, SUBS_QUERY);
	private static String doesUnsubEmailExistUrl = URLUtil.getURL(MESSAGES_ENDPOINT, QUERY_PARAM, UNSUBS_QUERY);
	
	public boolean doesSubEmailExist() {
		return APIUtil.get(doesSubEmailExistUrl, ACCESS_TOKEN).isSuccess();
	}
	
	public JSONArray getPieceOfResponseBody(String QUERY,String DATA) {
		return APIUtil.get(QUERY, ACCESS_TOKEN).getBody().getObject().getJSONArray(DATA);
	}
	
	public HttpResponse<JsonNode> getMessage(String QUERY){
		JSONArray messages = getPieceOfResponseBody(QUERY,MESSAGES_DATA);
		String messageId = (String) messages.getJSONObject(FIRST_INDEX).get(MESSAGE_ID);
		return APIUtil.get(GET_MESSAGE_ENDPOINT+messageId, ACCESS_TOKEN);
	}
	
	public String getRawBodyData(String QUERY) {
		JSONObject messageBody = getMessage(QUERY).getBody().getObject();
		JSONObject payLoadData = messageBody.getJSONObject(PAYLOAD_DATA);
		JSONArray partsData = payLoadData.getJSONArray(PARTS_DATA);
		JSONObject bodyDataObject = partsData.getJSONObject(FIRST_INDEX);
		return bodyDataObject.getJSONObject(BODY_DATA).getString(RAW_BODY_DATA);
	}
	
	public String getConfirmSubsLink() {
		String rawBody = getRawBodyData(doesSubEmailExistUrl);
		String fullReadableBody = new String(BaseEncoding.base64Url().decode(rawBody));
		Document document = Jsoup.parse(fullReadableBody);
		return document.select("a:contains(Confirm your email address)").attr(HREF_ATTRIBUTE);
	}
	
	public boolean doesUnsubEmailExist() {
		return APIUtil.get(doesUnsubEmailExistUrl, ACCESS_TOKEN).isSuccess();
	}
}