package Maximum_Sum_Value;

import java.util.ArrayList;

public class Maximum_Sum_Value {
    public static int solve(ArrayList<Integer> A, int B, int C, int D) {
        int n = A.size();
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int curr_sum = B * A.get(i) + C * A.get(j) + D * A.get(k);
                    maxSum = Math.max(maxSum, curr_sum);
                }
            }
        }
        return maxSum;

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
        System.out.println(solve(list,B,C,D));
    }
}
