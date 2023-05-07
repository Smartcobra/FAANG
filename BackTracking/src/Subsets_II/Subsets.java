package Subsets_II;

import java.util.ArrayList;
import java.util.Collections;

///using for loop find subsets

public class Subsets {

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> subSets= new ArrayList<>();
        int idx=0;
        Collections.sort(A); /// to match scalar output
        getSubSets(subSets,A,new ArrayList<>(),idx);
        return subSets;

    }

    public static void getSubSets(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> input, ArrayList<Integer> subset,int idx){
        result.add(new ArrayList<>(subset));
        for(int i=idx;i<input.size();i++){
            subset.add(input.get(i));
            getSubSets(result,input,subset,i+1);
            subset.remove(subset.size()-1);

        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
//        A.add(3);
//        A.add(6);
//        A.add(5);

        System.out.println(subsets(A).toString());
    }
}
