import java.util.*;
public class ex41{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		try{
		System.out.print("Enter Array Size : ");
		int size = scanner.nextInt();
		int[] arr = new int[size];
		System.out.print("Enter array values : ");
		for(int i=0;i<size;i++){
			arr[i]=scanner.nextInt();
		}
		
		for(int i=0;i<size-1;i++){
			int largest =arr[i+1];
			for(int j=i+1;j<size;j++){
				if(arr[j]>largest){
					largest=arr[j];
				}
			}
			arr[i]=largest;
		}
		arr[size-1]=-1;
		System.out.print(Arrays.toString(arr));
		}
		catch(Exception e){
			System.out.println("Enter a valid input ");
		}
	}
}