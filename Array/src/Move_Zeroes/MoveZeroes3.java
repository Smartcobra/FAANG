package Move_Zeroes;

import java.util.Arrays;

////https://leetcode.com/problems/move-zeroes/
public class MoveZeroes3 {
    public static void moveZeroes(int[] nums) {
        int n =nums.length;

        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i] !=0){
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                j++;

            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int [] nums={0,1,0,3,12};
        moveZeroes(nums);

    }
}
