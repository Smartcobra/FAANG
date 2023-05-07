package Three_Sum_Zero;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        int n = A.size();
        for (int i = 0; i < n - 3; i++) {
            int l = i + 1;
            int r = n - 1;
            //int x=A.get(i);
            // int sum=0;
            while (l <= r) {
                int sum = A.get(i) + A.get(l) + A.get(r);
                if (sum == 0) {
                    //result.add(new ArrayList(Arrays.asList(x,A.get(l),A.get(r))));
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(A.get(i));
                    tmp.add(A.get(l));
                    tmp.add(A.get(r));
                    Collections.sort(tmp);
                    if (!result.contains(tmp)) {
                        result.add(tmp);
                    }
                    l++;

                    //  while(l<r && A.get(r)==A.get(r+1)){
                    //          r--;
                    //  }
                } else if (sum < 0) {
                    l++;

                } else {
                    r--;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
     // -5, 5, 5, -1, 0, -5, -1, -1, -3, 3, 2, 5, 1, 0, 5, -1 ]
    }
}
