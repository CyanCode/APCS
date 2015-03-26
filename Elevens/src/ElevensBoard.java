import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards.size() == 3) { //JQK can only be 3
			if (containsJQK(selectedCards))
				return true;
		}
		
		if (containsPairSum11(selectedCards)) //If a sum 11 pair exists
			return true;
		else
			return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		for (int i = 0; i < BOARD_SIZE; i ++) {
			for (int j = i + 1; j < BOARD_SIZE; j ++) { //elements add -> 11 at i || j?
				if (containsPairSum11(new ArrayList<Integer>(Collections.nCopies(i, j)))) {
					return true;
				}
			}
		} 
		
		//Check to see if there are any jacks, queens, or kings on the board
		boolean king = false;
		boolean queen = false;
		boolean jack = false;
		for (int i = 0; i < BOARD_SIZE; i ++) { //For every element on the board
			Card c = cardAt(i);
			switch (c.rank()) {
			case "jack": jack = true; 
			case "queen": queen = true; 
			case "king": king = true;
			}
		}
		
		if (jack && queen && king) //JQK exists?  Return accordingly
			return true;
		else
			return false;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		int numberAddition = 0;
		for (int i = 0; i < selectedCards.size(); i ++) {
			Card c = cardAt(selectedCards.get(i));
			
			if (this.isConvertible(c.rank())) {
				int value = Integer.valueOf(c.rank());
				numberAddition += value;
			}
		}
		
		if (numberAddition == 11)
			return true;
		else
			return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		boolean jackExists = false;
		boolean queenExists = false;
		boolean kingExists = false;

		for (int i = 0; i < selectedCards.size(); i ++) {
			Card c = cardAt(selectedCards.get(i));
			switch (c.rank()) {
			case "jack": jackExists = true; 
			case "queen": queenExists = true; 
			case "king": kingExists = true;
			}
		}
		
		if (jackExists && queenExists && kingExists)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if passed String can be converted to an int
	 * @param value String to check conversion
	 * @return boolean stating whether conversion is possible
	 */
	private boolean isConvertible(String value) {
		try {
			Integer.valueOf(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
