package Max_Non_Negative_SubArray;

import java.util.ArrayList;

public class Solution2 {

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long newSum = 0;
        long maxSum = 0;
        ArrayList<Integer> newArray = new ArrayList<>();
        ArrayList<Integer> maxArray = new ArrayList<>();
        for (Integer i : A) {
            if (i >= 0) {
                newSum += i;
                newArray.add(i);
            } else {
                newSum = 0;
                newArray = new ArrayList<>();
            }
            if (maxSum < newSum || newSum == maxSum && (newArray.size() > maxArray.size())) {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;
    }


}
