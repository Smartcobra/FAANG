package Largest_Sum_Contiguous_SubArray;

public class KadenAlgo2 {
    public static int getMax(int arr[], int start, int end) {
        int sum = 0;
        int max_sum = Integer.MIN_VALUE;
        end = -1;
        int temp_start = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum < 0) {
                sum = 0;
                temp_start = i + 1;

            } else if (sum > max_sum) {
                max_sum = sum;
                start = temp_start;
                end = i;
            }
        }
        System.out.println(start + "-"+end);

        return max_sum;
    }

    public static void main(String[] args) {
        int arr[]= {-2,11,-4,13,-5,2};
        System.out.println(getMax(arr,0,arr.length));
    }
}
