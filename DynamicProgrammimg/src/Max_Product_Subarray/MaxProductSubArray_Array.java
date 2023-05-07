package Max_Product_Subarray;
///https://leetcode.com/problems/maximum-product-subarray/
public class MaxProductSubArray_Array {

    public int maxProduct(int[] nums) {
        int n= nums.length;
        int currMin = nums[0];
        int currMax=nums[0];
        int result=nums[0];

        for(int i=1;i<n;i++){
            int num= nums[i];

            int tmp_max= Math.max(num, Math.max(currMin*num, currMax*num));
            currMin= Math.min(num, Math.min(currMin*num, currMax*num));

            currMax=tmp_max;

            result= Math.max(result,currMax);

        }

        return result;
    }
}
