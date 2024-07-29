import java.util.Arrays;
import java.util.Scanner;
public class ex18{
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
			for(int j=0;j<size-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j] ;
					arr[j] = arr[j+1];
					arr[j+1] = temp ;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		}
		catch(Exception e){
			System.out.println("Enter a valid input : ");
		}
	}
}