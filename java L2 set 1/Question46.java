public class Question43{
	public static void main(String[] args){
		int[] arr = {10,45,78,2,1,37,87,99,101,9};
		int len = arr.length -1;
		int temp = arr[len];
		for(int i=len;i>0;i--){
			arr[i]=arr[i-1];	
		}
		arr[0]=temp;
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}