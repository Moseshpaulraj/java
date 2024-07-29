import java.util.Scanner;
public class ex29{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter String1 : ");
		String str1 = scanner.next();
		System.out.print("Enter String2 : ");
		String str2 = scanner.next();
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		System.out.println(num1*num2);
		
	}
}