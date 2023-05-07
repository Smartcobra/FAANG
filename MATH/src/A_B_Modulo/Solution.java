package A_B_Modulo;

public class Solution {
///need to check not working properly
    public static int getMaxModulo(int A, int B) {
        int dif = 0;
        if (A > B) {
            dif = A - B;
        } else {
            dif = B - A;
        }
        int tmp=0;
        int tmp2=0;
        int tmp3=0;
        int max=0;

        for (int i = 1; i * i < dif; i++) {
            if (dif % i == 0) {
                if (dif / i == i) {
                    //System.out.println(i);
                    tmp=i;
                } else {
                   // System.out.println(i + " " + dif / i);
                    tmp2=i;
                    tmp3=dif/i;
                }
            }
            max=Math.max(tmp,Math.max(tmp2,tmp3));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMaxModulo(6816621,8157697));
    }
}
