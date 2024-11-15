package Three_Sum_Zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Solution2 {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > 0) break;
            if (i == 0 || !Objects.equals(A.get(i), A.get(i - 1))) {
                twoSum(A, i, result);
            }
        }
        return result;
    }

    public void twoSum(ArrayList<Integer> A, int i, ArrayList<ArrayList<Integer>> result) {
        int low = i + 1;
        int high = A.size() - 1;

        while (low < high) {
            int sum = A.get(i) + A.get(low) + A.get(high);
            if (sum < 0) {
                low++;
            } else if (sum > 0) {
                high--;
            } else {
                result.add(new ArrayList(Arrays.asList(A.get(i), A.get(low), A.get(high))));
                low++;
                high--;
                while (low < high && A.get(low) == A.get(low - 1)) {
                    low++;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
