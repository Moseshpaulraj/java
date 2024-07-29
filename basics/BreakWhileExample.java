public class BreakWhileExample {  
static public void main(String[] args) {    
    int i=10;  
    while(i<=10){  
        if(i==5){   
            i++;  
            break; 
        }  
        System.out.println(i);  
        i++;  
    } 
}  
}