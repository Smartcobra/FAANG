package Find_SPF;


import java.util.Arrays;

///find smallest prime factor for given N
public class Solution {

    public static int[] findSmallestPrimeFactor(int N) {
        int[] spf = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= N; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= N; j = j + i) {   ///j=i*i searching for its multiple
                    spf[j] = Math.min(spf[j], i);
                }
            }
        }
        return spf;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSmallestPrimeFactor(25)));
    }
}
