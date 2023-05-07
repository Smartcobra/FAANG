package AddMatrices;

import java.util.ArrayList;

public class AddMatrices {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {

        ArrayList<ArrayList<Integer>> result= new  ArrayList<ArrayList<Integer>>();

        int n=A.size();
        int m=A.get(0).size();

        for(int i=0;i<n;i++) {
            ArrayList<Integer> l= new ArrayList<Integer>();
            for(int j=0;j<m;j++){
                l.add(A.get(i).get(j)+B.get(i).get(j));

                if(j==m-1){
                    result.add(l);
                }
            }
        }

        return result;
    }
}
