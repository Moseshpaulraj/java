public class Question10{
	public static void main(String[] args){
		int[] arr = {8,9,6,1,9,7};
		int n =arr.length;
		int right = n-1 ;
		int left = 0 ;
		int[] result = new int[n];
		
		for(int i=0;i<arr.length;i++){
			if(i%2==0){
				result[i]=arr[right--];
			}else{
				result[i]=arr[left++];
			}
		}
		
		for(int i : result){
			System.out.print(i+" ");
		}

	}
}