import java.util.*;
public class ex43{
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
		int sum1=0;
		int sum2=0;
		int total = 0;
		for(int i=0,j=size-1;i!=j;i++,j--){
			sum1 += arr[i];
			sum2 += arr[j];
			if(sum1 == sum2){
				total = i+1;
			}
		}
		if(total==0){
			System.out.println(-1);
		}else{
		System.out.println(total);
		}
		}
		catch(Exception e){
			System.out.println("Enter a valid input ");
		}
	}
}