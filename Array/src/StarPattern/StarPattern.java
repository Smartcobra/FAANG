package StarPattern;

import java.util.Scanner;

public class StarPattern {
    public static void printStar(int n) {
        ////////////first half//////////
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (i + j < n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

                if (i + n <= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        ////////////second half//////////
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (i >= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

                if (i >=(2*n-j)-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStar(n);
    }
}
