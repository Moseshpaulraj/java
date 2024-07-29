import java.util.Scanner;
public class Question01{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a Number : ");
		int number = scanner.nextInt();
		System.out.print("Enter limit : ");
		int limit = scanner.nextInt();

		System.out.println("Multiplication");
		for(int i = 1;i<=limit;i++){
			System.out.println(number + " * " +i+ " = " + (number*i));
		}

		System.out.println("Subraction");
		for(int i = 1;i<=limit;i++){
			System.out.println(number + " - " +i+ " = " + (number-i));
		}
	}
}