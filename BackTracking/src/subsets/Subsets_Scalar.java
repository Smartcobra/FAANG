package subsets;

import java.util.ArrayList;
import java.util.Collections;
//https://www.scaler.com/academy/mentee-dashboard/class/35028/assignment/problems/148/?navref=cl_pb_nv_tb
public class Subsets_Scalar {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> subSets= new ArrayList<>();
        ArrayList<Integer> tmpOut= new ArrayList<>();
        int idx=0;
        Collections.sort(A); /// to match scalar output
        getSubSets(subSets,A,tmpOut,idx);

        subSets.sort((o1, o2) -> {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (o1.get(i) == o2.get(i)) {
                    continue;
                } else {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 1;
        });

        return subSets;

    }

    public void getSubSets(ArrayList<ArrayList<Integer>> subSets,ArrayList<Integer> A, ArrayList<Integer> tmpOut,int idx){
        int n=A.size();
        if(idx==n){
            subSets.add(tmpOut);
            return;
        }
        getSubSets(subSets,A,new ArrayList<>(tmpOut),idx+1);
        tmpOut.add(A.get(idx));
        getSubSets(subSets,A,new ArrayList<>(tmpOut),idx+1);
    }
}
