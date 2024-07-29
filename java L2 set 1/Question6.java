import java.util.Scanner; 
public class Question6{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Roll no Starting From: ");
		int num1 = scanner.nextInt();
		System.out.print("Enter Roll no Ending  : ");
		int num2 = scanner.nextInt();

		for(int i=num1,g=1;i<=num1+3;i++,g++){
			System.out.println("Group"+g);

			for(int j=i;j<=num2;){
				System.out.println(j);
				j+=4;

			}	 	
		}
	}
}
