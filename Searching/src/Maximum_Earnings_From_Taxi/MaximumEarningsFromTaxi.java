package Maximum_Earnings_From_Taxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

////https://leetcode.com/problems/maximum-earnings-from-taxi/
public class MaximumEarningsFromTaxi {
    public static long maxTaxiEarnings(int n, int[][] rides) {
        Map<Integer, List<int[]>> rideMap = new HashMap<>();

        long [] dp = new long[n+1];

        List<int[]> value = null;
        for (int[] ride : rides) {
            value = rideMap.computeIfAbsent(ride[1], k -> new ArrayList<>());
            value.add(ride);
        }

        for(int i=1;i<n+1;i++){
            dp[i] =dp[i-1];
            if(rideMap.containsKey(i)){
                for(int[] ride: rideMap.get(i)){
                    dp[i] = Math.max(dp[i],ride[1]-ride[0]+ride[2]+dp[ride[0]]);

                }
            }

        }

        return dp[n];
    }

    public static void main(String[] args) {
     int[][] rides ={{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}};
        maxTaxiEarnings(20,rides);
    }

}
