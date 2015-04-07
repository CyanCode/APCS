
public class Sortable {
	private Student[] students;
	private long time;
	
	public Sortable(Student[] students) {
		this.students = students;
	}
	
	/** Prints the student test scores */
	public void printTestScores() {
		System.out.println("Student Id | Test Score");
		
		for (int i = 0; i < students.length; i ++)
			System.out.println(students[i].getId() + " | " + students[i].score);
	}
	
	/** Starts an algorithm timer, stopped by the stopPrintTime() method */
	public void startTime() {
		time = System.currentTimeMillis();
	}
	
	/** Stops the timer and prints the timer's value */
	public void stopPrintTime() {
		System.out.println("Processing Time: " + (System.currentTimeMillis() - time) + "ms");
	}
}
