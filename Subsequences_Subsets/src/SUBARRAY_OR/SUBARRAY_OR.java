package SUBARRAY_OR;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SUBARRAY_OR {
    public int solve(ArrayList<Integer> A) {
        long sum = 0;
        long sum1 = 0;
        int n=A.size();

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<A.size();i++){
            set.add(A.get(i));
            for(int j=i-1;j>=0;j--){
                if((A.get(i) | A.get(j))==A.get(j)){
                    break;
                }

                A.set(j,A.get(j) | A.get(i));

                set.add(A.get(j));
            }
        }
        return set.size();
    }
}
