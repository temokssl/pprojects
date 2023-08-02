package main.java.utilities;

import java.util.Random;

public class RandomUtil {

	private static Random random = new Random();
	
	private static char getRandomAlphabeticCharacter(int alphabeticCharacterRangeSize) {
		return (char)(random.nextInt(alphabeticCharacterRangeSize) + 'a');
	}
	public static String getRandomString(int stringLength,int alphabeticRangeSize) {
		char randomChar;
		StringBuilder string = new StringBuilder();
		
		for(int i=0;i<stringLength;i++) {
			randomChar = getRandomAlphabeticCharacter(alphabeticRangeSize);
			string.append(randomChar);
		}
		String finalString = string.toString();		
		return finalString;
	}
}