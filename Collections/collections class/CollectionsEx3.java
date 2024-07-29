import java.util.*;

public class CollectionsEx3 {
	public static void main(String[] args) {
        	ArrayList<Integer> list1 = new ArrayList<>();
        	list1.add(1);
        	list1.add(2);
       		list1.add(3);

       		List<Integer> list2 = new ArrayList<>();
		list2.add(4);
		list2.add(5);
		list2.add(6);

        	System.out.println(list1);
        	System.out.println(list2);

        	Collections.copy(list2, list1);

        	System.out.println(list1);
        	System.out.println(list2);		


		Collections.shuffle(list1);
		System.out.println("list1 after shuffle:" + list1);
    }
}
