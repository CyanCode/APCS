import java.awt.List;
import java.util.ArrayList;

/**
 * This is a class that plays the GUI version of the Elevens game.
 * See accompanying documents for a description of how Elevens is played.
 */
public class ElevensGUIRunner {

	/**
	 * Plays the GUI version of Elevens.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
//		Board board = new ElevensBoard();
//		CardGameGUI gui = new CardGameGUI(board);
//		gui.displayGame();
		
		choose2(4,2);
	}
	
	public static int choose1(int n, int k) {
		System.out.println("called");
		if (k == 0)
			return 1;
		else
			return choose1(n, k - 1) * (n - k + 1) / k;
	}
	
	public static int choose2(int n, int k) {
		System.out.println("Called");
		if (k < 0 || k > n) {
			return 0;
		} else if (n == 0)
			return 1;
		else
			return choose2(n - 1, k - 1) + choose2(n - 1, k);
	}
	
	
}
