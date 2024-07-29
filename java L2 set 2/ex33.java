import java.util.Scanner;
public class ex33{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a input : ");
		String str= scanner.next();
		char[] arr = str.toCharArray();
		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if( arr[i]==arr[j] || ((Character.isLetter(arr[j]) && Character.toLowerCase(arr[i])==Character.toLowerCase(arr[j])))){
					if(arr[j]=='9'){
					arr[j]-=9;
					}
					else if(arr[j]=='Z' || arr[j]=='z' ){
						arr[j]-=25;
					}
					else{
					arr[j]+=1;
					}
				i=0;
				}
			}
		}
		
		String result = new String(arr);
		System.out.println(result);
	}
}
