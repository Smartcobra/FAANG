package Flip;

public class Solution {
    public static int[] flip(String A) {
        int n = A.length();
        int start = 0;
        int end = 0;
        int s = 0;
        int count = 0;
        int maxcount = Integer.MIN_VALUE;
        int[] result = new int[2];
        int zero = 0;

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') {
                zero++;
            }
        }
        if (zero == 0) {
            return new int[0];
        }
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') count--;
            if (A.charAt(i) == '0') count++;
            if (count > maxcount) {
                maxcount = count;
                start = s;
                end = i;
            }
            if (count < 0) {
                count = 0;
                s = i + 1;
            }
        }
        result[0] = start + 1;
        result[1] = end + 1;
        return result;

}


    public static void main(String[] args) {
        String s = "0111000100010";
        int[] flip = flip(s);
        System.out.println(flip[0] + " " + flip[1]);  ///5 11

    }
}
