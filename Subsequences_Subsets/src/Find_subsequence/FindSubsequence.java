package Find_subsequence;

public class FindSubsequence {
    public static String solve(String A, String B) {
        int a = A.length();
        int b = B.length();
        int i = 0;
        int j = 0;

        while (i < a && j < b) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
            } else {
                j++;
            }
        }

        if (i == a) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        String A = "bit";
        String B = "dfbkjijgbbiihbmmt";
        System.out.println(solve(A,B));
    }

}
