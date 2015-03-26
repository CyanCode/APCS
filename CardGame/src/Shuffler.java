import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 9;

	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 7;

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int k = 1; k <= SHUFFLE_COUNT; k ++) {
			list.add(new Integer(k));
		}
		
		for (int k = 0; k < SHUFFLE_COUNT; k ++) {
			Integer i = list.remove(k);
			list.add(i);
		}
		
		for (Integer i : list) {
			System.out.println(i);
		}
	}


	public static void myster(int[] data) {
		for (int k = 0; k < data.length - 1; k ++) {
			data[k + 1] = data[k] + data[k + 1];
		}
	}
	
	
	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int[] temporary = new int[values.length];
		int middleValue = (values.length + 1) / 2; //Get the middle through division
		
		int i = 0;
		int shuffle = 0;
		for ( ; i < middleValue; i ++) {
			temporary[shuffle] = values[i];
		}
		
		shuffle = 1; //Reset afterwards
		for ( ; i < values.length; i ++) {
			temporary[shuffle] = values[i];
			shuffle += 2; //Increment
		}
		
		for (int j = 0; j < values.length; j ++) //Copy
			values[j] = temporary[j];
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		for (int i = values.length - 1; i > 0; i --) {
			int random = (int) (Math.random() * (i + 1));
			int loc = random;
			int tempValue = values[loc];
			values[loc] = values[i];
			values[i] = tempValue;
		}
	}
}
