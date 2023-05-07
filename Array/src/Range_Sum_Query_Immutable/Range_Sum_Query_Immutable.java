package Range_Sum_Query_Immutable;


////https://leetcode.com/problems/range-sum-query-immutable/
public class Range_Sum_Query_Immutable {

    private int[] sum;
    public Range_Sum_Query_Immutable(int[] nums) {
        sum= new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=sum[i-1]+nums[i];
        }

    }

    public int sumRange(int left, int right) {
        int result=0;
        if(left!=0){  // for handel special case ,left=0
            result=sum[right]-sum[left-1];
        }else{
            result=sum[right];
        }

        return result;
    }
/*
                * Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
*
* */
}
