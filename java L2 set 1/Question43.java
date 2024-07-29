public class Question43{
	public static void main(String[] args){
		int[] arr = {10,45,78,2,1,37,87,99,101,9};
		int temp = arr[0];
		for(int i=0;i<arr.length-1;i++){
			arr[i]=arr[i+1];	
		}
		arr[arr.length-1]=temp;
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}