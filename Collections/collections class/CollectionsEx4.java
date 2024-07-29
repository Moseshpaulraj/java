import java.util.*;

public class CollectionsEx4 {
	public static void main(String[] args) {
        	ArrayList<String> names = new ArrayList<>();
        	names.add("Moses");
        	names.add("Madan");
       		names.add(null);

		ArrayList<Integer> names1 = new ArrayList<>();
        	names1.add(1);
        	names1.add(3);
       		names1.add(5);

        	System.out.println(names);
        	Collections.reverse(names);
        	System.out.println(names);


      		Collections.fill(names1, "sakthi");
    		System.out.println(names1);

        }
}
