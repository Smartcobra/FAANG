package Find_Nth_Magic_Number;

public class Solution {
    public static int solve(int A) {
        int i = 0;
        int result = 0;

        while (A != 0) {
            if ((A & 1) == 1) {
                int x = (int) Math.pow(5, i + 1);
                result += x;
            }
            A = A >> 1;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(10));
    }
}
