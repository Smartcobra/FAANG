package Max_Product_Subarray;

import java.util.ArrayList;
import java.util.List;

public class MaxProductSubarray {
    public static int maxProduct(final List<Integer> A) {
        if (A.size() == 0) return 0;
        int n=A.size();
        int max_soFar=A.get(0);
        int minSoFar=A.get(0);
        int result=max_soFar;

        for (int i=1;i<n;i++) {
            int curr=A.get(i);
            int t_max_soFar = Math.max(curr, Math.max(max_soFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.max(max_soFar * curr, minSoFar * curr));
            max_soFar=t_max_soFar;
            result=Math.max(max_soFar,result);

        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(-2);
        System.out.println(maxProduct(A));
    }
}
