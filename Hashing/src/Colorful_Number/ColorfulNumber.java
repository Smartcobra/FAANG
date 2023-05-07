package Colorful_Number;
//https://www.scaler.com/academy/mentee-dashboard/class/29546/homework/problems/275/submissions
import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {

    public static int colorful(int A) {
        Set<Integer> set = new HashSet<>();
        int B=A,i=0,prod=1;

        while(A>0){
            int d = B%10;
            prod=prod*d;
            if(set.contains(prod)){
                return 0;
            }
            set.add(prod);

            B=B/10;

            if(B==0){
                A=A/10;
                B=A;
                prod=1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int A=236;

        int colorful = colorful(236);
        System.out.println(colorful);

    }

}
