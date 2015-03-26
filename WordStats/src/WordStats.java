import java.util.Scanner;

/*
 * Name: WordStats
 * Description: Gathers statistics based on the user's sent sentence
 * Author: Walker Christie
 */
public class WordStats {
	public static void main(String[] args) {
		//Initialize Scanner and print prompt
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a sentence to gather stats about.");
		String sentence = sc.nextLine(); //Gather sentence from User
		
		//Trim the sentence, then split the sentence by spaces (into an array)
		sentence = sentence.trim();
		String[] words = sentence.split(" ");
		
		int average = 0;
		for (String word : words) { //For every word in the array "words"
			average += word.length(); //Calculate the length and add it to the average
		}
		
		System.out.println("There are " + words.length + " words in your sentence");
		//Find the mean by dividing the average by the length of the words array
		System.out.println("The words have an average of " + average / words.length + " characters each");
		System.out.println("Your sentence is " + sentence.length() + " characters long");
		
		sc.close(); //Close Scanner, no memory leaks here!
					//Which seems sort of silly, as the programs about to end anyways
					//Good practice though.
	}
}
