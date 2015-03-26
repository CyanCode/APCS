import java.util.Random;
import java.util.Scanner;

/*
 * Name: Guess
 * Description: Computer tries to guess the user's secret number with high / low
 * Author: Walker Christie
 */
public class Guess {
	static int num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean guessed = false;
		int tries = 0;
		
		System.out.println("Enter a number between 1-100 and I'll try to guess it!");
		num = sc.nextInt();
		
		int max = 100, min = 1;
		while (!guessed) {
			int guess = randomInt(min, max);
			System.out.println("Range: " + min + " : " + max);
			System.out.println("Is it " + guess + "?");
			
			if (num > guess) {
				System.out.println("Guess not.. let's go higher");
				min = guess;
				tries ++;
			} if (num < guess) {
				System.out.println("Guess not.. let's go lower");
				max = guess;
				tries ++;
			} if (num == guess) {
				System.out.println("I got it!  And it only took me " + tries + " tries!");
				guessed = true;
			}
		}
		
		sc.close();
	}
	
	public static int randomInt(int min, int max) {
		Random rand = new Random();
		
		//Generate random number between 1-100 using simple
		//Range arithmetic 
		return rand.nextInt((max + 1) - min) + min;
	}
}
