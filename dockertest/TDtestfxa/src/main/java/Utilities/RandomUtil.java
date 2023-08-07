package main.java.Utilities;

import java.util.Random;

public class RandomUtil {
	
	private static Random random = new Random();
	
	public static int getRandomNumber(int minimumLimit,int maximumLimit) {
		return random.nextInt(minimumLimit,maximumLimit);
	}
	
	private static char getRandomAlphabeticCharacter() {
		return (char)(random.nextInt(26) + 'a');
	}
	
	public static String getRandomString(int stringLength) {
		char randomChar;
		StringBuilder string = new StringBuilder();
		
		for(int i=0;i<stringLength;i++) {
			randomChar = getRandomAlphabeticCharacter();
			string.append(randomChar);
		}
		return string.toString();		
	}
	
}