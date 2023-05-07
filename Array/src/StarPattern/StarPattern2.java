package StarPattern;

import java.util.Scanner;

public class StarPattern2 {
    public static void main(String[] args) {
        Scanner scObj = new Scanner(System.in);
        int n = scObj.nextInt();
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < n; j++) {
                if (j < i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
//            for (int j = 0; j < n; j++) {
//                if (i + j >= n)
//                    System.out.print("*");
//                else
//                    System.out.print(" ");
//            }
            System.out.println();
        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (j < i)
//                    System.out.print("*");
//                else
//                    System.out.print(" ");
//            }
//            for (int j = 0; j < n; j++) {
//                if (i + j >= n)
//                    System.out.print("*");
//                else
//                    System.out.print(" ");
//            }
//            System.out.println();
//        }

    }
}