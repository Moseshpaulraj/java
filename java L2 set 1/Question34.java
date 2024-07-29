import java.util.Scanner;
public class Question34{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number : ");
		int num =scanner.nextInt();
		int sum =0;
		for(int i =0 ;i<=num ; i++){
			sum+=i;
		}
		System.out.println("sum of natural number is : " + sum );
		
		int largest =0;
		while(sum>0){
			int digit = sum % 10 ;
			if(digit > largest){
				largest=digit ;
			}
			sum/=10;
		}
		System.out.println(largest);
	}
}
