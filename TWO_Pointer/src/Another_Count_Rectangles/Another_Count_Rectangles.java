package Another_Count_Rectangles;

import java.util.ArrayList;

public class Another_Count_Rectangles {
    public static int solve(ArrayList<Integer> A, int B) {
        int n=A.size();
        int s = 0;
        int e = A.size() - 1;
        int MOD=1000*1000*1000+7;
        long ans = 0;
        while (s <n  && e >= 0) {
            long area= (long) A.get(s) * A.get(e);
            if ( area>= B) {
                e--;
            }else{
                ans = (ans % MOD + (e + 1) % MOD) % MOD;
                s++;
            }

        }
        return (int)ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        int B=5;
        System.out.println(solve(A,B));
    }
}
