import java.util.Random;
import java.util.Scanner;

/*
 * Name: Guess
 * Description: Prompts the user to guess a number between 1-100 with hints
 * Author: Walker Christie
 */
public class Guess {
	public static void main(String[] args) {
		//Initialize required variables
		int guesses = 0;
		boolean guessed = false;
		int generatedNum = randomInt(1, 100); //Generate num from 1-100
		Scanner sc = new Scanner(System.in);
		
		//Prompt
		System.out.println("I'm thinking of a number between 1 and 100");
		System.out.println("Try and guess what it is");
	
		while (!guessed) {
			int guess = sc.nextInt(); //Get the next guess from Scanner
			guesses ++; //Increment each loop
			
			if (generatedNum > guess) { //If greater than guess
				System.out.println("Nope!  It's bigger than that");
			} if (generatedNum < guess) { //If less than guess
				System.out.println("Nope!  It's smaller than that");
			} if (generatedNum == guess) { //If equal to guess, we won
				System.out.println("You got it!  And it only took you " + guesses + " tries");
				guessed = true;
			}
		}
		
		sc.close(); //Close that Scanner, no memory leaks here!
	}
	
	public static int randomInt(int min, int max) {
		Random rand = new Random();
		
		//Generate random number between 1-100 using simple
		//Range arithmetic 
		return rand.nextInt((max - min) + 1) + min;
	}
}
