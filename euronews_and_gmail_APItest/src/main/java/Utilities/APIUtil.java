package main.java.Utilities;

import aquality.selenium.browser.AqualityServices;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class APIUtil {

	public static HttpResponse<JsonNode> get(String API,String ACCESS_TOKEN) {
		AqualityServices.getLogger().info("Sending GET Request..");
		return Unirest.get(API).header("accept", "application/json").header("Authorization","Bearer "+ACCESS_TOKEN).asJson();
	}
	public static HttpResponse<JsonNode> post(String API, String desiredBody,String ACCESS_TOKEN) {
		AqualityServices.getLogger().info("Sending POST request..");
		return Unirest.post(API)
        .header("accept", "application/json")
        .header("Content-Type", "application/json")
        .header("Authorization","Bearer "+ACCESS_TOKEN)
        .body(desiredBody)
        .asJson();
	}
}