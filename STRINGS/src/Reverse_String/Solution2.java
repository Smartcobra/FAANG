package Reverse_String;

public class Solution2 {

    public static String reverseWord(String str) {
        int i = 0;
        int n = str.length();
        String result = "";

        while (i < n) {
            while (i < n && str.charAt(i) == ' ') i++;
            if (i >= n) break;

            int j = i + 1;
            while (j < n && str.charAt(j) != ' ') j++;

            String substring = str.substring(i, j);

            if (result.length() == 0) {
                result = substring;
            } else {
                result = substring + " " + result;
            }
            i = j + 1;
        }
        return result;

    }

    public static void main(String[] args) {
        String  A = "the sky is blue";
        System.out.println(reverseWord(A));
    }
}
