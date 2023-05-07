package Decode_Ways;

import java.util.HashMap;

public class NumDecodings {
    public static int numDecodings(String A) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        return numDecodingsHelper(A, 0, dp);
    }

    public static int numDecodingsHelper(String str, int index, HashMap<Integer, Integer> dp) {
        int MOD = 1000 * 1000 * 1000 + 7;
        if (dp.containsKey(index)) {
            return dp.get(index);
        }
        if (index == str.length()) {
            return 1;
        }
        if (str.charAt(index) == '0') {
            return 0;
        }
        if (index == str.length() - 1) {
            return 1;
        }
        int ans = numDecodingsHelper(str, index + 1, dp);
        ans = ans % MOD;

        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans = ans + numDecodingsHelper(str, index + 2, dp);
            ans = ans % MOD;
        }
        dp.put(index, ans);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("10"));
    }
}
