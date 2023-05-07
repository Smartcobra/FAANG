package Smallest_XOR;

public class Solution3 {
    public static int smallestXOR(int A, int B) {
        int a = A;
        int X = A;
        int setBitsA = 0;

        while (a > 0) {
            if ((a & 1) == 1) setBitsA++;
            a = a >> 1;
        }

        if (B < setBitsA) {
            for (int i = 0; B != setBitsA; i++) {
                if (((A >> i) & 1) == 1) {
                    X = X - (1 << i);
                    setBitsA--;
                }
            }
            return X;
        } else if (B > setBitsA) {
            for (int i = 0; B != setBitsA; i++) {
               // if ((A & (1 << i)) == 0) {
                if (((A >> i) & 1) == 0) {
                    X = X + (1 << i);
                    setBitsA++;
                    // B++;
                }
            }
            return X;
        } else {
            return X;
        }

    }

    public static void main(String[] args) {
        System.out.println(smallestXOR(4,6));
    }
}
