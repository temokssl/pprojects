package main.java.Utilities;

import org.apache.http.client.utils.URIBuilder;

import test.BaseTest;

public class URLUtil {
	
	private static String PROTOCOL = BaseTest.configurationFile.getValue("/PROTOCOL").toString();
	private static String BASE_API = BaseTest.configurationFile.getValue("/BASE_API").toString();
	private static URIBuilder builder = new URIBuilder();
	
	public static String getURL(String ENDPOINT,String QUERY_PARAM,String QUERY_VALUE) {
				builder
			    .setScheme(PROTOCOL)
			    .setHost(BASE_API)
			    .setPath(ENDPOINT)
			    .addParameter(QUERY_PARAM, QUERY_VALUE);
			return  builder.toString();
	}
}
