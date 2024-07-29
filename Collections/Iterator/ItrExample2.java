import java.util.*;
public class ItrExample2{
	public static void main(String[] args){

		ArrayList<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");

		Iterator<String> itr = list.iterator();
		itr.forEachRemaining(System.out::print);

	}
}