package Sum_The_Difference;

import java.util.ArrayList;
import java.util.Collections;

public class SumTheDifference {
    public static int solve(ArrayList<Integer> A) {
        int MOD = 1000 * 1000 * 1000 + 7;
        long minSum = 0;
        long maxSum = 0;
        int n = A.size();
        Collections.sort(A);
        for (int i = 0; i < n; i++) {
            maxSum = 2 * maxSum + A.get(n - i - 1);
            maxSum %= MOD;
            minSum = 2 * minSum + A.get(i);
            minSum %= MOD;
        }
        return (int) (maxSum - minSum) % MOD;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);

        ArrayList<Integer> B = new ArrayList<>();
        B.add(5);
        B.add(4);
        B.add(2);
        System.out.println(solve(B));
    }

}
