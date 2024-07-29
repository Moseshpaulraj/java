import java.util.Scanner;
public class ex13{
	public static void main(String[] args){
		try{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int input = scanner.nextInt();
		int temp = input ;
		int num = (String.valueOf(input)).length();
		int sum = 0 ;
		for(int i=num;input>0;i--){
			int n =	input%10;
			sum +=power(n,i); 
			input /=10;
		} 
		if(sum==temp){
			System.out.println(temp + " is A disarium number  ");
		}else
		{
			System.out.println("its not an disarium number");
		}
	}
	public static int power(int a ,int b){
		int num = a ;

		for(int i =2;i<=b;i++){
			a=a*num;
		}
		return a ;
	}
	catch(Exception e){
		System.out.println("invalid input");
	}
	}
}