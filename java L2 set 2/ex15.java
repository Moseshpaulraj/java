import java.util.Scanner;
public class ex15{

	public static void main(String[] args){
		try{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int num = scanner.nextInt();
		int product = 0 ;

		for(int i =1;product<=num;i++){
			product = 0 ;
			product = i * (i+1);
			if(product==num){
				System.out.println(num+" is a pronic number");
				System.out.println( i+"*"+(i+1)+" = "+product );
				break;
			}else if(product>num){
				System.out.println(num+" is not a pronic number");
			}
		}
		}
		catch(Exception e){
			System.out.println("invalid input");
		}
	}
}