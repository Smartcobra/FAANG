package longest_Increasing_SubSequences;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public int getLIS(int arr[]){
        int n=arr.length;
        if(arr.length == 0){
            return 0;
        }
        int[] dp = new int [n+1];

        dp[0]=1;
          for(int i=1;i<n;i++){
              for(int j=0;j<i;j++){
                  if(arr[i]>arr[j] && dp[j]>dp[i]){
                      dp[i] = dp[j];
                  }
              }
              dp[i]++;
          }
          return Arrays.stream(dp).max().getAsInt();

    }

    public static void main(String[] args) {
            int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        LongestIncreasingSubSequence li= new LongestIncreasingSubSequence();
            System.out.print("The length of the LIS is " +li.getLIS(arr));
        }

}
