package StarPattern;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = 0, temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) System.out.print("*");
            temp = x;
            while (temp-- > 0) System.out.print(" ");
            for (int j = n; j > i; j--) System.out.print("*");
            x += 2;
            System.out.println();
        }

        x = 2 * n - 2;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j > i; j--) System.out.print("*");
            temp = x;
            while (temp-- > 0) System.out.print(" ");
            for (int j = n; j > i; j--) System.out.print("*");
            x -= 2;
            System.out.println();
        }
        sc.close();

    }

}

