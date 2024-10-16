package Remove_Duplicates_from_Sorted_Array;

////https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int n=nums.length;

        if(n==0) return 0;

        int insertIndex=1;

        for(int i=1;i<n;i++){
            if(nums[i-1] !=nums[i]){
                nums[insertIndex]=nums[i];
                insertIndex++;
            }
        }

        return insertIndex;

    }
}
