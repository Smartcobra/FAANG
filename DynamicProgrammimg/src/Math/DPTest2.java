package Math;

public class DPTest2 {
    public int getSum(int n) {
        int sum[] = new int[n + 1];
        sum[0] = 2;
        sum[1] = 2;
        sum[2] = 2 * sum[0] * sum[1];

        for (int i = 3; i <= n; i++) {
            sum[i] = sum[i - 1] + (2 * sum[i - 1] * sum[i - 2]);
        }
        return sum[n];
    }

    public static void main(String[] args) {
        DPTest2 dt = new DPTest2();
        System.out.println(dt.getSum(3));
    }
}
