package Prime_Subsequences;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2; i*i <= n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    public static int solve(ArrayList<Integer> A) {
        int count = 0;
        int ans = 0;
        int mod = 1000000007;
        for(int i=0; i<A.size();i++){
            if(isPrime(A.get(i))){
                ans = (int) ((ans%mod+ Math.pow(2, count)%mod)%mod);
                //System.out.println(A.get(i));
                count++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] A= {1, 2, 3};
        int[] ints = {1, 2, 3};
        ArrayList<Integer> intList = new ArrayList<Integer>(ints.length);
        for (int i : ints)
        {
            intList.add(i);
        }
        System.out.println(solve(intList));
    }
}
