/*LuckySevens.java
Simulate the game of lucky sevens until all funds are depleted.
1) Rules:
        roll two dice
        if the sum equals 7, win $4, else lose $1
2) The inputs are:
        the amount of money the user is prepared to lose 
3) Computations:
        use the random number generator to simulate rolling the dice
        loop until the funds are depleted 
        count the number of rolls
        keep track of the maximum amount
4) The outputs are:
        the number of rolls it takes to deplete the funds
        the maximum amount 
 */

import java.util.Scanner;
import java.util.Random;

public class LuckySevens {
	public static void main (String [] args) {

		Scanner reader = new Scanner(System.in);
		Random generator = new Random();

		int die1, die2,       // two dice
		dollars,          // initial number of dollars (input)
		rolls,       	  // how many rolls to go bankrupt
		originalCash;     //What was the original dollar amt?
		
		// Request the input
		System.out.print("How many dollars do you have? ");
		dollars = reader.nextInt();
		
		// Initialize variables
		rolls = 0;
		originalCash = dollars;
		
		//Run simulation 100 times
		for (int i = 0; i < 100; i ++) {
			dollars = originalCash; // Reset Dollars
			// Loop until the money is gone
			while (dollars > 0){
				// Roll the dice.
				die1 = generator.nextInt (6) + 1; // 1-6 
				die2 = generator.nextInt (6) + 1; // 1-6

				// Calculate the winnings or losses
				if (die1 + die2 == 7) {
					dollars += 4;
				} else
					dollars --;
				rolls ++;
			}
		}
		
		System.out.println("It took you an average of " + rolls / 100 + " rolls to be come bankrupt");
	}
}