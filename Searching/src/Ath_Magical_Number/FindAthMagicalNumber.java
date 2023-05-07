package Ath_Magical_Number;

public class FindAthMagicalNumber {
    public static int solve(int A, int B, int C) {

        long low = 0;
        long high = (long) Math.min(B, C) * A;
        long lcm = lcm(B, C);
        long ans = 0;
        int MOD = 1000 * 1000 * 1000 + 7;

        while (low <= high) {
            long mid = (low + high) / 2;
            long b= mid / B;
            long c=mid / C;
            long m=mid / lcm;
            long count=b+c-m;

            if (count < A) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return (int)(ans%MOD);

    }

    public static long gcd(int B, int C) {
        if (B == 0) return C;

        return gcd(C % B, B);
    }

    public static long lcm(int B, int C) {
        long gcd = gcd(B, C);
        return ((long) B * C) / gcd;
    }

    public static void main(String[] args) {
        int A = 807414236;
        int B = 3788;
        int C = 38141;
        System.out.println(solve(A,B,C));
    }
}
