import java.util.Scanner;
public class ex5{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		try {
		System.out.print("Enter Array size : ");
		int size = scanner.nextInt();
		int[] arr = new int[size];

		System.out.print("Enter Array values : ");
		for(int i=0;i<arr.length;i++){
			arr[i] = scanner.nextInt();
		}

		System.out.print("Enter rotate count : ");
		int rotate = scanner.nextInt();

		for(int i=1;i<=rotate;i++){
			int temp = arr[size-1];
			for(int j=size-1;j>0;j--){
				arr[j]=arr[j-1];	
			}
			arr[0]=temp;
		}

		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		}
		catch(Exception e){
			System.out.print(invalid input);
		}
		
	}
}