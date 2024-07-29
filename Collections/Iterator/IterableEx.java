import java.util.*;
public class IterableEx{
	public static void main(String[] args){

		ArrayList<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		
		for(String a : list ){
			System.out.println(a);

		}
	}
}