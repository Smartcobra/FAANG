package Prime_Subtraction_Operation;

//https://leetcode.com/problems/prime-subtraction-operation/description/
class Solution {
    boolean[] prime = new boolean[1001];
    public Solution() {
        sieve();
    }
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {

            if(nums[i] <nums[i+1]){
                continue;
            }

            for(int j=2;j<nums[i];j++){
                if (!prime[j]){
                    continue;
                }

                if(nums[i] -j < nums[i+1]){
                    nums[i] -=j;
                    break;
                }
            }

            if(nums[i] >= nums[i+1]){
                return false;

            }
        }
        return true;
    }

    public void sieve() {
        for (int i = 0; i < 1001; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i < 1001; i++) {
            if (prime[i]) {
                for (int p = i * i; p < 1001; p = p + i) {
                    prime[p] = false;
                }
            }
        }
    }


}