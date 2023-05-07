package SubArrayOR;

import java.util.ArrayList;

public class SubArray_OR {

    public int solve(ArrayList<Integer> A) {
        long sum = 0;
        long sum1 = 0;
        int n=A.size();

        for (int i = 0; i < n; i++)
        {
            sum1 = 0;
            for (int j = i; j < n; j++)
            {
                // OR operation
                sum1 = (sum1 | A.get(j));
                sum = sum + sum1;
            }
        }

        return (int)sum%1000000007;
    }
}
