package Plus_One;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution2 {

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 1;
        ArrayList<Integer> result = new ArrayList<>();
        //reverse the input
        // int j=0;
        //while(A.get(j)==0 && j<=A.size()-1) A.remove(j);
        Collections.reverse(A);


        for (int i = 0; i < A.size(); i++) {
            int temp = A.get(i) + carry;

            if (temp > 9) {
                result.add(0);
            } else {
                result.add(temp);
                carry = 0;
            }
        }
        Collections.reverse(result);

        if (carry == 1) {
            result.add(0, 1);
        }

        while (true) {
            if (result.get(0) == 0) {
                result.remove(0);
            } else {
                break;
            }
        }

        return result;
    }
}
