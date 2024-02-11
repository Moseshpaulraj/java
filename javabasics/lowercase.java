package javabasics;

public class lowercase {
    public static void main(String args[]) {
        StringBuilder a = new StringBuilder("ABCD");
        System.out.println("Original Input : "+a);
        for(int i=0;i<a.length();i++)//97-122
        {
            if (a.charAt(i) >= 65 && a.charAt(i) <= 90) {
                int c=(int)a.charAt(i)+32;//65+32=97  66+32=98  67+32=99 68+32=100
                a.setCharAt(i,(char)c);//abcd
            }
        }
        System.out.println("Lowercase Output: "+a);
 
 
    }
}
