public class Question38{
	public static void main(String[] args){
		int[] arr = {10,45,78,2,0,37,87,99,101,9};
		int largest = arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>largest){
				largest = arr[i];
			}
		}
		System.out.println(largest);
	}
}