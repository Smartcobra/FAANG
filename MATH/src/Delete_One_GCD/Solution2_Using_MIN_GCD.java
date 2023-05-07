package Delete_One_GCD;

public class Solution2_Using_MIN_GCD {

    public static int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        int index = 0;
        int gcd_tmp = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            gcd_tmp = gcd(gcd_tmp, A[i]);

            if (gcd_tmp < min) {
                min = gcd_tmp;
                index = i;
            }
        }
        System.out.println("min::"+min);
        System.out.println("index:::"+index);

        for (int i = 0; i < n; i++) {
            if (i != index) {
                ans = gcd(ans, A[i]);
            }
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int [] A={ 3, 9, 6, 8, 3};
        System.out.println(solve(A));
    }
}
