package main.java.utilities;

import aquality.selenium.browser.AqualityServices;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class APIUtil {
	
	public static HttpResponse<JsonNode> get(String API) {
		AqualityServices.getLogger().info("Sending GET Request..");
		return Unirest.get(API).header("accept", "application/json").asJson();
	}
	public static HttpResponse<JsonNode> post(String API, String desiredBody) {
		AqualityServices.getLogger().info("Sending POST request..");
		return Unirest.post(API)
        .header("accept", "application/json")
        .header("Content-Type", "application/json")
        .body(desiredBody)
        .asJson();
	}
}