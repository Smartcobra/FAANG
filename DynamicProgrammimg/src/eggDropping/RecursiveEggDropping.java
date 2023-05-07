package eggDropping;

public class RecursiveEggDropping {
    public static int eggDrop(int e, int f) {

        if (e == 0) {
            return f;
        }

        if (f == 0 || f == 1) {
            return f;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= f; i++) {
            int res = 1 + Math.max(eggDrop(e - 1, i - 1), eggDrop(e, f - i));

            if (res < min) {
                min = res;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int n = 2, k = 10;
        System.out.print(eggDrop(n, k));
    }

}
