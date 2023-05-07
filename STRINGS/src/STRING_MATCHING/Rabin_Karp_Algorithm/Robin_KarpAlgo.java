package STRING_MATCHING.Rabin_Karp_Algorithm;

public class Robin_KarpAlgo {
    public static int solve(String A, String B) {
            int n = A.length(), mod = 1000000007, cnt = 0;
            long hsa = 0, hsb = 0, pow = 1, pow1 = 1;
            for (int i = 0; i < n; i++) {
                if (i != 0)  pow = (31 * pow) % mod;
                hsa = (hsa + (A.charAt(i) - '0') * pow) % mod;
                hsb = (hsb + (B.charAt(i) - '0') * pow) % mod;

            }
            if (hsb == hsa) cnt++;
            for (int i = 0; i < n - 1; i++) {
                if (i != 0) pow1 = (31 * pow1) % mod;
                pow = (31 * pow) % mod;
                hsb = (hsb - (B.charAt(i) - '0') * pow1 + (B.charAt(i) - '0') * pow + mod) % mod;
                hsa = (31 * hsa) % mod;
                if (hsb == hsa) cnt++;
            }
            return cnt;
    }

    public static void main(String[] args) {
        // String A = "1101111111";
        // String B = "1101111111";
        String A1 = "0111111111";
        String B1 = "1111111101";
        System.out.println(solve(A1, B1));
    }
}

