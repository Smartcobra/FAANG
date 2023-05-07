package Range_Sort_Query;

public class BruteForce {

    public static boolean[] rangeIncreasing(int[] A, int[][] B) {

        int n = A.length;
        int m = B.length;
        boolean[] ans = new boolean[m];


        for (int i = 0; i < m; i++) {
            int l = B[i][0];
            int r = B[i][1];

            for (int j = l; j < r; j++) {
                if (A[j] >= A[j + 1]) {
                    ans[i] = false;
                    break;
                } else {
                    ans[i] = true;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 4, 6, 2, 8, 6, 5, 10, 12, 14, 16, 9};
        int[][] B = {{0, 3}, {0, 4}, {4, 7}, {7, 11}};

        boolean[] ans = rangeIncreasing(A, B);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }
}
