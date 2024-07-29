import java.util.*;
public class ex39{
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
		int[] arr1 = new int[2];
		System.out.print("Enter height of the tower h1 & h2 : ");
		for(int i=0;i<2;i++){
			arr1[i]=scanner.nextInt();
		}

		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		boolean[] check = new boolean[size];
		a:
		for(int i = 0;i<size-2;i++){
			for(int j=i+1;j<size-1;j++){
				for(int k = j+1;k<size;k++){
					if(arr1[0]==arr[i]+arr[j]+arr[k]){
						System.out.print(arr[i]+" "+arr[j]+" "+arr[k]+" &");
						check[i]  = true ;
						check[j] = true;
						check[k] = true;
						break a ;
					}
				}
			}
		}
		for(int i=0;i<size;i++){
			if(check[i]==false){
				System.out.print(" " +arr[i]);
			}
		}
		}
		catch(Exception e){
			System.out.println("Enter a valid input !!!!!! ");
		}
	}
}