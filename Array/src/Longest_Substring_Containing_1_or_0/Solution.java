package Longest_Substring_Containing_1_or_0;

public class Solution {

    public static int maxLength(String s) {
        int ones = maxLength_ones(s);
        int zeros = maxLength_Zeros(s);

        if(ones>zeros){
            return 1;
        }else{
            return 0;
        }
    }

    // Count the number of contiguous 1's
    public static int maxLength_ones(String s) {
        int n = s.length(), i, j;
        int ans = 0;
        for (i = 0; i <= n - 1; i++) {
            if (s.charAt(i) == '1') {
                int count = 1;
                for (j = i + 1; j <= n - 1 && s.charAt(j) == '1'; j++)
                    count++;
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
    // Count the number of contiguous 0's
    public static int maxLength_Zeros(String s) {
        int n = s.length(), i, j;
        int ans = 0;
        for (i = 0; i <= n - 1; i++) {
            if (s.charAt(i) == '0') {
                int count = 1;
                for (j = i + 1; j <= n - 1 && s.charAt(j) == '0'; j++)
                    count++;
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "11101110";
        System.out.println(maxLength(s));
        String s1 = "0000011101110";
        System.out.println(maxLength(s1));
        String s2 = "00111101011100000000001";
        System.out.println(maxLength(s2));

    }
}
