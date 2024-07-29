import java.util.Scanner;
public class Question51{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a Number : ");
		int num = scanner.nextInt();
		String str = "" ;
		int x = 0 ;
		while(num>0){
			if(num>9){
			x  = num % 10 ;
			num = num /10 ;
			str += x;
			}else {
			x = num ;
			str += x;
			break;
			}
			 
		}
		System.out.println("output : " + str);
	}
}