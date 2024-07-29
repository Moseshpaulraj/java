import java.util.*;
public class ex45{
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
		System.out.print("Enter sum : ");
		int input = scanner.nextInt();
		
		for(int i=0;i<size;i++){
			int sum = 0;
			String str = "";
			for(int j=i;j<size;j++){
				sum +=arr[j];
				str +=arr[j];
				if(sum==input){
					System.out.print(Arrays.toString(str.toCharArray()));
				}
			}
		}	
		}
		catch(Exception e){
			System.out.println("Enter a valid input ");
		}
	}
}