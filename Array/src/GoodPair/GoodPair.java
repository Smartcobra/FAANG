package GoodPair;

import java.util.Scanner;

public class GoodPair {
    public static int solve(int[] arr, int B) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1 + i; j < arr.length; j++) {
                if (arr[i] + arr[j] == B) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int B = sc.nextInt();
        int result = solve(arr, B);
        System.out.print(result);

    }
}
