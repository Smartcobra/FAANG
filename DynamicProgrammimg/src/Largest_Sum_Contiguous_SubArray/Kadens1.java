package Largest_Sum_Contiguous_SubArray;

public class Kadens1 {
    public static int getMaxSum(int arr[]) {
        int curSum = arr[0];
        int obvSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (curSum >= 0) {
                curSum = curSum + arr[i];
            } else {
                curSum = arr[i];
            }

            if (curSum > obvSum) {
                obvSum = curSum;
            }
        }
        return obvSum;
    }

    public static int getMaxSum2(int arr[]) {
        int curSum = arr[0];
        int obvSum = arr[0];
        int start = 0;
        int end = 0;
        int temp_start=0;

        for (int i = 1; i < arr.length; i++) {
            if (curSum >= 0) {
                curSum = curSum + arr[i];
            } else {
                curSum = arr[i];
                temp_start=i;
            }

            if (curSum > obvSum) {
                obvSum = curSum;
                start=temp_start;
                end=i;
            }
        }
        System.out.println(start +"--"+end);
        return obvSum;
    }

    public static void main(String[] args) {
        int arr[]= {-2,11,-4,13,-5,2};
        System.out.println(getMaxSum2(arr));
    }
}
