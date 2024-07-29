import java.util.Scanner;
public class ex8{
	public static void main(String[] args){
		try{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Array size : ");
		int size = scanner.nextInt();
		int[] arr = new int[size];
		System.out.print("Enter Array values : ");
		for(int i=0;i<arr.length;i++){
			arr[i] = scanner.nextInt();
		}

		int leader = 0 ;
		for(int i=0;i<size;i++){
			for(int j=i+1;j<size;j++){
				if(arr[i]<arr[j]){
					leader = j;
					i = leader ;
				}
			}
		System.out.print(arr[leader]);
		}
	}
	catch(Exception e){
		System.out.println("invalid input");
	}
	}
}