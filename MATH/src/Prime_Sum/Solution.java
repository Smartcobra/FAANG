package Prime_Sum;

import java.util.Arrays;

public class Solution {
    public static boolean[] isPrime(int N) {
        boolean[] prime = new boolean[N + 1];
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= N; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= N; j = j + i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    public static int[] primesum(int A) {
        int[] result = new int[2];
        boolean[] isPrime = isPrime(A);
        for (int i = 0; i <= A; i++) {
            if (isPrime[i] && isPrime[A - i]) {
                result[0] = i;
                result[1] = A - i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(isPrime(25)));
        System.out.println(Arrays.toString(primesum(74)));
    }
}
