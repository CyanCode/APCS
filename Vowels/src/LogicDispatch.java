/*
 * Author: Walker Christie
 * Description: Vowels R Us Reloaded
 */

public class LogicDispatch {
	WordReader reader;
	
	public LogicDispatch() {
		reader = new WordReader();
		reader.readFile();
	}
	
	public void dispatchWords() {
		//Get arrays from our reader
		String[] words = reader.words;
		String[] suffixes = reader.suffixes;
		
		for (int i = 0; i < words.length; i ++) {
			//Initialize calculators for word and suffix
			TextCalculator word = new TextCalculator(words[i]);
			TextCalculator suffix = new TextCalculator(suffixes[i]);
			
			//First, plurals
			this.pluralCalculator(word.text);
			
			if (suffix.beginVowel()) //Calculate vowel suffixes
				this.vowelSuffixCalculator(word.text, suffix.text);
			else //Calculate consonant suffixes
				this.consonantSuffixCalculator(word.text, suffix.text);
		}
	}
	
	private void pluralCalculator(String word) {
		//Initialize TextCalculator and Plurals
		TextCalculator calc = new TextCalculator(word);
		Plurals plurals = new Plurals(word);
		String plural;
		
		//Fill plural variable with information
		if (calc.endsInConsonant())
			plural = word + "GH";
		else if (calc.endsInVowel())
			plural = plurals.dropAdd();
		else if (calc.twoConsonants() || calc.twoVowels()) //If ends in two consonants or vowels
			plural = plurals.doubleAdd();
		else
			plural = word;
		
		System.out.println("The plural of " + word + " is: " + plural);
	}
	
	private void consonantSuffixCalculator(String word, String suffix) {
		//Initialize TextCalculator and ConsonantSuffix
		TextCalculator calc = new TextCalculator(word);
		ConsonantSuffix suff = new ConsonantSuffix(suffix);
		String full;
		
		//Create a full String from manipulation
		if (calc.endsInConsonant())
			full = word + suffix;
		else if (calc.endsInVowel())
			full = word + suff.appendFirstLetter();
		else if (calc.twoConsonants() || calc.twoVowels()) //If ends in two consonants or vowels
			full = suff.dropLastAddSuffix(word);
		else
			full = word + suffix;
		
		System.out.println("The full form of " + word + " is: " + full);
	}
	
	private void vowelSuffixCalculator(String word, String suffix) {
		//Initialize TextCalculator and VowelSuffix
		TextCalculator calc = new TextCalculator(word);
		VowelSuffix suff = new VowelSuffix(suffix);
		String full;
		
		//Create full word from String manipulation
		if (calc.endsInConsonant())
			full = word + suffix;
		else if (calc.endsInVowel())
			full = suff.dropAppend(word);
		else if (calc.twoConsonants() || calc.twoVowels()) //If ends in two consonants or vowels
			full = suff.addFirst(word);
		else
			full = word + suffix;
		
		System.out.println("The full form of " + word + " is: " + full);
	}
}
