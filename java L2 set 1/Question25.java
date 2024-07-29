import java.util.Scanner;
public class Question25{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter dividand : ");
		int d1 =scanner.nextInt();
		System.out.print("Enter divisor : ");
		int d2 =scanner.nextInt();
		
		int quotient = d1/d2 ;
		int remainder = d1%d2 ;
		
		System.out.println("Quotient : "+quotient +"  Remainder : "+remainder);
		
	}
}
