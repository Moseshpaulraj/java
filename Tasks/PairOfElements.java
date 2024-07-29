import java.util.*;
public class PairOfElements{
	public static void main(String args[]){
		int[] arr = {1,2,3,4,5,5,6,7,8,9,0};
		int pairsCount = 0 ;
		Scanner scanner = new Scanner(System.in);
		for(int x :arr){System.out.print(x+ " ");}
		System.out.println();
		System.out.print("Enter a Number to get its sum of pairs : ");
		int sum = scanner.nextInt();
		for(int i=0;i<arr.length;i++){
			if(arr[i] <= sum){
				for(int j=i+1;j<arr.length;j++){
					if(arr[i]+arr[j]==sum){
						System.out.println("The pairs are : " + arr[i] + "," + arr[j] );
						pairsCount++;
						}
				}
			}
			
		}
		System.out.println("Total pairs : " + pairsCount);
		if(pairsCount == 0){
			System.out.println("No pairs Found !!!!");
		}
	}
}
