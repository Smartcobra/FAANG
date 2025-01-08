package Find_Power_K_Size_Subarrays_I;
//https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/

/*
[1,2,3,4,3,2,5], k = 3
ans array length will be  n-k+1 => 7-3+1 = 5
ist window  [ 1 2 3 ]
              i   j     as consucutive j should have max element  ans =[ 3 -1 -1 -1 -1 ]
             [ 2 3 4 ]
               i   j     as consucutive j should have max element  ans =[ 3 4 -1 -1 -1 ]

 */

/*
[1,2,3,4,3,2,5,6,7], k = 3
  for window  [ 2 5 6] => although 5+1 = 6 , makes consucutive but the whole window is not
  to handle this type of situation take a counter and initial to k if in first window makes consucutive



 */


import java.util.Arrays;

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Arrays.fill(result, -1);
        int count = 1;

        for (int i = 1; i < k; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count == k) {
            result[0] = nums[k-1];
        }

        int i=1;
        int j=k;
        while(j<n){
            if(nums[j-1]+1 == nums[j]){
                count++;
            }else{
                count=1;
            }

            if (count >= k) {   // because if first window sorted then count =3 if k=3, then for next window if sorted then count will increase
                result[i] = nums[j];
            }
            i++;
            j++;
        }

        return result;
    }
}