package Total_Number_Of_SET_Bits;

public class Solution {
    public static int solve(int A) {
        int ans = 0;
        if (A == 0) {
            return 0;
        }

        int mod = 1000000007;
        int x = getMaxPower(A);
        int bitstill2X = x * (1 << (x - 1));
        int restMSBSetBits = A - (1 << x) + 1;
        int rest = A - (1 << x);

        ans = bitstill2X + restMSBSetBits + solve(rest);

        return ans % mod;
    }

    public static int getMaxPower(int A) {
        int x = 0;
        while ((1 << x) <= A) {
            x++;
        }
        return x - 1;

    }

    public static void main(String[] args) {
        int A=5;

        System.out.println(solve(A));
    }
}
