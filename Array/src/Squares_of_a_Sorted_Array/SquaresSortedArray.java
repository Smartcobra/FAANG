package Squares_of_a_Sorted_Array;


import java.util.Arrays;

////////https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresSortedArray {

    public static int[] sortedSquares(int[] nums) {
        int i=nums.length;
        int l=0;
        int r=i-1;

        int[] ans= new int[i];

        while(l<=r){
            if(nums[l]*nums[l] > nums[r]*nums[r]){
                ans[i-1]=nums[l]*nums[l];
                i--;
                l++;
            }else{
                ans[i-1]=nums[r]*nums[r];
                i--;
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int [] arr= {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }
}
