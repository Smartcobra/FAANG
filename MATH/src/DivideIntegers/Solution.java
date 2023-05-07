package DivideIntegers;

public class Solution {


    public static int divide(int A, int B) {
        //A devidend
        //B divisor

        boolean isNegetive=false;
        if((A<0 && B>0) || (A>0 && B<0)){
            isNegetive=true;
        }
        long  absA= Math.abs((long)A);
        long absB=Math.abs((long)B);
        long ans=0;

        while(absA >= absB){
            long tmp=absB;
            long qut=1;

            while(tmp<=absA){
                //  tmp =(tmp<<1);
                //  qut =(qut<<1);
                tmp<<=1;
                qut<<=1;
            }

            ans += (qut>>1);
            absA -=(tmp>>1);
        }

        if(isNegetive) ans = (int)~ans + 1;
        return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE: (int)ans;
    }

    public static void main(String[] args) {
        int A = 2147483647;
        int B = 1;

        System.out.println(divide(A,B));
    }
}
