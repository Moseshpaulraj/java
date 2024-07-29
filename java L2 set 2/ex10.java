import java.util.Scanner;
public class ex10{
	public static void main(String[] args){
		try{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter input : ");
		int input = scanner.nextInt();
		int num = input ;
		boolean notPalindrome = true ;
	
	while(notPalindrome){
		int rev = 0 ;
		while(num>0){
			int x = num%10 ;
			rev = x + (rev*10);
			num =num / 10 ;
		}
		int sum = input + rev ;
		num = sum ;
		System.out.println(input + "+" + rev +"="+sum);
		input = sum ;
		int reverse = reverseOf(sum);
		if(reverse == sum){
			notPalindrome =false ;
			break;
		}
		}
		}catch(Exception e){
			System.out.println("invalid input");
		}
	}
	public static int reverseOf(int temp ){
		int rev = 0 ;
		while(temp>0){
			int x = temp % 10 ;
			rev = x + (rev*10);
			temp /= 10 ;
		}
		return rev ;
	}
}