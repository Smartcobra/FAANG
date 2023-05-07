package Math;

public class DpTest {
    public int getSum(int n) {
        int[] sum = new int[n + 1];

        if (n == 0 || n == 1) {
            return 2;
        }else{
            sum[0] = 2;
            sum[1] = 2;
        }


        for (int i = 2; i <= n; i++) {
            sum[i] = 0;
            for (int j = 1; j < i; j++) {
                sum[i] = sum[i] + 2 * sum[j] * sum[j - 1];
            }
        }
        return sum[n];
    }

    public static void main(String[] args) {
        DpTest dt = new DpTest();
        System.out.println(dt.getSum(3));
    }
}
