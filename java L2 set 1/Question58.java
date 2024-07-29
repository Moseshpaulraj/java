import java.util.Scanner;
public class Question58{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number: ");
		int num =scanner.nextInt();
		for(int i=1;i<=num;i++){
			for(int j=num;j>=i;j--){
				System.out.print("*");	
			}
			for(int j=1;j<i;j++){
				System.out.print("_");
			}
			for(int j=1;j<=num;j++){
				if(j<i)
					System.out.print("_");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1;i<num;i++){
			for(int j=0;j<=i;j++){
				System.out.print("*");	
			}
			for(int j=num-1;j>i;j--){
				System.out.print("_");
			}
			for(int j=num-1;j>=0;j--){
				if(j>i)
					System.out.print("_");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		
	}
}

