import java.util.Arrays;
import java.util.Scanner;
public class ex30{
	public static void main(String[] args){
		try{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Array row : ");
		int row = scanner.nextInt();
		System.out.print("Enter Array coloum : ");
		int col = scanner.nextInt();
		System.out.print("Enter new number : ");
		int input = scanner.nextInt();

		int[][] arr = {{1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,0,0},
				{1,0,0,1,1,0,1,1},
				{1,2,2,2,2,0,1,0},
				{1,1,1,2,2,0,1,0},
				{1,1,1,2,2,2,2,0},
				{1,1,1,1,1,2,1,1},
				{1,1,1,1,1,2,2,1}};
		
		int num = arr[row][col];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				if(arr[i][j]==num){
					arr[i][j]=input;
				}
			}
		}

		System.out.println(Arrays.deepToString(arr));
		}
		catch(Exception e){
			System.out.println("invalid input");
		}
		
	}
}