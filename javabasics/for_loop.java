package javabasics;

import java.util.Scanner;

public class for_loop {
        public static void main(String args[])
    {
        System.out.println("Enter The Limit : ");
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        for(int i=1;i<=n;i++)
        {
            System.out.println(i);
        }
    }
}
