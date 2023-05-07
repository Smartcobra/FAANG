package Smallest_XOR;

public class Solution {

    public static int solve(int A, int B) {
        int ans = 0;
      //  int setBits = B;
        int setBits = countSetBits(A);

        for (int i = 30; i >= 0; i--) {
            int mask = 1 << i;
            if ((mask & A)>0 && setBits > 0) {
                ans |= (1 << i);
                setBits--;
            }

        }
        return ans;
    }

//  //  public static  boolean checkSetBit(int val, int i) {
//        return ((val >> i) & 1) == 1;
//    }

    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0)
        {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
//        int A = 4;
//        int B = 6;

        int A = 3, B = 3;


        System.out.println(solve(A,B));
    }
}
