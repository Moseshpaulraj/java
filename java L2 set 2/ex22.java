import java.util.Arrays;
import java.util.Scanner;
public class ex22{
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
		
		System.out.print("Enter value to find : ");
		int num = scanner.nextInt();
		
		int high = size;
		int low = arr[0];
		for(int i=0;i<size;i++){
			int middle = (low + high)/2;
			int mid = arr[middle];
			
			if(mid<num){
				low = middle+1;
				middle = (low + high)/2;
			}else if(mid > num){
				high  = middle-1;
				middle = (low + high)/2;
			}else{
				System.out.println("Found at index : "+middle);
				break ;
			}
		}
		}
		catch(Exception e){
			System.out.println("Enter a valid input : ");
		}
	}
}