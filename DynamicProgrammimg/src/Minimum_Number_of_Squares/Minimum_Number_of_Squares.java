package Minimum_Number_of_Squares;

public class Minimum_Number_of_Squares {
    public static int getMinSquare(int N) {
        int result = N;
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (N == 3) return 3;

        if (isPerfectSquare(N)) {
            return 1;
        }

        for (int i = 1; i * i<N; i++) {
            result = Math.min(result, i + getMinSquare(N - i * i));
        }

        return result;
    }

    public static boolean isPerfectSquare(int N) {
        double sqr = Math.sqrt(N);
        return Math.floor(sqr) == sqr;
    }

    public static void main(String[] args) {
        System.out.println(getMinSquare(13));
    }
}
