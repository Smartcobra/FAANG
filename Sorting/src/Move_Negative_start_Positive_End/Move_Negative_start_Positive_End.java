package Move_Negative_start_Positive_End;


import java.util.Arrays;

/*
* An array contains both positive and negative numbers in random order. Rearrange the array elements so that all negative numbers appear before all positive numbers.

Examples :

    Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
    Output: -12 -13 -5 -7 -3 -6 11 6 5
*
* */
public class Move_Negative_start_Positive_End {

    public static int[] reArrange(int[] arr) {
        int n = arr.length;
        int l = 0;
        int h = n - 1;

        while (l <= h) {
            if (arr[l] < 0) {
                l++;
            } else {
                swap(arr, l, h);
                h--;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int l, int h) {
        int tmp = arr[h];
        arr[h] = arr[l];
        arr[l] = tmp;
    }

    public static void main(String[] args) {
        int[] ar = { 1, 2,  -4, -5, 2, -7, 3, 2, -6, -8, -9, 3, 2,  1 };
        System.out.println(Arrays.toString(reArrange(ar)));

        int[] ar2 = { 1, 2,  -4, -5, 2, -7, 3, 2, -6, -8, -9, 3, 2,  1,0 };
        System.out.println(Arrays.toString(reArrange(ar2)));

    }

}
