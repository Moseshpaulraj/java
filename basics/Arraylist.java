//linked lists introduction
import java.util.ArrayList;
public class Arraylist{
	public static void main(String[] arg){
		ArrayList<Integer> list=new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.remove(0);
		list.contains(30);
		System.out.println(list.indexOf(20));
		System.out.println(list.size());
	}
}