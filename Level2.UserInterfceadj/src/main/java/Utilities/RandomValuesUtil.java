package main.java.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomValuesUtil {

	
	private static Random random = new Random();
	private static int MINIMUM_VALID_INDEX = 0;
	
	
	public static int getRandomNumber(int minimumLimit,int maximumLimit) {
		return random.nextInt(minimumLimit,maximumLimit-1);
	}
	
	
	public static char getRandomAlphabeticCharacter(int alphabeticCharacterRangeSize) {
		return (char)(random.nextInt(alphabeticCharacterRangeSize) + 'a');
	}
	
	
	private static int getFunctionalCheckboxIndex(int numberOfElements,int nonFunctionalIndex1,int nonFunctionalIndex2) {
		
		int randomCheckboxIndex = getRandomNumber(MINIMUM_VALID_INDEX,numberOfElements);
		
		if(randomCheckboxIndex==nonFunctionalIndex1|| randomCheckboxIndex == nonFunctionalIndex2) {
			return getFunctionalCheckboxIndex(numberOfElements,nonFunctionalIndex1,nonFunctionalIndex2);
		}
		else {
			return randomCheckboxIndex;
		}
	}
	
	
	public static List<Integer> getListOfRandomCheckboxIndexes(int sizeOfCheckboxList,int numberOfInterests,int nonFunctionalIndex1,int nonFunctionalIndex2) {
		
		List<Integer> listOfCheckboxIndexes = new ArrayList<Integer>();
		int randomCheckboxIndex;
		
		while(listOfCheckboxIndexes.size()<numberOfInterests) {
			randomCheckboxIndex = getFunctionalCheckboxIndex(sizeOfCheckboxList,nonFunctionalIndex1,nonFunctionalIndex2);
			if(listOfCheckboxIndexes.contains(randomCheckboxIndex)) {
			}
			else {
				listOfCheckboxIndexes.add(randomCheckboxIndex);
			}
		}
		return listOfCheckboxIndexes;
	}
	
	
	
	
}
