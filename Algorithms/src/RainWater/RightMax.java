package RainWater;

public class RightMax {
    public static int[] getRightMax(int[] arr) {

        int[] rightMaxArr = new int[arr.length];
        int rightMax = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int cur = arr[i];
            rightMaxArr[i] = rightMax;
            rightMax = Math.max(rightMax, cur);

        }
        return rightMaxArr;

    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};

        int[] leftMax = getRightMax(arr);
        for (Integer i : leftMax
        ) {
            System.out.print(i + " ");
        }


    }
}
