package SubsetSumProblem;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintSubSets_2 {
    public void printSubset(int arr[], int i, int j) {
        System.out.println(IntStream.range(i,j+1)
                .mapToObj(k->arr[k])
                .collect(Collectors.toList()));
    }

    public void getSubSets(int arr[], int sum) {
        if (arr.length == 0) {
            System.out.println("Array cant be null");
        }

        if (sum == 0) {
            System.out.println("sum cant be 0");
        }

        for (int i = 0; i < arr.length; i++) {
            //current sum
            int sum_SoFar = 0;
            // consider all subarrays starting from `i` and ending at `j`
            for (int j = i; j < arr.length; j++) {
                sum_SoFar = sum_SoFar + arr[j];

                if (sum_SoFar == sum) {
                    printSubset(arr, i, j);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, -7, 1, 3, 3, 1, -4 };
        int target = 7;
        PrintSubSets_2 printSubSets_2 = new PrintSubSets_2();
        printSubSets_2.getSubSets(nums, target);
    }
}
