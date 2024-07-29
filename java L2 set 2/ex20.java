import java.util.Arrays;
import java.util.Scanner;
public class ex20{
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
		
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
		}
		catch(Exception e){
			System.out.println("Enter a valid input : ");
		}
	}
	
	public static void quickSort(int arr[],int start ,int end ){
			if(end<=start){
				return ;
			}
			int pivot = partition(arr , start , end);
			quickSort(arr,start,pivot-1);
			quickSort(arr,pivot+1,end);
		}
		
	public static int partition(int[] arr,int start ,int end ){
			int pivot = arr[end];
			int i = start-1 ;
			
			for(int j=start;j<=end;j++){
				if(arr[j]<pivot){
					i++;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp ;
				}
			}
			i++;
			int temp = arr[i];
			arr[i] = arr[end];
			arr[end] = temp ;
			
			return i;
		} 
}