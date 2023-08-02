package main.java.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

import aquality.selenium.browser.AqualityServices;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

public class JSONUtil {
	
	private static Gson gson = new Gson();
	
	public static boolean isItJson(HttpResponse<JsonNode> file) { 
		AqualityServices.getLogger().info("Checking whether the list in response body is json...");
		return file.getHeaders().getFirst("Content-type").toString().contains("application/json");
	}
	public static <T> T getObjectFromJsonFile(String jsonFile,Class<T> classType) {
			AqualityServices.getLogger().info("Getting object from json file...");
			File thefile = new File(jsonFile);
			try {
				FileReader fileReader = new FileReader(thefile);
				T userModel2 = gson.fromJson(fileReader, classType);
				return userModel2;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
	}
}