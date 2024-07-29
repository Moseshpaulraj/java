import java.util.*;
public class LinkedlistExample1{
	public static void main(String[] args){
	LinkedList<String> list = new LinkedList<String>();

	list.add("moses");
	list.add("sakthi");
	list.add("rahul");
	list.add("raj");
	list.add("sakthi");
	System.out.println(list);

	list.remove("raj");
	list.remove(0);
	System.out.println(list);

	list.removeFirst();
	list.removeLast();
	System.out.println(list);


	LinkedList<String> list1 = new LinkedList<String>();

	list1.add("sakthi");
	list1.add("vel");
	list1.add("rahul");
	System.out.println(list1);

	list1.removeAll(list);
	System.out.println(list1);

	}
}