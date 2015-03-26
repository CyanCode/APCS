/*
 * Author: Walker Christie
 * Description: Vowels R Us Reloaded
 */
public class ConsonantSuffix {
	String suffix;
	
	/**
	 * Creates instance suffix
	 * @param suffix Suffix you would like to use
	 */
	public ConsonantSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	/**
	 * Adds the word and suffix together
	 * @param Word Word you would like to add
	 * @return Combined word and suffix
	 */
	public String addSuffix(String word) {
		return word + suffix;
	}
	
	/**
	 * Appends the first letter of the suffix to the suffix
	 * @return Manipulated suffix
	 */
	public String appendFirstLetter() {
		char first = suffix.charAt(0); //Get first letter
		return first + suffix;
	}
	
	/**
	 * Drops the left most String in the pair, combines with word and suffix
	 * @param word Current word
	 * @param pair Pair of vowels or consonants
	 * @return Manipulated word
	 */
	public String dropLeftAppend(String word, String pair) {
		char first = pair.charAt(0); //Get first letter
		return word + first + suffix;
	}
	
	/**
	 * Drops the leftmost letter of the sequence and adds the suffix
	 * @param word Word to be manipulated
	 * @return Manipulated word
	 */
	public String dropLastAddSuffix(String word) {
		TextCalculator calc = new TextCalculator(word); //Instantiate text calc
		int loc;
		
		if (calc.twoConsonants()) //If there are two consonants
			loc = consonantFinder(word); //Set index
		else
			loc = vowelFinder(word); //Set index
		
		String sub = word.substring(loc, word.length()); //substring of last group
		String dropped = new StringBuilder(sub).deleteCharAt(0).toString(); //Delete groups first char
		word = new StringBuilder(word).delete(loc, word.length()).toString(); //Delete unused part of word
		
		return word + dropped + suffix; //Add word, dropped text, and suffix
	}
	
	private int consonantFinder(String word) {
		String flipped = new StringBuilder(word).reverse().toString(); //Reverse the word for easy looping
		
		for (int i = 0; i < flipped.length(); i ++) {
			boolean isVowel = TextCalculator.isVowel(flipped.charAt(i)); 
			if (isVowel) //If this character is a vowel
				return flipped.length() - i; //Return the index
		}
		
		return flipped.length();
	}
	
	private int vowelFinder(String word) {
		String flipped = new StringBuilder(word).reverse().toString(); //Reverse the word for easy looping
		
		for (int i = 0; i < flipped.length(); i ++) {
			boolean isVowel = TextCalculator.isVowel(flipped.charAt(i));
			if (!isVowel) //If this character is not a vowel
				return flipped.length() - i; //Return the index
		}
		
		return flipped.length();
	}
}