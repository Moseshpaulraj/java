import java.util.Arrays;
import java.util.Scanner;
public class ex19{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		try{
		System.out.print("Enter size : ");
		int size = scanner.nextInt();
		int[] arr = new int[size];

		System.out.print("Enter Array values : ");
		for(int i=0;i<size;i++){
			arr[i] = scanner.nextInt();
		}
		
		for(int i=1;i<size;i++){
			int temp = arr[i];
			int j = i-1 ;
			while( j>=0 && arr[j] > temp ){
				arr[j+1] = arr[j] ;
				j--;
			}
			arr[j+1]=temp;
			
		}
		System.out.println(Arrays.toString(arr));
		}
		catch(Exception e){
			System.out.println("Enter a valid input : ");
		}
	}
}