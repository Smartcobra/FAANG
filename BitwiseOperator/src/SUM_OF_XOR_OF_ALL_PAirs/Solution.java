package SUM_OF_XOR_OF_ALL_PAirs;

import java.util.Arrays;

public class Solution {
    public static int getSum(int[] arr) {

        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < 31; i++) {
            int c = 0;
            for (int j : arr) {
                if (checkBit(j, i)) {
                    c++;
                }
            }
            sum = sum + (c * (n - c)) * (1 << i);
        }
        return sum*2;
    }

    public static boolean checkBit(int val, int i) {
        return ((val >> i) & 1) == 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5,3,2,8,9};
        System.out.println(getSum(arr));
    }
}
