import java.util.*;
public class LinkedlistExample{
	public static void main(String[] args){
	LinkedList<String> list = new LinkedList<String>();

	list.add("moses");
	list.add("rahul");
	list.add(1,"sakthi");
	System.out.println(list);

	list.addFirst("first");
	list.addLast("last");
	System.out.println(list);


	LinkedList<String> list1 = new LinkedList<String>();
	list1.add("rahul");
	list1.add("raj");

	list.addAll(list1);
	System.out.println(list);

	list.addAll(0,list1);
	System.out.println(list);

	Iterator<String> itr = list1.iterator();
	while(itr.hasNext()){
	System.out.println(itr.next());}
}
}