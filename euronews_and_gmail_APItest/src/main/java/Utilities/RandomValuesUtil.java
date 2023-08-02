package main.java.Utilities;

import java.util.Random;

public class RandomValuesUtil {

	private static Random random = new Random();
	public static int getRandomNumber(int minimumLimit,int maximumLimit) {
		return random.nextInt(minimumLimit,maximumLimit-1);
	}
}
