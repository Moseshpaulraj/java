 public class StringToIntExample{  
    public static void main(String args[]){  

        String ch = "123abc";  
 
      // int i=Integer.parseInt(ch);  //Converting String into int  

        int a=Integer.valueOf(ch);   //Converting String into int 
        System.out.println("Output : ");       
       // System.out.println(i); 
        System.out.println(a);
     }
}