import java.util.*;  
public class HashMapEx1{  
 public static void main(String args[]){ 
 
   HashMap<Integer,String> map=new HashMap<Integer,String>();   
   map.put(1,"Moses");  
   map.put(2,"Abraham");    
   map.put(null,"Sakthi");   
   map.put(4,"Madan"); 
   map.put(4,"Madan");
       
   System.out.println(map);  
   System.out.println(map.get(null));
	

		System.out.println(map.containsKey(3));
		System.out.println(map.containsValue("Moses"));
		System.out.println(map.isEmpty());
		System.out.println(map.size());



		
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map.entrySet());


		
		map.remove(1);
		System.out.println(map);
		map.clear();
		System.out.println(map);		

   }
}