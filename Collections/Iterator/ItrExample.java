import java.util.*;
public class ItrExample{
	public static void main(String[] args){

		ArrayList<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		
		

		Iterator<String> itr = list.iterator();
		while (itr.hasNext()){
		String a = itr.next();
		if(a.equals("Banana")){
			itr.remove();
			continue;
		}
   		System.out.println(a);
		//
		}   

		System.out.println(list);
	}
}