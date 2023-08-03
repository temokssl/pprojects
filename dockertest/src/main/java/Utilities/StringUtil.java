package main.java.Utilities;

import org.apache.http.client.utils.URIBuilder;
import main.java.setupdata.ConfigData;

public class StringUtil {
	
	private static String protocol = ConfigData.configurationFile.getValue("/PROTOCOL").toString();
	private static String baseApi = ConfigData.configurationFile.getValue("/BASE_API").toString();
	private static URIBuilder builder = new URIBuilder();

	public static String getURI(String ENDPOINT) {
				builder
			    .setScheme(protocol)
			    .setHost(baseApi)
			    .setPath(ENDPOINT);
				return  builder.toString();
	}
	
	public static String getAuthURL(String BASE_WEB,String USERNAME,String PASSWORD) {
		return String.format("http://%s:%s@"+BASE_WEB,USERNAME,PASSWORD);
	}
	
}