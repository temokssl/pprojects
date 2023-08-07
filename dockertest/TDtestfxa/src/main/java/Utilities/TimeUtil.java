package main.java.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	
	public static double convertToSeconds(String time) {
	    String[] parts = time.trim().split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        double seconds = Double.parseDouble(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }
	
	public static String getStartTime() {
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
	}
	
}