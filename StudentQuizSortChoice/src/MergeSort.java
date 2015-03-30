
public class MergeSort extends PrintValues {
	int[] data;
	private int[] tempMerge;
	
	public MergeSort(int[] data) {
		this.data = data;
		this.tempMerge = new int[data.length];
	}
	
	/**
	 * Sorts the initialized data array through the merge sort algorithm
	 * @param lowIndex Algorithm starting element
	 * @param highIndex Algorithm ending element
	 * @return The sorted array (this.data)
	 */
	public void sort(int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int middle = lowIndex + (highIndex - lowIndex) / 2; //Find center element
			
			//First merge left
			sort(lowIndex, middle);
			
			//Then merge right
			sort(middle + 1, highIndex);
			
			//Now merge individual sections
			mergeSection(lowIndex, middle, highIndex);
		}
	}
	
	/**
	 * Merges individual sections of the data array
	 * @param low Low index
	 * @param middle Middle index
	 * @param high High index
	 */
	private void mergeSection(int low, int middle, int high) {
		for (int i = low; i <= high; i ++) //Fill temp with data in range of low / high
			tempMerge[i] = data[i];
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while (i <= middle && j <= high) { //While the indexes are valid
			if (tempMerge[i] <= tempMerge[j]) { //Merge low
				data[k] = tempMerge[i];
				i ++;
			} else { //If not, merge high
				data[k] = tempMerge[j];
				j ++;
			}
			
			k ++; //Increment high
		}
		
		while (i <= middle) { 
			data[k] = tempMerge[i];
			k ++;
			i ++;
		}
	}
}
