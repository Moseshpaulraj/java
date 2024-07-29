import java.util.Scanner;
public class Findoddeven{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the number:");
		int value = sc.nextInt();
		evenOdd(value);
	}
	public static void evenOdd(int value){
			if(value%2==0)
				System.out.println("Entered number is even");
			else
				System.out.println("Entered number is odd");
	}
}