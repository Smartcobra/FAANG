package LittlePonny_AND_TWO_Subsequence;

public class Solution {
    /*
     * So for this problem we just have to get the string of length 2, this will ease our work.
     *
     *
     * */
    public static String solve(String A) {
        //so the solution is  taking a variable char type and assigning a value ‘z’ and int variable idx to store the index
        char minChar1 = 'z';
        char minChar2 = 'z';
        int idx = 0;

        //loop till n-1: because we are considering first element
        for (int i = 0; i < A.length() - 1; i++) {
            if (A.charAt(i) < minChar1) {
                minChar1 = A.charAt(i);
                idx = i;
            }
        }
        ///loop from idx+1 to n to find minChar2
        for (int i = idx + 1; i < A.length(); i++) {
            if (A.charAt(i) < minChar2) {
                minChar2 = A.charAt(i);
            }
        }
        return minChar1 +String.valueOf(minChar2);
    }

    public static void main(String[] args) {
        System.out.println(solve("scsecugqsb"));
        System.out.println(solve("epujxwjiad"));
    }
}
