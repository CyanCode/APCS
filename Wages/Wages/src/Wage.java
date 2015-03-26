/*
 * Name: Walker Christie
 * Date: 10/20/14
 * Description: Calculates wage for overtime and regular hours
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Wage {
	//Declare ArrayLists for easy index adding / hourlyWage variable(s)
	ArrayList<Double> regularHours = new ArrayList<Double>();
	ArrayList<Double> overtimeHours = new ArrayList<Double>();
	double hourlyWage;
	
	public static void main(String[] args) {
		Wage wage = new Wage(); //Initialize new instance of this class
		
		//Prompt user and calculate pay
		wage.promptUser();
		double totalPay = wage.calculateTotalPay();
		
		//Print calculated pay
		System.out.println("Your total pay for the last five days is " + totalPay);
	}
	
	public void promptUser() {
		Scanner sc = new Scanner(System.in); //Create new Scanner instance
		
		//Prompt user for hourly wage
		System.out.println("Enter your hourly wage");
		hourlyWage = sc.nextDouble();
		sc.nextLine(); //Clears \n still in buffer
		
		//Prompt user for regular hours worked
		System.out.println("Enter your regular hours for the last five days");
		System.out.println("Enter hours seperated by a space, like so: '10 10.4 ...'");
		String regular = sc.nextLine();
		
		//Prompt user for overtime hours worked
		System.out.println("Enter your overtime hours for the last five days");
		System.out.println("Enter hours seperated by a space, like so: '10 10.4 ...'");
		String overtime = sc.nextLine();
		
		//Call (private) fillHours method to fill ArrayLists
		fillHours(regular, overtime);
		
		sc.close(); //Close Scanner, avoid memory leaks
	}
	
	public double calculateTotalPay() {
		double totalPay = 0;
		
		//total-pay = total-pay + (hourly-wage X regular-wage)
		for (double regular : regularHours) {
			totalPay += hourlyWage * regular;
		}
		
		//total-pay = total-pay + (overtime (hourly-wage X 1.5))
		for (double overtime : overtimeHours) {
			totalPay += overtime * (hourlyWage * 1.5);
		}
		
		return totalPay;
	}
	
	private void fillHours(String regular, String overtime) {
		//Create (and fill) String arrays with String split with blank spaces
		String[] regularArr = regular.split(" ");
		String[] overtimeArr = overtime.split(" ");
		
		//Loop through String in arrays, adding a double (from said array) to ArrayList
		for (String s : regularArr) {
			regularHours.add(new Double(Double.parseDouble(s)));
		}
		
		//Repeat above instruction with overtime values
		for (String s : overtimeArr) {
			overtimeHours.add(new Double(Double.parseDouble(s)));
		}
	}
}
