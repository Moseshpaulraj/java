import java.util.*;
public class main{
public static void main(String[] args){
/*  List<String> names = new ArrayList<String>();
		
		names.add("rahul");
		names.add("mosesh");
		names.add("sakthi");
		names.add("mosesh");
		names.add("madan");
		names.add("mosesh");
		names.add("jenishiya");
		names.add("mosesh");
		names.add("vel");
		
		List<String> sub = names.subList(names.indexOf("mosesh"), names.lastIndexOf("mosesh"));
		System.out.println(sub);
		
		List<String> sub1 = names.subList(2, sub.size()+1);
		System.out.println(sub1);
		sub1.remove("mosesh");
		System.out.println(sub1); */

	/*	System.out.println(names);
		
		int index = names.indexOf("mosesh") + 1;
		
		System.out.println(index);
		
		List<String> sub = names.subList(index, names.lastIndexOf("mosesh"));
		
		System.out.println(sub);

		int index1 = sub.indexOf("mosesh") + 1;
		
		System.out.println(index1);

		List<String> sub1 = sub.subList(index1, sub.size());
		
		System.out.println(sub1);
		
		names.remove(index + index1 + sub1.indexOf("mosesh"));
		
		System.out.println(names);
		
	*/

List<String> names = new ArrayList<String>();
		
		names.add("rahul");
		names.add("mosesh");
		names.add("sakthi");
		names.add("mosesh");
		names.add("madan");
		names.add("madan");
		names.add("mosesh");
		names.add("jenishiya");
		names.add("mosesh");
		
		int index = names.indexOf("mosesh")+1 ;

		List<String> sub = names.subList(index , names.lastIndexOf("mosesh"));
		sub.remove(sub.indexOf("mosesh"));
		names.remove(index + sub.indexOf("mosesh"));

		System.out.println(names);
	}
}