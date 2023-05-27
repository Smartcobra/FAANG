package Sort_0_1_2;
///https://leetcode.com/problems/sort-colors/
public class Sort012 {

    public void sortColors(int[] nums) {
        int n= nums.length;
        int zeroS=0;
        int oneS=0;
        int twoS=0;

        for (int num : nums) {
            if (num == 0) {
                zeroS++;
            } else if (num == 1) {
                oneS++;
            } else {
                twoS++;
            }
        }

        for(int i=0;i<n;i++){
            if(i<zeroS){
                nums[i]=0;
            } else if (i<zeroS+oneS) {
                nums[i]=1;
            }else {
                nums[i]=2;
            }
        }

    }
}
