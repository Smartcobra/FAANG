package Find_A_Peak_Element;

public class Solution {
    public static int solve(int[] A) {

        int n = A.length;
        if (n == 1) return A[0];
        if (A[0] > A[1]) return A[0];
        if (A[n - 1] >= A[n - 2]) return A[n - 1];

        int l = 1;
        int h = n - 2;


        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return A[mid];
            else if (A[mid] < A[mid + 1]) l = mid + 1;
            else h = mid - 1;
        }

        return 0;
    }


    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(solve(A));

    }
}
