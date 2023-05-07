package reverse_Number;
//https://leetcode.com/problems/reverse-integer/
public class Reverse_Number_HandelOverFlow {

    public static int reverse(int num) {

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int res = 0;

        while (num != 0) {
            int rem = num % 10;

            if (res > max / 10 || (res == max / 10 && rem >= 7)) return 0;
            if (res < min / 10 || (res == min / 10 && rem < -8)) return 0;

            res = res * 10 + rem;
            num = num / 10;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
