package Seats;


//https://www.scaler.com/academy/mentee-dashboard/class/35027/assignment/problems/282?navref=cl_tt_lst_nm
public class Seats {
    public static int seats(String A) {
        int n = A.length();
        int k = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'x') {
                k++;
            }
        }

        for (int j = 0; j < n - k; j++) {
            int hops = 0;
            int p = j;
            for (int i = 0; i < n; i++) {
                if (A.charAt(i) == 'x') {
                    hops = hops + Math.abs(i - p);
                    p++;
                }
            }
            min = Math.min(min, hops);
        }

        return min;
    }

    public static void main(String[] args) {
        String s = "....x..xx...x..";
        System.out.println(seats(s));
    }
}
