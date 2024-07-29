import java.util.Scanner;
import java.util.Arrays;
public class Question54{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Array size : ");
		int size = scanner.nextInt();
		int[] arr = new int[size];

		System.out.print("Enter Array values : ");
		for(int i=0;i<arr.length;i++){
			arr[i] = scanner.nextInt();
		}

		int num = 0 ;
		
		for(int i=0;i<arr.length-1;i++){

			for(int j=0;j<arr.length-2;j++){
				if(j%2==1){
					if(arr[j]>arr[j+2]){
						int temp = arr[j];
						arr[j]=arr[j+2];
						arr[j+2]=temp;
					}
				}
				else if(j%2==0){
					if(arr[j]<arr[j+2]){
						int temp = arr[j];
						arr[j]=arr[j+2];
						arr[j+2]=temp;
					}
				}
			}
		}
	
		for(int x : arr){System.out.print(x);}
		
	}
}