package Move_Zeroes;

import java.util.Arrays;

////https://leetcode.com/problems/move-zeroes/
public class MoveZeroes2 {
    public static void moveZeroes(int[] nums) {
        int n =nums.length;

        int i=0;
        for(int num :nums){
            if(num!=0){
                nums[i]=num;
                i++;
            }
        }

       while (i<n){
           nums[i]=0;
           i++;
       }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int [] nums={0,1,0,3,12};
        moveZeroes(nums);

    }
}
