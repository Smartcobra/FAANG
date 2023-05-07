package Range_Sort_Query;

public class Optimize_Solution {

    public static boolean[] isIncreasing(int[] arr, int[][] q) {
        int n = arr.length;
        int m = q.length;

        int[] bool = new int[n];
        boolean[] ans = new boolean[m];
        int[] prefix = new int[n];


        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                bool[i] = 1;
            } else {
                bool[i] = 0;
            }
        }

        prefix[0] = bool[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + bool[i];
        }

        for (int j = 0; j < m; j++) {
            int l = q[j][0];
            int r = q[j][1];
            int e_sum = r - l;
            int a_sum=0;
            if (l == 0) {
                a_sum= prefix[r - 1];
            } else {
                 a_sum = prefix[r - 1] - prefix[l - 1];
            }


            if (e_sum != a_sum) {
                ans[j] = false;
            } else {
                ans[j] = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 4, 6, 2, 8, 6, 5, 10, 12, 14, 16, 9};
        int[][] B = {{0, 3}, {0, 4}, {4, 7}, {7, 11}};

        boolean[] ans = isIncreasing(A, B);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }
}
