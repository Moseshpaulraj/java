import java.util.Scanner; 
public class Question57{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Input : ");
		int num = scanner.nextInt();
		char[] arr1 = Integer.toString(num).toCharArray();
		char[] arr2 = new char[arr1.length];
		int k=arr1.length-1;
		for(int i =0;i<arr1.length;i++){
			arr2[k] = arr1[i];
			k--;	
		}
		
		for(int i = 0 ; i<arr1.length;i++){
			for(int j=0;j<arr1.length;j++){
				if (i == j){
					System.out.print(arr1[i]);
				} 
				else if(i + j == arr1.length - 1 && i !=j )
				{
					System.out.print(arr2[i]);
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
