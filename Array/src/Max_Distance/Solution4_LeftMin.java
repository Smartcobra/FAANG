package Max_Distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4_LeftMin {

    public static int maximumGap(final List<Integer> A) {
        int n = A.size();
        int maxDiff = Integer.MIN_VALUE;
        int [] l_min = new int [n];
        l_min[0]=A.get(0);

        for(int i=1;i<n;i++){
            l_min[i]=Math.min(l_min[i-1],A.get(i));
        }
        int i=n-1; int j=n-1;

        while(i>=0 && j>=0){
            if(A.get(j) >=l_min[j]){
                maxDiff=Math.max(maxDiff,j-i);
                i--;
            }else{
                j--;
            }

        }


        return maxDiff;

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(
                // Arrays.asList(34, 8, 10, 3, 2, 80, 30, 33, 1));
                Arrays.asList(100, 100, 100, 100, 100));
        System.out.println(maximumGap(arr));

    }
}
