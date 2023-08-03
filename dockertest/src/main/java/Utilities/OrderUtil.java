package main.java.Utilities;

import java.util.List;

public class OrderUtil {
	
	public static boolean checkDescendingOrder(List<String> listToCheck) {
		for(int i=1;i<listToCheck.size();i++) {
			double seconds1 = TimeUtil.convertToSeconds(listToCheck.get(i-1));
			double seconds2 = TimeUtil.convertToSeconds(listToCheck.get(i));
			if(seconds1<seconds2) {
				return false;
			}
		}
		return true;
	}
	
}
