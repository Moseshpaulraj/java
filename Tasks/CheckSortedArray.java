public class CheckSortedArray{
	public static void main(String[] args){
		int[] arr = {0,1,2,3,3,4,5,6,7,8,18,18,9,9};
		for(int i=1;i<arr.length;i++){
			if(arr[i]>=arr[i-1]){
				if(i<arr.length-1){continue;}
			}else{
				System.out.println("Array is unsorted");
				break ;
			}
			System.out.println("Array is sorted");
		}
	}
}