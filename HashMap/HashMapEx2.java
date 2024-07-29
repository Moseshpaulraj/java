import java.util.*;  
public class HashMapEx2{  
public static void main(String args[]){ 
 
   HashMap<Integer,String> map=new HashMap<Integer,String>();   
   map.put(1,"Moses");  
   map.put(2,"Abraham");    
   map.put(3,"null");   
   map.put(4,"Madan");   
   System.out.println(map);  
 
	

		map.putIfAbsent(3,"Madan");
		map.putIfAbsent(5,"Madan");
		System.out.println(map);

		//map.remove(1,"Moses");
		System.out.println(map);    


		System.out.println(map.getOrDefault(1,"hello"));
		System.out.println(map.getOrDefault(5,"hello"));
		

		map.replace(2,"Rahul");
		System.out.println(map);

		map.replace(1,"Moses","Raj");
		System.out.println(map);
   }
}