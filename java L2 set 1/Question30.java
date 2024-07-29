import java.util.Scanner;
public class Question30{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter value of A: ");
		int a =scanner.nextInt();
		System.out.print("Enter value of B: ");
		int b =scanner.nextInt();
		System.out.print("Enter value of C: ");
		int c =scanner.nextInt();
		
		int greatest = (a>b && b>c ? a : (b>a&&b>c ? b : c ));
		System.out.println("Greatest number is " + greatest);
		
	}
}
