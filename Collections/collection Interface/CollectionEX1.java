import java.util.*;
public class CollectionEx1{
	public static void main(String[] args){
	
	ArrayList<String> list = new ArrayList<>();

	list.add("Moses");
	list.add("sakthi");
	list.add("vel");
	list.add("rahul");
	System.out.println(list);


	System.out.println(list.size());
	
	System.out.println(list.isEmpty());

	System.out.println(list.contains("vel"));

	list.remove("Moses");
	System.out.println(list);
	
	
	System.out.println(list.hashCode());
	}
}