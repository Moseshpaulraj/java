import java.util.regex.*;
import java.util.Scanner;
public class Dob{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter for syntax : ");
		String input = scanner.nextLine();
		Pattern p =Pattern.compile("\\b(0*[1-9]|[12][0-9]|3[01])[-/\\s](0*[1-9]|1[12])[-/\\s](\\d{4})");
		Matcher m = p.matcher(input);
		boolean b = m.matches();
		System.out.println(b);
	}
}