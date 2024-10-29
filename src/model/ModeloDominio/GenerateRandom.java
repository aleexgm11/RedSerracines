package model.ModeloDominio;

import java.util.Random;

public class GenerateRandom {
	
	public static long getRandom() {
		
		Random r = new Random();
		
		long result = r.nextLong(1000) - 1;
		
		return result;
	}
	
}
