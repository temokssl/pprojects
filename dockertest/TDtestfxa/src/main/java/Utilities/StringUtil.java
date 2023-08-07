package main.java.Utilities;

import org.apache.http.client.utils.URIBuilder;
import main.java.setupdata.ConfigData;

public class StringUtil {
	
	public static String getURI(String endpoint) {
		URIBuilder builder = new URIBuilder();
				builder
			    .setScheme(ConfigData.protocol)
			    .setHost(ConfigData.baseApi)
			    .setPath(endpoint);
				return  builder.toString();
	}
	
	public static String getAuthURL(String baseWeb,String username,String password) {
		return String.format("http://%s:%s@"+baseWeb,username,password);
	}
	
}