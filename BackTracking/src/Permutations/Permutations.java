package Permutations;

import java.util.ArrayList;

///https://www.scaler.com/academy/mentee-dashboard/class/35028/assignment/problems/138?navref=cl_tt_lst_nm
public class Permutations {

    public static  void permutations(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> input, ArrayList<Integer> curRes,boolean[] choices){
        if(curRes.size()==input.size()){
            res.add(new ArrayList<>(curRes));
            return;
        }
        for(int i=0;i<input.size();i++){
            if(!choices[i]){
                choices[i]=true;
                curRes.add(input.get(i));
                permutations(res,input,curRes,choices);
                //backtrack
                choices[i]=false;
                curRes.remove(input.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        ArrayList<Integer> input= new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
     //   input.add(4);
        ArrayList<Integer> curRes= new ArrayList<>();
        boolean[] choices = new boolean[3];

        permutations(res,input,curRes,choices);
        System.out.println(res);

    }
}
