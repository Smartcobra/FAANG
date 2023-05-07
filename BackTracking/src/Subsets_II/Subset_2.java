package Subsets_II;

import java.util.ArrayList;
import java.util.Collections;

///https://www.scaler.com/academy/mentee-dashboard/class/35028/homework/problems/146?navref=cl_tt_lst_nm
public class Subset_2 {
    public static ArrayList<ArrayList<Integer>> subsets_2(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> subSets= new ArrayList<>();
        int idx=0;
        Collections.sort(A); /// to match scalar output
        getSubSets(subSets,A,new ArrayList<>(),idx);
        return subSets;

    }

    public static void getSubSets(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> input, ArrayList<Integer> subset,int idx){
        result.add(new ArrayList<>(subset));
        for(int i=idx;i<input.size();i++){
            if(i>idx && input.get(i)==input.get(i-1) ){
                continue;
            }
            subset.add(input.get(i));
            getSubSets(result,input,subset,i+1);
            subset.remove(subset.size()-1);

        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>();
        A.add(6);
        A.add(6);
        A.add(3);
        A.add(3);
        A.add(6);
        A.add(5);

        System.out.println(subsets_2(A).toString());
    }
}
