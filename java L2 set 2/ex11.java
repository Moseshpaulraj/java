import java.util.Scanner;
public class ex11{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter String : ");
		String str = scanner.nextLine();
		

		char[] arr = str.toCharArray();
		int size = arr.length;
		char[] temp = new char[size];

		for(int i=0;i<size;i++){
			if(arr[i]==' ')	{
				temp[i]=' ';
			}
		}

		int j = 0;
		for(int i=size-1;i>=0;i--){
			if(temp[j]!=' ' && arr[i]!=' '){
				temp[j]=arr[i];
				j++;
			}else if(arr[j]==' '){
				j++;
				i++;
			}
		}
		
		String result = new String(temp);
		System.out.print(result);
	}
}