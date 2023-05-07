package RainWater;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class LeftMax {
    public static int[] getLeftMax(int[] arr) {


        int[] leftMaxArr = new int[arr.length];
        int leftMax = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            leftMaxArr[i] = leftMax;
            leftMax = Math.max(leftMax, cur);

        }
        return leftMaxArr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};

        int[] leftMax = getLeftMax(arr);
        for (Integer i : leftMax
        ) {
            System.out.print(i + " ");
        }


    }
}
