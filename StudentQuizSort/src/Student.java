import java.util.*;


public class Student {
	private String id;
	private String [] quizresult=new String[10]; 
	public int score;
	public char letterGrade;

	/**
	 * Fills Student object with default values
	 */
	public Student(){
		id=" ";

		for(int i = 0; i < quizresult.length; i++){
			quizresult[i] = "";		
		}

		score = 0;
	}


	/**
	 * Standard constructor filling object with passed values
	 * @param a id for individual student
	 * @param answers what the student answered
	 */
	public Student(String a, String[] answers) {
		id = a;

		for(int i = 0; i < answers.length; i++){
			quizresult[i] = answers[i];
		}

		score = 0;
	}

	/**
	 * @return quiz answers
	 */
	public String [] getAnwers(){
		return quizresult;
	}

	/**
	 * @return student id
	 */
	public String getId(){
		return id;
	}

	/**
	 * Compares the answer key with the student's answers<br />
	 * Adds up the values based on right / wrong
	 * @param answerkey the answer key for given quiz
	 * @param studentanswer what the student answered
	 */
	public void grade(String [] answerkey, String[] studentanswer){
		int count=0;

		for(int i = 0; i < answerkey.length; i++){
			if(answerkey[i].equals(studentanswer[i])){
				count = count + 10;
			}
		}
		
		score = count;
		assignLetterGrade(score); //Assign letter grade also
	}

	/**
	 * Assigns a letter grade based on the passed numerical score
	 * @param score the score to convert
	 */
	public void assignLetterGrade(int score) {
		if (score >= 90)
			letterGrade = 'A';
		else if (score >= 80)
			letterGrade = 'B';
		else if (score >= 70)
			letterGrade = 'C';
		else if (score >= 50)
			letterGrade = 'D';
		else
			letterGrade = 'F';
	}
	
	/**
	 * @return String representation of student id, score, letter grade
	 */
	public String toString() {
		return "Student id: " + id + " " +  Arrays.toString(quizresult) + " The score for this quiz is:  " +  score + " Letter Grade: " + letterGrade + "\n";
	}
}