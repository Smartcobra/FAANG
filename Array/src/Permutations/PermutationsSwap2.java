package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/permutations/
public class PermutationsSwap2 {
    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>>  permute(int[] nums) {

        permuteHelper(nums, 0);
        return ans;
    }

    public static void permuteHelper(int[] arr, int fi) {
        /**
         *  the below is making slow as creating object
         */
//        if (fi == arr.length - 1) {
//            ans.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
//            return;
//        }

        if (fi == arr.length - 1) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : arr) {
                permutation.add(num);
            }
            ans.add(permutation);
            return;
        }

        for (int i = fi; i < arr.length; i++) {  //  we are picking one number from the given number
            swap(arr, i, fi);
            permuteHelper(arr, fi + 1);
            swap(arr, i, fi);
        }
    }

    private static  void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[]  arr ={1,2,3};
        List<List<Integer>> permute = permute(arr);
        System.out.println(permute);
    }
}
