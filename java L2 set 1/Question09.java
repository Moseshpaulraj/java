import java.util.Arrays;
public class Question09{
	public static void main(String[] args){
		int[] arr1 = {0,0,1,1,2,2,2,};
		int[] arr2 = {10,11,11,12,13,15,100};
		int a1 = arr1.length;
		int a2 = arr2.length;
		int count=0,i=0,j=0;

		while(i<a1 && j<a2){
			if(arr1[i]<arr2[j]){
				if(i<a1-1 && arr1[i]==arr1[i+1]){
					i++;
				}else{
					count++;
					i++;
				}
			}else if(arr1[i]>arr2[j]){
				if(j<a2-1 && arr2[j]==arr2[j+1]){
					j++;
				}else{
					count++;
					j++;
				}
			}else{
				j++;
			}
		}
		while(i<a1 || j<a2){
			if(i<a1){
			if(i<a1-1 && arr1[i]==arr1[i+1]){
					i++;
				}else{
					count++;
					i++;
				}
			}
			if(j<a2){
			if(j<a2-1 && arr2[j]==arr2[j+1]){
					j++;
				}else{
					count++;
					j++;
				}
			}
		}
		//System.out.println(count);

		int[] arr = new int[count];
		count=0;i=0;j=0;
		while(i<a1 && j<a2){
			if(arr1[i]<arr2[j]){
				if(i<a1-1 && arr1[i]==arr1[i+1]){
					i++;
				}else{
					arr[count]=arr1[i];
					count++;
					i++;
				}
			}else if(arr1[i]>arr2[j]){
				if(j<a2-1 && arr2[j]==arr2[j+1]){
					j++;
				}else{
					arr[count]=arr2[j];
					count++;
					j++;
				}
			}else{
				j++;
			}
		}
		while(i<a1 || j<a2){
			if(i<a1){
			if(i<a1-1 && arr1[i]==arr1[i+1]){
					i++;
				}else{
					arr[count]=arr1[i];
					count++;
					i++;
				}
			}
			if(j<a2){
			if(j<a2-1 && arr2[j]==arr2[j+1]){
					j++;
				}else{
					arr[count]=arr2[j];
					count++;
					j++;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	
	}
}
