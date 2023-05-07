package Pair_Sum_Divisible_by_M;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int solve(int[] A, int m) {
        int n=A.length;
        long ans=0;
        int mod=1000000007;
        int val=0;
        Map<Integer,Long> map= new HashMap<>();

        for(int i=0;i<n;i++){
            if(A[i]>0){
                val=A[i]%m;
            }else{
                val=(A[i]%m)+m;
            }
            map.put(val,map.getOrDefault(val,0l)+1l);
        }

        if(map.get(0)!=null){
            long k=map.get(0);
            k= k%mod;
            ans =(k*(k-1))/2;
        }

        int i=1;
        int j=m-1;

        while(i<j){
            if(map.get(i)!=null && map.get(j)!=null){
                ans= ans+(map.get(i)*map.get(j));
            }
            i++;j--;

        }

        if (m % 2 == 0) {
            if ((map.get(m / 2) != null)) {
                long k = map.get(m / 2);
                k = k % mod;
                ans += (k * (k - 1)) / 2;
            }

        }

        return (int)ans%mod;

    }

    public static void main(String[] args) {
//        int[] A = {5, 17, 100, 11};
//        int B = 28;

        int [] A= { 818, 63, 386, 563, 876, 855, 731, 933, 97, 935, 710, 27, 383, 975, 582, 188, 843, 569, 742, 834,
                859, 938, 894, 554, 31, 506, 679, 153, 191, 816, 716, 698, 352, 688, 586, 206, 228, 418, 543, 996, 918,
                55, 666, 133, 468, 494, 667, 596, 251, 189, 853, 15, 571, 794, 560, 835, 439, 923, 933, 789, 203, 527,
                106, 401, 623, 97, 661, 53, 1, 17, 773, 835, 191, 887, 568, 987, 667, 620, 52, 253, 334, 373, 427, 891,
                455, 186, 742, 375, 855, 288, 574, 67, 590, 628, 926, 260, 376, 110, 548, 40, 365, 398, 704, 328, 340, 927, 755, 356 };
        int B =96;

        System.out.println(solve(A, B));
    }
}
