import java.util.Scanner;
public class ex14{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter String : ");
		String input = scanner.next();
		char[] arr = input.toCharArray();
		

		for(int i=0;i<arr.length;i++){
			String str = "";
			for(int j=i;j<arr.length;j++){
				str+=arr[j];
				System.out.println(str);	
			}
		}
	}
}