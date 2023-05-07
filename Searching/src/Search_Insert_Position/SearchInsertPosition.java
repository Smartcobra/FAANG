package Search_Insert_Position;
////https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
        public int searchInsert(int[] nums, int target) {

            int l =0;
            int h = nums.length-1;
            int ans = 0;

            while(l<=h){
                int mid = l +(h-l)/2;

                if(nums[mid]==target) {
                    return mid;
                }else if(nums[mid] < target){
                    l = mid+1;

                }else{
                    h = mid-1;
                }
            }

            return l;

        }

}
