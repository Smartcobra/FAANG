package SubArraySum;

import java.util.ArrayList;

public class Subarray_Size_K_FindIndex {

    public static  int solve(int [] arr, int B) {

        int min = Integer.MAX_VALUE;
        int j = 0;
        int i = 0;
        int sum = 0;
        int index = 0;

        while (j < arr.length) {
            sum = sum + arr[j];
            if (j - i + 1 == B) {

                if (sum < min) {
                    min = sum;
                    index = i;
                }
                sum = sum -arr[i];
                i++;
            }

            j++;
        }
        return index;
    }

    public static void main(String[] args) {
        int [] arr= { 18, 11, 16, 19, 11, 9, 8, 15, 3, 10, 9, 20, 1, 19 };
       int b=3;
        System.out.println(solve(arr,b));

    }
}
