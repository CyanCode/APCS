import java.util.ArrayList;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Deck[] decks = deckGenerator();
		
		//For every deck in our generated deck array
		for (Deck deck : decks) {
			System.out.println("Empty: " + (deck.isEmpty() ? "Yes" : "No")); //Some ternary logic
			System.out.println("Deck size: " + deck.size() + "\n");
			System.out.println("Delt card rank: " + deck.deal().rank());
		}
	}

	public static Deck[] deckGenerator() {
		String[] rankTypes = new String[] {"Jack", "King", "Queen"};
		String[] suitTypes = new String[] {"Ace", "Diamonds", "Spades"};
		int[] valueTypes = new int[] {11, 12, 13};

		ArrayList<Deck> decks = new ArrayList<Deck>();

		//Create 3 decks
		for (int i = 0; i < 3; i ++) {
			String[] ranks = new String[3];
			String[] suits = new String[3];
			int[] values = new int[3];
			
			//Loop through card variables
			for (int j = 0; j < 3; j ++) {
				int index = 0 + (int)(Math.random() * 3); //Random number for deck
				ranks[j] = rankTypes[index];
				suits[j] = suitTypes[index];
				values[j] = valueTypes[index];
			}

			//Add decks to final array
			decks.add(new Deck(ranks, suits, values));
		}

		//convert to primitive array
		return decks.toArray(new Deck[decks.size()]);
	}
}
