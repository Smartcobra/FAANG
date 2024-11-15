package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class Permutations_Swap {

    public static void permute(int[] nums) {
        int fi=0;
        permuteHelper(nums,fi);
    }

    public static void permuteHelper(int[] nums,int fi) {
       if(fi==nums.length-1){
           System.out.println(Arrays.toString(nums));
           return ;
       }

       for(int i=fi;i<nums.length;i++){
           swap(nums,i,fi);
           permuteHelper(nums,fi+1);
           swap(nums,i,fi);
       }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp= arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static void main(String[] args) {
        int[]  arr ={1,2,3};
        permute(arr);

    }
}
