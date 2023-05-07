package Lucky_Numbers;

import java.util.Arrays;

public class Solution {

    public static int[] getSieve(int A){
        int []prime = new int [A+1];
        for (int i=2;i<=A;i++){
            if (prime[i]==0){
                for (int j=i;j<=A;j=j+i){
                    prime[j]++;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSieve(15)));
    }
}
