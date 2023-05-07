package TWO_Unique_In_ARRAY;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_Bitwise {
    public static int[] getTwoUnique(int[] arr) {
        int length = arr.length;
        int[] result = new int[2];
        int k = 0;
        int pos = 0;

        int val = 0;
        for (int j : arr) {
            val ^= j;
        }

        for (int i = 0; i < 31; i++) {
            if (checkBit(val, i)) {
                pos = i;
                break;
            }
        }

        int set = 0;
        int unset = 0;
        for (int j : arr) {
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

    private static boolean checkBit(int val, int i) {
        return ((val >> i) & 1) == 1;

    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 4, 3, 8};
        System.out.println(Arrays.toString(getTwoUnique(arr)));
    }
}
