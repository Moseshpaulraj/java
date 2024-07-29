import java.util.Scanner;
import java.util.regex.*;
public class ex1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter ip address : ");
		String ip = sc.nextLine() ;

		Pattern p = Pattern.compile("^((25[0-4]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]).){3}(25[0-4]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9])$");

		Matcher m = p.matcher(ip); 
		boolean match = m.matches(); 	
		System.out.println(match);
	
	}
}