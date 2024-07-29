import java.util.*;
public class CollectionEx2{
	public static void main(String[] args){
	
	ArrayList<String> list1 = new ArrayList<>();

	list1.add("Moses");
	list1.add("sakthi");
	list1.add("rahul");
	System.out.println(list1);

	ArrayList<String> list2 = new ArrayList<>();
	list2.add("Madan");


	list2.addAll(list1);
	System.out.println(list2);



	System.out.println(list1.equals(list2));
	System.out.println(list2.containsAll(list1));



	list1.clear();
	System.out.println(list1);


	}
}