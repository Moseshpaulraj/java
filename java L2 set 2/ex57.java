import java.util.Scanner;
public class ex57{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Array Size : ");
		int size = scanner.nextInt();
		int[] arr = new int[size];
		System.out.print("Enter array values : ");
		for(int i=0;i<size;i++){
			arr[i]=scanner.nextInt();
		}
		int right = size-1 ;
		int left = 0 ;
		int[] result = new int[size];
		
		for(int i=0;i<size-1;i++){
			for(int j=0;j<size-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
		for(int i=0;i<size;i++){
			if(i%2==0){
				result[i]=arr[right--];
			}else{
				result[i]=arr[left++];
			}
		}
		
		for(int i : result){
			System.out.print(i+" ");
		}

	}
}