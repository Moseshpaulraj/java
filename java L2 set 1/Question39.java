public class Question39{
	public static void main(String[] args){
		int[] arr = {10,45,78,2,1,37,87,99,101,9};
		int smallest = arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]<smallest){
				smallest = arr[i];
			}
		}
		System.out.println(smallest);
	}
}