package main.java.Utilities;

import java.util.List;

import main.java.models.TestDTO;

public class ComparisonUtil {
	
	public static boolean checkDescendingOrderOfDateTime(List<String> startTimeList) {
		for(int i=1;i<startTimeList.size();i++) {
			double seconds1 = TimeUtil.convertToSeconds(startTimeList.get(i-1));
			double seconds2 = TimeUtil.convertToSeconds(startTimeList.get(i));
			if(seconds1<seconds2) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean compareTwoDtoTestsLists(List<TestDTO> jsonTestsList,List<TestDTO> pageTestsList) {
		Integer randomTest = RandomUtil.getRandomNumber(0,pageTestsList.size()-1);
		for(int i=0;i<jsonTestsList.size();i++) {
			if(jsonTestsList.get(i).getName().equals(pageTestsList.get(randomTest).getName())) {
				if(jsonTestsList.get(i).getStartTime().equals(pageTestsList.get(randomTest).getStartTime())) {
					return true;
				}
			}
		}
		return false;
	}
	
}
