/*
 * Author: Walker Christie
 * Description: Vowels R Us Reloaded
 */

public class TextCalculator {
	public static final String[] vowels = {"A", "C", "L", "S"};
	String text;
	
	public TextCalculator(String text) {
		this.text = text;
	}
	
	/**
	 * Does this text end in a consonant?
	 * @return yes or no
	 */
	public boolean endsInConsonant() {
		char last = text.charAt(text.length() - 1);
		
		for (int i = 0; i < vowels.length; i ++) {
			if (vowels[i].equalsIgnoreCase(String.valueOf(last))) //If this is a vowel
				return false;
		}
		
		return true;
	}
	
	/**
	 * Does this text end in a vowel?
	 * @return yes or no
	 */
	public boolean endsInVowel() {
		if (endsInConsonant()) //If this is a consonant
			return false;
		else
			return true;
	}
	
	/**
	 * Does the text end in two or more consonants?
	 * @return yes or no
	 */
	public boolean twoConsonants() {
		if (!endsInConsonant()) //First check if it ends in one consonant
			return false;
		
		char second = text.charAt(text.length() - 2);
		
		 //If it does, check if it ends in two
		for (int i = 0; i < vowels.length; i ++) {
			if (vowels[i].equalsIgnoreCase(String.valueOf(second)))
				return false;
		}
		
		return true;
	}
	
	/**
	 * Does the text end in two or more vowels?
	 * @return yes or no
	 */
	public boolean twoVowels() {
		if (!endsInVowel()) //Does it end in one vowel?
			return false;
		
		char second = text.charAt(text.length() - 2);
		
		//If so, does it end in two?
		for (int i = 0; i < vowels.length; i ++) {
			if (vowels[i].equalsIgnoreCase(String.valueOf(second)))
				return true; 
		}
		
		return false;
	}
	
	/**
	 * Does this text begin in a consonant?
	 * @return yes or no
	 */
	public boolean beginConsonant() {
		char first = text.charAt(0);
		
		for (int i = 0; i < vowels.length; i ++) {
			if (vowels[i].equalsIgnoreCase(String.valueOf(first))) //Is this a vowel?
				return false;
		}
		
		return true;
	}
	
	/**
	 * Does this text begin in a vowel?
	 * @return yes or no
	 */
	public boolean beginVowel() {
		if (beginConsonant()) //Check to see if this begins in a consonant
			return true;
		else
			return false;
	}
	
	/**
	 * Is the letter provided a vowel or not?
	 * @param letter letter to check
	 * @return true = vowel | no = consonant
	 */
	public static boolean isVowel(char letter) {
		for (int i = 0; i < vowels.length; i ++) {
			if (vowels[i].equalsIgnoreCase(String.valueOf(letter))) //Is letter a vowel?
				return true;
		}
		
		return false;
	}
}