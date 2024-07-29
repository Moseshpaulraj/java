import java.util.Arrays;
import java.util.Scanner;
public class ex16{
	public static void main(String[] args){
		try{
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
			int smallest=arr[i][0];
			int index = 0;
			for(int j=0;j<size2;j++){
				if(smallest>arr[i][j]){
					smallest=arr[i][j];
					index = j ;
				}
			}

			int largest = smallest;
			for(int j=0;j<size2;j++){
				if(largest<arr[j][index]){
					largest=arr[j][index];
				}
			}

			if(smallest==largest){
				System.out.println(smallest);
			}
			
		}

		System.out.print(Arrays.deepToString(arr));
		}
		catch(Exception e){
			System.out.println("invalid input");
		}
	}
}