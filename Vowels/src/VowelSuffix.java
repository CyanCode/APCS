public class VowelSuffix {
	String suffix;
	
	public VowelSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	/**
	 * Adds the suffix to the word
	 * @param word Word to add suffix to
	 * @return full text
	 */
	public String addSuffix(String word) {
		return word + suffix;
	}
	
	/**
	 * Drops the first character of the suffix and appends it to the word
	 * @param word
	 * @return
	 */
	public String dropAppend(String word) {
		StringBuilder builder = new StringBuilder(suffix);
		return word + builder.deleteCharAt(0).toString(); //Delete first letter and add to the end of the word
	}
	
	/**
	 * Adds the first suffix letter to the beginning of the suffix
	 * @param word Word to add to
	 * @return Word and appended suffix
	 */
	public String addFirst(String word) {
		return word + suffix.charAt(0) + suffix; //Word + first letter suffix + suffix
	}
}