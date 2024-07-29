import java.util.*;
public class HighestSequence{  
public static void main(String args[]){
	int[] arr = {1,2,3,5,6,7,8,12,15,9,0,19,20}; 
	Arrays.sort(arr);
	int count=0;
	int finalCount=0;

	for(int i=0;i<arr.length-1;i++){
		int temp=arr[i];
		int j = i;

		while(j<arr.length && temp==arr[j]){
			j++;
			temp ++;
			count++;
		}

		if(finalCount<count){
			finalCount = count;
			count=0;}
		else{
			count=0;	
		}
	} 

	System.out.println(finalCount);
   }
}


