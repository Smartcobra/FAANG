package Plus_One;

import java.util.ArrayList;

public class Solution3 {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 1;
        int i = 0;

        ///to remove leading zero
        while (i <= A.size() - 1 && A.get(i) == 0) {
            A.remove(i);
        }
        ////trick is here
        for (i = A.size() - 1; i >= 0; i--) {
            int tmp = A.get(i) + carry;
            if (tmp > 9) {
                A.set(i, 0);
                carry = 1;
            } else {
                A.set(i, tmp);
                carry = 0;
            }
        }
        if (carry == 1) {
            A.add(0, carry);
        }
        return A;
    }

    public static void main(String[] args) {
        // int [] a= {0,0,0,0,9,9,9,9,9}; //100000
        // int [] a= {1,2,3,4}; //100000
        int[] a = {0};
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        plusOne(list).stream().forEach(System.out::print);
    }
}
