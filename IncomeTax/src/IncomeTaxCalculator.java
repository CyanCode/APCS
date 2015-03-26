/*Case study 1: an income tax calculator
Compute a person's income tax.
1) Significant constants
       tax rate
       standard deduction
       deduction per dependent
2) The inputs are:
       gross income 
       number of dependents 
3) Computations:
       net income = gross income - the standard deduction - 
                    a deduction for each dependent 
       income tax = is a fixed percentage of the net income 
4) The outputs are:
       the income tax.
*/


import java.util.Scanner; //Import the Java Scanner

public class IncomeTaxCalculator{

   public static void main(String [] args){
	   int a =30;
	   int b = 6;
	   int c = 3;
	   
	   System.out.println(fun(a, b, c));
	System.out.println(fun2(a, b, c));
	System.out.println(fun3(a, b, c));
   }
   
   public static boolean fun(int a, int b, int c) {
	   if (a >= b) {
		   if (b >= c)
			   return true;
		   else
			   return false;

	   } else {
		   return false;
	   }
   }
   
   public static boolean fun2(int a, int b, int c) {
	   if (a >= b && b >= c) {
		   return true;
	   } else {
		   return false;
	   }
   }
   
   public static boolean fun3(int a, int b, int c) {
	   return a >= b || b >= c;
   }
}
