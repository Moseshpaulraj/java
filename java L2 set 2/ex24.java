import java.util.Scanner;
public class ex24{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter String1 : ");
		String str1 = scanner.next();
		System.out.print("Enter String2 : ");
		String str2 = scanner.next();
		
		char[] arr = str1.toCharArray();
		int size = arr.length;

		for(int i=1;i<=size;i++){
			char temp = arr[size-1];
			for(int j=size-1;j>0;j--){
				arr[j]=arr[j-1];	
			}
			arr[0]=temp;
			String str =new String(arr);

			if(str.equals(str2)){
				System.out.println("yes");
			}
		}
		
	}
}