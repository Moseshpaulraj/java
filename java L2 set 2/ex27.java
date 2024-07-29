import java.util.Arrays;
import java.util.Scanner;
public class ex27{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Array row size : ");
		int size1 = scanner.nextInt();
		System.out.print("Enter Array coloum size : ");
		int size2 = scanner.nextInt();

		int[][] arr = new int[size1][size2];

		System.out.print("Enter Array values : ");
		for(int i=0;i<size1;i++){
			for(int j=0;j<size2;j++){
				arr[i][j] = scanner.nextInt();
			}
		}
		
		for(int i=0;i<size1;i++){
			for(int j=0;j<size2;j++){
				if()
			}
		}

		System.out.print(Arrays.deepToString(temp));
		
	}
}