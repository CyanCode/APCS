
public class QuickSort extends Sortable {
	Student[] data;
	
	public QuickSort(Student[] data) {
		super(data);
		
		this.data = data;
	}
	
	/**
	 * Uses quick sort to sort the initialized data
	 * @param lowIndex The lowest index to sort
	 * @param highIndex The highest index to sort
	 * @return The sorted array (this.data)
	 */
	public void sort(int lowIndex, int highIndex) {
		int i = lowIndex;
		int j = highIndex;
		Student pivot = data[lowIndex + (highIndex - lowIndex) / 2]; //Pivot is the center element
		
		while (i <= j) { //Divide into two seperated arrays
			/*
			 * We will find numbers on either side of the pivot point
			 * 1. Numbers on the left which are greater than the pivot
			 * 2. Numbers on the right which are less than the pivot
			 */
			while (data[i].score < pivot.score) 
				i ++;
			while (data[j].score > pivot.score)
				j --;
			
			if (i <= j) { //If so, exchange numbers
				exchangeValues(i, j);
				i ++;
				j --;
			}
		}
		
		//Recursion!  Call sort() until everything is sorted
		if (lowIndex < j)
			sort(lowIndex, j);
		if (i < highIndex)
			sort(i, highIndex);
	}
	
	/**
	 * Swap both passed indexes inside the data array
	 * @param i index 1 to swap
	 * @param j index 2 to swap
	 */
	private void exchangeValues(int i, int j) {
		Student temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
