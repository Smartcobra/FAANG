package House_Robber;

public class HouseRobber_Space_O1 {
    public int rob(int[] nums) {
       int rob1=0;
       int rob2=0;

        for(int num:nums){
            int dp = Math.max(rob1,rob2+num);
            rob2=rob1;
            rob1=dp;
        }

        return rob1;

    }
}
