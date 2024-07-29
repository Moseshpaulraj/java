import java.util.*;
public class VectorEx1{
	public static void main(String[] args){
		int size = 1000000;

		long start = System.currentTimeMillis();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for (int i=0;i<size;i++){
			list1.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(" totaltime " + (end - start) + " ms");


		start = System.currentTimeMillis();
		Vector<Integer> list = new Vector<Integer>();
		for (int i=0;i<size;i++){
			list.add(i);
		}
		end = System.currentTimeMillis();	
		System.out.println(" totaltime " + (end - start) + " ms");
		
		
		
	}	
}