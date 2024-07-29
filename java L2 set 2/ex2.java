import java.util.Scanner;
public class ex2{
	public static void main(String[] args){
	try{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Amstrong number : ");
		int input = scanner.nextInt();
		int num = input ;
		int sum=0;
		
		while(num>0){
			int rem = num % 10 ;
			sum += rem*rem*rem ;
			num /= 10 ;
		}
		System.out.println(input==sum);
	
		}

		catch(Exception e){
			System.out.println("invalid input ");
		}
	}
}