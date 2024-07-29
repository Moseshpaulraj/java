import java.util.*;  
  
public class IdentityHashMapEx1  
{  
   public static void main(String[] args)   
    {  
      
        HashMap<String, String> hm = new HashMap<>();  
        IdentityHashMap<String, String> ihm = new IdentityHashMap<>();    

        hm.put("sakthi","123"); 
        hm.put(new String("sakthi"),"123");   
         
        ihm.put("sakthi","123");
        ihm.put(new String("sakthi"),"13");
	ihm.put(new String("sakthi"),"13");
	System.out.println(ihm.get("sakthi")); 
   
        System.out.println("HashMap elements: " + hm);  
        System.out.println("identityHashMap elements: " + ihm);            

        System.out.println("Size of HashMap is : "+hm.size());            
        System.out.println("Size of IdentityHashMap is : "+ihm.size()); 

	ihm.remove("sakthi", "123");

	System.out.println(ihm);
    }
}
