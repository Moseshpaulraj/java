import java.util.*;
public class ex52{
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
		for(int i=0;i<size;i++){
			int num = arr[i];
			int sum = 0;
			int product = 1;
			while(num>0){
				int rem = num % 10 ;
				sum += rem ;
				product *= rem ;
				num /= 10 ;
			}
			if(product > sum && sum !=0 ){
				System.out.print(product + " ");
			}else{
				System.out.print(sum + " ");
			}
		}
		}
		catch(Exception e){
			System.out.println("Enter a valid input !!!!!! ");
		}
	}
}