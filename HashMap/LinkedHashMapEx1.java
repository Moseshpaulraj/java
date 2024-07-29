import java.util.*;  
public class LinkedHashMapEx1{  
public static void main(String args[]){ 
 
   LinkedHashMap<String,String> address1=new LinkedHashMap<String,String>();   
   address1.put("Moses","tirunelveli");  
   address1.put("sakthi","chennai");    
   address1.put("rahul","thoothukudi");   
   address1.put("madan","tirunelveli");   
       
   System.out.println(address1);  




   HashMap<String,String> address=new HashMap<String,String>();  
   address.put("Moses","tirunelveli");  
   address.put("sakthi","chennai");    
   address.put("rahul","thoothukudi");   
   address.put("madan","tirunelveli");   
       
   System.out.println(address);  

   }
}