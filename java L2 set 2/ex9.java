import java.util.Scanner;
public class ex9{
	public static void main(String[] args){
		try{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int input = scanner.nextInt();
		int num = input ;
		int sum = 0 ;
		while(num>0){
			int n =	num%10;
			sum +=n; 
			num /=10;
		} 

		if(input%sum==0){
			System.out.println("its A Harshad number : "+ input + " is divisible by " + sum);
		}else
		{
			System.out.println("its not an harshad number");
		}
		}
		catch(Exception e){
			System.out.println("invalid input");
		}
	}
}