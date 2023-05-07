package Jump_Game;


////https://leetcode.com/problems/jump-game/


/*
*  [2,3,1,1,4]
*  we need to think what max step we can jump from an index , let max_jump=0; at index-0 we can max_jump=Math(max_jump,i+A[i]);
* if we reached at end max jump should be greater than or equal to i;  if any point i>max_jump then we can not reach end
*
*
*
*
* */
public class JumpGame {
    public boolean canJump(int[] nums) {

        int n=nums.length;
        int max_jump=0;
        for(int i=0;i<n;i++){
            if(i>max_jump){
                return false;
            }

            max_jump=Math.max(max_jump,i+nums[i]);
        }

        return true;
    }
}
