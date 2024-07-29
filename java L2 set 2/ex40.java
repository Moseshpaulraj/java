import java.util.*;
public class ex40{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
	System.out.print("Enter Array Size : ");
		int size = scanner.nextInt();
		int[] arr = new int[size];
		System.out.print("Enter array values : ");
		for(int i=0;i<size;i++){
			arr[i]=scanner.nextInt();
		}
		int index1=0;
		int index2=0;
		for(int i=0;i<size-1;i++){
			int count = 1 ;
			int largest = 0 ;
			int slargest = 0 ;
			for(int j=i+1;j<size;j++){
				if(arr[i]==arr[j]){
					count++;
				}
			}
			if(count>largest){
				largest=count;
				slargest = largest;
				index2=index1;
				index1=i;
			}else if(count>slargest){
				slargest=count;
				index2=i;
			}
		}
		System.out.println("Second frequency occuring number is : " + arr[index2]);
	}
}