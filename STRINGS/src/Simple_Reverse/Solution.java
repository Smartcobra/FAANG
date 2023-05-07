package Simple_Reverse;

public class Solution {
    public static String solve(String A) {
        StringBuilder result = new StringBuilder();
        for (int i = A.length() - 1; i >= 0; --i) {
            char c = A.charAt(i);
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("scaler"));
    }
}
