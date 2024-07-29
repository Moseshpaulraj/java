import java.util.Arrays;
public class Question42{
	public static void main(String[] args){
		int[] arr = {1,2,5,3,4,5,5,5,5,5,5,5,5,44,0,0,3,1};
		int num = 0 ;
		
	
	
		for(int i=0;i<arr.length;i++){
			int count =0 ;
			if(arr[i]>num || i==0){
			for(int j=i;j<arr.length-1;j++){
				if( arr[i]==arr[j]){
					count++ ;
				}
			}
			if(count>1){
					System.out.println(arr[i] + " " + count);
					num = arr[i];
				}
			}
		}
		
	}
}