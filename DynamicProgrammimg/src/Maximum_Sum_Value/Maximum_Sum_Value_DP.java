package Maximum_Sum_Value;

import java.util.ArrayList;

public class Maximum_Sum_Value_DP {
    public static int solve(ArrayList<Integer> A, int B, int C, int D) {
        int n = A.size();
        int L[] = new int[n];
        L[0] = B * A.get(0);
        for (int i = 1; i < n; i++) {
            L[i] = Math.max(L[i - 1], B * A.get(i));
            L[i] = B * A.get(i);
        }

        // Compute right maximum for every index.
        int R[] = new int[n];
        R[n - 1] = D * A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.max(R[i + 1], D * A.get(i));
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, L[i] + C * A.get(i) +
                    R[i]);

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(-3);
        list.add(4);
        list.add(-2);
        int B = 2;
        int C = 1;
        int D = -1;
        System.out.println(solve(list, B, C, D));
    }
}
