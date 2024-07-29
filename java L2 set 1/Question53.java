import java.util.Scanner; 
public class Question53{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Input : ");
		String input = scanner.nextLine();
		
		char[] arr = input.toCharArray();
		for(int i =0;i<arr.length;i++){
			if(arr[i]>=48 && arr[i]<=57){
				if(i<arr.length-1 && arr[i+1]>=48 && arr[i+1]<=57){
					char c1 = arr[i];
					char c2 = arr[i+1]; 
					
					String s1 = Character.toString(c1) + Character.toString(c2) ;
					int n = Integer.parseInt(s1);
					System.out.print(Question53.convert(arr[i-1],n));
					i++;
				}else{
				int n = Character.getNumericValue(arr[i]);
				System.out.print(Question53.convert(arr[i-1],n));
				}
			}
		}
	}
	public static String convert(char x , int n ){
		String s = String.valueOf(x);
		String str = s.repeat(n) ;
		return str ;
	}
}
