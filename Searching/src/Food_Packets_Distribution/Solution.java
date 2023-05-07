package Food_Packets_Distribution;

public class Solution {
    public int solve(int[] A, int B) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int result = -1;
        for (int a : A) high = Math.min(high, a);

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(A, mid, B)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (result == -1) {
            return 0;
        } else {
            return result;
        }
    }

    public boolean isPossible(int[] A, int mid, int B) {
        int n = A.length;
        int office_count = 0;

        for (int i = 0; i < n; i++) {
            if (mid == 0) {
                office_count += A[i];
            } else {
                office_count += (A[i] / mid);
                // if(office_count>=B){
                //     return true;
                // }
            }
        }
        return office_count >= B;
    }
}
