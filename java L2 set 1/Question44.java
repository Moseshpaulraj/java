import java.util.Arrays;
public class Question44{
	public static void main(String[] args){
		int[] arr = {0,4,6,-7,0,5,-7,0,-7,1,1,0};
		int num = 0 ;
		
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	
		for(int i=0;i<arr.length;i++){
			int count =0 ;
			if(arr[i]>num || i==0){
			for(int j=i;j<arr.length-1;j++){
				if( arr[i]==arr[j]){
					count++ ;
				}
			}
			if(count>1){
					System.out.println(arr[i]);
					num = arr[i];
				}
			}
		}
		
	}
}