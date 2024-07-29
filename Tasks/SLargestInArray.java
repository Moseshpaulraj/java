public class SLargestInArray{
	public static void main(String[] args){
		int[] arr = {10,45,78,2,0,101,101,0,87,87,99,101,98,37,87,99,99,101,9};
		int largest = arr[0];
		int slargest = 0 ;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>largest){
				slargest = largest ;
				largest = arr[i];
			}else if(arr[i]>slargest && arr[i]<largest){
				slargest = arr[i];
			}
		}
		System.out.println(largest);
		System.out.println(slargest);
	}
}