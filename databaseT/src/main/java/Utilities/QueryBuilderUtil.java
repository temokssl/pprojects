package main.java.Utilities;

import java.util.List;

public class QueryBuilderUtil {

	private static StringBuilder stringBuilder = new StringBuilder();
	public static String getInRangeQueryQuote(String baseQuery,List<Integer> testsIds) {
		stringBuilder.append(baseQuery);
		stringBuilder.append(" (");
		for(int i=0;i<testsIds.size();i++) {
			if(i!=(testsIds.size()-1)) {
				stringBuilder.append(testsIds.get(i)+",");
			}
			else {
				stringBuilder.append(testsIds.get(i)+");");
			}
		}
		return stringBuilder.toString();
	}
	public static <T> String getSimpleQueryQuote(String baseQuery,T value1,T value2) {
		String quote;
		if(value2 != null) {
			quote = String.format(baseQuery,value1,value2);
		}
		else {
			quote = String.format(baseQuery,value1);
		}
		return quote;
	}
}