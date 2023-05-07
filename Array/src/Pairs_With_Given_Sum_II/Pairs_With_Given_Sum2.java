package Pairs_With_Given_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Pairs_With_Given_Sum2 {
    public static int solve(List<Integer> A, int B) {
        int low = 0;
        int high = A.size() - 1;
        long ans = 0;
        int MOD= 1000 * 1000 * 1000 + 7;

        while (low < high) {
            int sum = A.get(low) + A.get(high);
            if (sum == B) {
                 if(!Objects.equals(A.get(low), A.get(high))){
                    long a=1;
                    while(low+1<high && Objects.equals(A.get(low), A.get(low + 1))){
                        a++;
                        low++;
                    }
                    long b=1;
                    while(high-1>low && Objects.equals(A.get(high), A.get(high - 1))){
                        b++;
                        high--;
                    }
                    ans=ans+(a*b)%MOD;
                    high--;
                    low++;
                }else{
                    long count=high-low+1;
                    //int cnt=
                    ans =(ans+ ((count*(count-1))/2)%MOD)%MOD;
                    break;
                }

            } else if (sum < B) {
                low++;
            } else {
                high--;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
       // List<Integer> l= Arrays.asList(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9);
       // int B=2;
        List<Integer> l= Arrays.asList(4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
                4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
                4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
                4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
                4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
                4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
                4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666);
        int B=9259332;
        System.out.println(solve(l,B));

    }
}
