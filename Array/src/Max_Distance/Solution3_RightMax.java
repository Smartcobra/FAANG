package Max_Distance;


import java.util.*;

//o(n)
public class Solution3_RightMax {
    public static int maximumGap(final List<Integer> A) {
        int n = A.size();
        int maxDiff = Integer.MIN_VALUE;
        int min_i = Integer.MAX_VALUE;
        int [] r_max = new int [n];
        r_max[n-1]=A.get(n-1);

        for(int i=n-2;i>=0;i--){
            r_max[i]=Math.max(r_max[i+1],A.get(i));
        }
        int i=0; int j=0;

        while(i<n && j<n){
            if(r_max[j]>=A.get(i)){
                maxDiff=Math.max(maxDiff,j-i);
                j++;
            }else{
                i++;
            }

        }


        return maxDiff;

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(
               // Arrays.asList(34, 8, 10, 3, 2, 80, 30, 33, 1));
              //  Arrays.asList(100, 100, 100, 100, 100));
                Arrays.asList(100, 100, 100, 100, 100));

           //  Arrays.asList( 1, 10));

        System.out.println(maximumGap(arr));

    }
}
