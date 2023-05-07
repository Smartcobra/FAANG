package Move_Zeroes;

import java.util.Arrays;

////https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {
    public static int[] moveZeroes(int[] nums) {
        int n =nums.length;
        int[] ans= new int[n];

        int i=0;
        for(int num :nums){
            if(num!=0){
                ans[i]=num;
                i++;
            }
        }

        for(int num :nums){
            if(num==0){
                ans[i]=num;
                i++;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int [] nums={0,1,0,3,12};
        System.out.println(Arrays.toString(moveZeroes(nums)));

    }
}
