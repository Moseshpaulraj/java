import java.util.*;
public class Average{
	public static void main(String args[]){
		int[] arr = {1,2,3,4,5,10,6,7,8,9,10};
		int total = 0 ;
		Arrays.sort(arr);
		for(int i=1;i<arr.length-1;i++){
			total = total + arr[i] ;
		}
		int average = total / (arr.length-2) ;
		System.out.println("The Average value of Array without min & max : " + average);
		//System.out.println(total);
	}
}