package Find_Minimum_in_Rotated_Sorted_Array;
///https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumRotatedSortedArray {
  ///finding the pivot element
    //All the elements to the left of pivot point > first element of the array.
  //All the elements to the right of pivot point < first element of the array.
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        int k=0;

        while(l<=h){
            int mid = (l+h)/2;

            if(nums[mid] < nums[0] ){       /// if mid element < first element then we can find more less element toward 0th index
                k = mid;
                h = mid-1;
            } else{
                l = mid+1;
            }

        }

        return nums[k];

    }
}
