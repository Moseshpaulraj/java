import java.util.Scanner;
public class Question60{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		try{
		System.out.print("Enter Number: ");
		int input =scanner.nextInt();
		int sum=0, num=0; 
		for(int i=1;i<=input;i++){
			num = num * 10 + 1;
			if(i>1){
				System.out.print( " + " + num) ;
			}else{
				System.out.print(num) ;
			}
			sum += num;
			}
		System.out.println("\nTotal Sum is : " + sum );
		}
		catch(Exception e){
			System.out.println(" Enter a valid input !!!!");
		}
	}
}
