import java.util.Arrays;
import java.util.Scanner;
public class ex53{
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
		int count = 0 ;
		for(int i=1;i<size1-1;i++){
			for(int j=1;j<size2-1;j++){
				if(arr[i][j]==1 && arr[i-1][j]==-1 && arr[i+1][j]==-1 && arr[i][j-1]==-1 && arr[i][j+1]==-1){
					count ++ ;
					System.out.println("Island " + count +" is in position " + i + "," + j);
				}
			}
		}
		System.out.println("total islands : " + count );
	}
}