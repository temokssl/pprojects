package main.java.Utilities;

import java.util.Random;

public class RandomValuesUtil {
	
	private static int number;
	private static Random random = new Random();
	
	public static int getRandomNumber(int minimumLimit,int maximumLimit) {
		return random.nextInt(minimumLimit,maximumLimit);
	}
	public static int generateRepeatingNumbers() {
		
		int randomNumberOfDigits = getRandomNumber(2,4);
		int randomCase = getRandomNumber(1,3);
        int repeatingNumber = getRandomNumber(1, 9);
        int differentDigit = getRandomNumber(1, 9);
        
	    if(randomNumberOfDigits==2) {
	        number = repeatingNumber*10 + repeatingNumber;
	    }
	    else if(randomNumberOfDigits==3) {
	        	
	        do {
	            differentDigit = getRandomNumber(1, 9);
	        } while (differentDigit == repeatingNumber);
	            
	        if(randomCase==1) {
	            number = repeatingNumber * 100 + repeatingNumber * 10 + differentDigit;
	        }
	        else if(randomCase==2) {
	            number = repeatingNumber * 100 + differentDigit * 10 + repeatingNumber;
	         }
	         else{
	            number = differentDigit * 100 + repeatingNumber * 10 + repeatingNumber;
	         }
	    }
	    if(number<346) {
        	return number;
        }
        else {
        	return generateRepeatingNumbers();
        }   
   }
}