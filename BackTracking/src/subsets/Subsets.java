package subsets;

import java.util.ArrayList;
//https://www.scaler.com/academy/mentee-dashboard/class/35028/assignment/problems/148/?navref=cl_pb_nv_tb
public class Subsets {


    public static void getSubsets(ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> input, ArrayList<Integer> temOut, int i){
       int n=input.size();
        if(n==i){
           subsets.add(temOut);
           return;
       }

        getSubsets(subsets,input,new ArrayList<>(temOut),i+1);
        temOut.add(input.get(i));
        getSubsets(subsets,input,new ArrayList<>(temOut),i+1);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();

        // Input ArrayList
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        getSubsets(subsets, input, new ArrayList<>(), 0);

        System.out.println(subsets);
    }
}
