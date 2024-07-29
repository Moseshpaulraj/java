import java.util.*;
public class ArraylistExample{
	public static void main(String[] args){
	ArrayList<String> list = new ArrayList<>();
	ArrayList<String> list1 = new ArrayList<>();
	list.add("moses");
	list.add("paul");
	list.add("raj");
	list.add(0,"hello");
	System.out.println(list.get(0));
	list.set(0,"hi");
	
	list.remove(0);
	
	System.out.println(list.size());
	//list.clear();
	System.out.println(list);
	System.out.println(list.isEmpty());
	System.out.println(list.contains("moses"));
	list.add(3,"moses");System.out.println(list);
	System.out.println(list.indexOf("moses1"));
	System.out.println(list.lastIndexOf("moses"));
	System.out.println(list.get(0));
	list1.addAll(list);
	System.out.println(list1);
	System.out.println("----------");
	for(String i : list)
		System.out.println(i);
	
	}
}