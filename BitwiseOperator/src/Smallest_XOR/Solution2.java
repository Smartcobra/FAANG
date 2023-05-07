package Smallest_XOR;

public class Solution2 {
    public static int smallestXOR(int A, int B) {
        int a = A;
        int X = A;
        int setBitsA = 0;

        while (a > 0) {
            if ((a & 1) == 1) setBitsA++;
            a = a >> 1;
        }

        if (B < setBitsA) {
            int i = 0;
            while (B != setBitsA) {
                if (((A >> i) & 1) == 1) {
                    X = X - (1 << i);
                    setBitsA--;
                }
                i++;
            }
            return X;
        } else if (B > setBitsA) {
            int i = 0;
            while (B != setBitsA) {
                if ((A & (1 << i)) == 0) {
                    X = X + (1 << i);
                    setBitsA++;
                }
                i++;
            }
            return X;
        } else {
            return X;
        }

    }

    public static void main(String[] args) {
//        int a=10;
//        int b=5;
        int a = 4;
        int b = 6;
        System.out.println(smallestXOR(a, b));
    }

}

