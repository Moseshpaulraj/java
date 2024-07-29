import java.util.Arrays;
import java.util.Scanner;
public class ex17{
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
		
		for(int i=0 ; i<size-1;i++){
			int min = i ;
			for(int j=i+1;j<size;j++){
				if(arr[min]>arr[j]){
					min = j ;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		}
		catch(Exception e){
			System.out.println("Enter a valid input : ");
		}
		
		System.out.println(Arrays.toString(arr));
	}
}