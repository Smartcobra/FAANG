package SwapToFindMaxLength1;

public class MaxLengthOfONEs {

    public static int solve(String str) {
        int ans = 0;
        int count_1 = 0;

        int n = str.length();

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1') {
                count_1++;
            }
        }
        if (count_1 == n) {
            return count_1;
        }

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0') {
                //////left
                int l = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (str.charAt(j) == '1') {
                        l++;
                    } else {
                        break;
                    }
                }

                ///right
                int r = 0;
                for (int j = i + 1; j < n; j++) {
                    if (str.charAt(j) == '1') {
                        r++;
                    } else {
                        break;
                    }
                }
                ////
 //////////////////////if ask for replace any zero with one simply return l+r+1;
                if (l + r == count_1) {
                    ans = Math.max(ans, l + r);
                } else {
                    ans = Math.max(ans, l + r + 1);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        // String str = "010100110101";
        // String str="1101001100101110";
        String str = "01";
        //String str="010100110101";
        // String str="111000";
        //  String str="000000111";
        System.out.println(solve(str));
    }
}