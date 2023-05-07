package TWO_Missing_Number;

import java.util.Arrays;

public class Solution {
    public static int[] getMissingNumbers(int[] arr) {
        int n = arr.length;
        int set = 0;
        int unset = 0;
        int pos = 0;
        int val = 0;
        int[] result = new int[2];

        for (int i = 1; i <= n + 2; i++) {
            val = val ^ i;
        }

        for (int j : arr) {
            val = val ^ j;
        }

        for (int i = 0; i < 31; i++) {
            if (checkBit(val, i)) {
                pos = i;
                break;
            }
        }

        for (int j : arr) {
            if (checkBit(j, pos)) {
                set = set ^ j;
            } else {
                unset = unset ^ j;
            }
        }
        for (int j=1;j<=n+2;j++) {
            if (checkBit(j, pos)) {
                set = set ^ j;
            } else {
                unset = unset ^ j;
            }
        }

        result[0] = set;
        result[1] = unset;
        return result;

    }

    public static boolean checkBit(int val, int i) {
        return (((val >> i) & 1) == 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5,3,2,8,9};
        System.out.println(Arrays.toString(getMissingNumbers(arr)));
    }
}
