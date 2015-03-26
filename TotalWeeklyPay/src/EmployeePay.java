import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class EmployeePay{
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("VHSP35data1.txt"));
			String line = br.readLine();
			
			StringTokenizer token = new StringTokenizer(line);
			double totalRegular = 0;
			double totalOver = 0;
			
			String firstName = token.nextToken();
			String lastName = token.nextToken();
			
			double wage = Double.parseDouble(token.nextToken());
			
			totalRegular += Double.parseDouble(token.nextToken());
			totalOver += Double.parseDouble(token.nextToken());
			
			totalRegular += Double.parseDouble(token.nextToken());
			totalOver += Double.parseDouble(token.nextToken());
			
			totalRegular += Double.parseDouble(token.nextToken());
			totalOver += Double.parseDouble(token.nextToken());
			
			totalRegular += Double.parseDouble(token.nextToken());
			totalOver += Double.parseDouble(token.nextToken());
			
			totalRegular += Double.parseDouble(token.nextToken());
			totalOver += Double.parseDouble(token.nextToken());
			
			double totalPay = totalRegular * wage + totalOver * wage * 1.5;
			
			System.out.println(firstName + " " + lastName + "'s total weekly pay is " + totalPay);
			
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
