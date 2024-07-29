import java.util.Scanner;
public class ex4{
	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter input : ");
		String input = scanner.nextLine();
		String[] arr = input.split(" ");
		int len = arr.length ;

		for(int i=0;i<arr.length;i++){
			String str = wordReverse(arr[i]);
			arr[i] = str ;
		}
		
		for(String s : arr){
			System.out.print(s +" ");
		}
		
	}

	public static String wordReverse(String s){
		char[] arr = s.toCharArray();
		String result = "";
		for(int i=arr.length-1;i>=0;i--){
			result += arr[i];
		}
		return result ;
	}
}