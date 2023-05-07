package Power;

public class Solution {
    public static int pow(int A, int B, int C) {
        if (A == 0) {
            return 0;
        }
        if (B == 0) {
            return 1;
        }

        long he = pow(A, B / 2, C);

        long ha = ((he % C) * (he % C)) % C;

        if ((B & 1) != 1) {
            return (int) (ha);

        } else {
            if (A < 0) {
                return C + (int) ((ha % C * A % C) % C);
            } else {
                return (int) ((ha % C * A % C) % C);
            }
        }
    }

    public static void main(String[] args) {
        int A = 71045970;
        int B = 41535484;
        int C = 64735492;

        System.out.println(pow(A,B,C));

    }
}
