import java.util.Arrays;
public class Question11{
	public static void main(String[] args){
		int[][] arr= {  {1,2,3},
				  	{4,5,6},
					{7,8,9}};

        int rows= arr.length;
        int cols= arr[0].length;
        int[][] arr2= new int[cols][rows];

        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                arr2[cols-1-j][i]=arr[i][j];
            }
        }


        System.out.println("Left Rotated Array:");
        System.out.println(Arrays.deepToString(arr2));
    }
}