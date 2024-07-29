import java.util.regex.*;
import java.util.Scanner;
public class ForLoop{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter for syntax : ");
		String input = scanner.nextLine();
		Pattern p =Pattern.compile("\\bfor\\s*\\(.*;.*;.*\\)\\s*\\{.*\\}$");
		Matcher m = p.matcher(input);
		boolean b = m.matches();
		System.out.println(b);
		}
}