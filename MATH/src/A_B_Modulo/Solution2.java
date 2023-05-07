package A_B_Modulo;

public class Solution2 {

    public static int solve(int A, int B) {
        int min=Math.min(A,B);
        int max=Math.max(A,B);
        //return Math.abs(A-B);
        return max-min;
    }

    public static void main(String[] args) {
        int A=6816621;
        int B=8157697;
        System.out.println(solve(A,B));
    }
}
