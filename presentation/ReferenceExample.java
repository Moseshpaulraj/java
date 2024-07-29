public class ReferenceExample{
	public static void main(String[] args){
		int[] array1 = {10,20,30};
		int[] array2 = array1;
		System.out.println(array1[0]);
		System.out.println(array2[0]);
		array1[0]=50;
		System.out.println(array1[0]);
		System.out.println(array2[0]);
	}
}