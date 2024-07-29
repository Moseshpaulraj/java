import java.util.Arrays;
import java.util.Scanner;
public class ex23{
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
		
		int[][] temp = new int[size1][size2];
		for(int i=0;i<size1;i++){
			for(int j=0;j<size2;j++){
				if(j%2==0){
				temp[j][i] = arr[i][j];
				}else{
				temp[j][i]=arr[size1-1-i][j];
				}
			}
		}

		System.out.print(Arrays.deepToString(temp));

		}
		catch(Exception e){
			System.out.println("invalid input");
		}
		
	}
}