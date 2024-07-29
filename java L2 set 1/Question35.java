import java.util.Scanner;
public class Question35{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number : ");
		int num =scanner.nextInt();
		System.out.println("Factorial of " + num + " is: "+factorial(num));
	
	}
	static int factorial(int n){
		if(n==1){
			return 1 ;	
		} else {
		int num = n* factorial(n-1);
		return num ;
		}
	}

}
