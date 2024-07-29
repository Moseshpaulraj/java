import java.util.Arrays;
import java.util.Scanner;
public class ex21{
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
		
		for(int i=0;i<size;i++){
			if(arr[i]==num){
				System.out.println("value found at index : " + i);
				break;
			}
		}
		}
		catch(Exception e){
			System.out.println("Enter a valid input : ");
		}
	}
}