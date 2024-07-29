import java.util.Scanner;
public class Question3{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a Number : ");
		int num = scanner.nextInt();
		int num1 = num ;
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
		int num2 =  Integer.parseInt(str) ;
		System.out.println(num1 + "-" + num2 + " = " + (num1-num2) );
	}
}