package All_GCD_Pair;

import java.util.Arrays;

public class Solution {

    public static int[] solve(int[] A) {
        int n=A.length;
        Arrays.sort(A);
        int k=0;
        int [] result= new int [(int)Math.sqrt(n)];
        for(int i=1;i<n;i++){
            if(A[i-1]!=A[i]){
                result[k++]=A[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [] A= {1, 31, 1, 1, 1, 1, 14, 2, 1, 1, 1, 2, 22, 1, 11, 1, 1, 1, 1, 23, 1, 1, 11, 1, 11 };
        System.out.println(Arrays.toString(solve(A)));
    }
}
