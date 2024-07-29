import java.util.Scanner;
public class Question55{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number: ");
		int num =scanner.nextInt();
	
		for(int i=1;i<=num;i++){
			for(int j=1;j<=num;j++){
			System.out.print("*");
				if(i!=1 && i!=num){
					break ;
				}
			}
		System.out.println();
		}
	}
}
