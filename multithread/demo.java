import java.util.*;

public class demo{
    public static void main(String[] args){
         Hello h = new Hello();
         Hi hi = new Hi();
         
         h.start();
         hi.start();
         
    }
}
class Hi extends Thread{
        public void run(){
            for(int i=0;i<10;i++){
                System.out.println("hi");
                try{ Thread.sleep(1000);}catch(Exception e ){}}
        }
}
class Hello extends Thread{
        public void run(){
            for(int i=0;i<10;i++){
                System.out.println("hello");
               try{Thread.sleep(1000);}catch(Exception e ){}}
        }
}

