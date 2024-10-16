package Remove_Duplicates_from_Sorted_Array_II;

////https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int insertIdx=1;
        int count=1;

        for(int i=1;i<n;i++){
            if(nums[i-1]==nums[i]){
                count++;
            }else{
                count=1;
            }

            if(count<=2){
                nums[insertIdx++]=nums[i];
            }
        }

        return insertIdx;
    }

}
