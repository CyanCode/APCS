/*
 * Author: Walker Christie
 * Description: Vowels R Us Reloaded
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class WordReader {
	String[] words;
	String[] suffixes;
	
	/**
	 * Reads from vowels file and populates 'words' and 'suffixes' arrays
	 */
	public void readFile() {
		File file = new File("vowels.txt"); //Refer to the vowels file
		try {
			//Create words and suffixes arrays
			//Instantiate BufferedReader with vowels.txt
			ArrayList<String> words = new ArrayList<String>();
			ArrayList<String> suffixes = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			//While another line exists in the file
			while ((line = reader.readLine()) != null) {
				String[] full = line.split(" "); //Split each line by a space
				//Add word and suffixes to arrays
				words.add(full[0]);
				suffixes.add(full[1]);
			}

			//Convert to primitive array
			this.words = words.toArray(new String[words.size()]);
			this.suffixes = words.toArray(new String[suffixes.size()]);
			reader.close(); //Close BR
		} catch (Exception e) {
			System.out.println("Error reading file: " + e); //If an error should occur
		}
	}
}
