import java.util.LinkedList;
public class Linkedlist{
	public static void main(String[] arg){
		LinkedList<Integer> list=new LinkedList<>();
		list.addFirst(10);
		list.addFirst(15);
		list.addFirst(20);
		list.addLast(30);
		list.removeLast();
		System.out.println(list.contains(20));
		System.out.println(list);
	}
}