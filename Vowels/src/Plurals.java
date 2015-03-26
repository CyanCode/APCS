/*
 * Author: Walker Christie
 * Description: Vowels R Us Reloaded
 */

public class Plurals {
	String text;
	
	public Plurals(String text) {
		this.text = text;
	}
	
	/**
	 * Drops the final letter, adds "G"
	 * @return Manipulated word
	 */
	public String dropAdd() {
		StringBuilder builder = new StringBuilder(text); 
		builder.deleteCharAt(text.length() - 1); //Delete last char
		
		return builder.toString() + "G"; //Append G
	}
	
	/**
	 * Doubles the last letter and adds "H"
	 * @return Manipulated word
	 */
	public String doubleAdd() {
		char last = text.charAt(text.length());
		text += last + "H"; //Append last char + "H"
		
		return text;
	}
}
