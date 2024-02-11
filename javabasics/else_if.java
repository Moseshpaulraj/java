package javabasics;

import java.util.Scanner;

public class else_if {
        public static void main(String args[]) {
        float avg;
        System.out.println("Enter The Average Mark : ");
        Scanner in = new Scanner(System.in);
        avg = in.nextFloat();
        if (avg >= 90 && avg <= 100) {
            System.out.println("Grade A");
        } else if (avg >= 80 && avg <= 89) {
            System.out.println("Grade B");
        } else if (avg >= 70 && avg <= 79) {
            System.out.println("Grade C");
        } else {
            System.out.println("Grade D");
        }
    }
}
