package main.java.Utilities;

import java.util.List;

import aquality.selenium.core.utilities.JsonSettingsFile;



public class LoginDataUtil {
	
	private static StringBuilder string = new StringBuilder();
	private static JsonSettingsFile testData = new JsonSettingsFile("testdata.json");
	private static String CYRILIC_CHARS = "аозимфшэяйждгвбаозимфшэяйждгвб";
	private static int MINIMUM_VALID_INDEX = 0;
	
	
	public static String getEmail(int emailLength,int alphabeticCharacterRangeSize) {
        
		char randomChar;
        
		for(int i=0;i<emailLength;i++) {
			randomChar = RandomValuesUtil.getRandomAlphabeticCharacter(alphabeticCharacterRangeSize);
			string.append(randomChar);
		}
		String finalEmail = string.toString();		
		return finalEmail;
	}
	
	public static String getPassword(String email,int alphabeticCharacterRangeSize,int numberOfAlphabeticChars,int numberOfCyrilicChars,int rangeOfIntegers) {
		
		int i;
		int emailLength = email.length();
		int randomIndex = RandomValuesUtil.getRandomNumber(MINIMUM_VALID_INDEX,emailLength);
		int cyrilicCharsRandomIndex;
		String randomCharOfEmail = Character.toString(email.charAt(randomIndex));
		int cyrilicCharsLength = CYRILIC_CHARS.length();
        
        for(i=0;i<numberOfCyrilicChars;i++) {
        	cyrilicCharsRandomIndex = RandomValuesUtil.getRandomNumber(MINIMUM_VALID_INDEX,cyrilicCharsLength);
        	string.append(CYRILIC_CHARS.charAt(cyrilicCharsRandomIndex));
        }
        for(i=0;i<numberOfAlphabeticChars;i++) {
        	string.append(RandomValuesUtil.getRandomAlphabeticCharacter(alphabeticCharacterRangeSize));
        }
        
        string.append(Character.toString(RandomValuesUtil.getRandomAlphabeticCharacter(alphabeticCharacterRangeSize)).toUpperCase());
        string.append(RandomValuesUtil.getRandomNumber(MINIMUM_VALID_INDEX,rangeOfIntegers));
        string.append(randomCharOfEmail);
        String finalPassword = string.toString();    
        return finalPassword;
        
	}
	
	public static String getRandomElementOfAList(String targetList) {
		
		List<String> list = testData.getList("/"+targetList);
		int listSize = list.size();
		int randomIndex = RandomValuesUtil.getRandomNumber(MINIMUM_VALID_INDEX,listSize);
		return list.get(randomIndex);
	}
	
	
	
	
	
}
