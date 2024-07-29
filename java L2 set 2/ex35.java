import java.util.Scanner;
public class ex35{
	public static void main(String[] args){
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter Array size : ");
			int size = scanner.nextInt();
			int[] arr = new int[size];
			System.out.print("Enter Array values : ");
			for(int i=0;i<size;i++){
				arr[i] = scanner.nextInt();
			}
			int smallest = arr[0];
			int index = 0 ;
			for(int i=0;i<arr.length;i++){
				if(arr[i]<smallest){
					smallest = arr[i];
					index = i ;
				}
			}
			int largest = 0 ;
			for(int i=index+1;i<arr.length;i++){
				if(arr[i]>largest){
					largest = arr[i];
				}
			}
			int result = largest - smallest ;
			if(largest<=0)
				System.out.println(largest);
			else
				System.out.println(result);
		}
		catch(Exception e){
			System.out.println("invalid input");
		}
	}
}