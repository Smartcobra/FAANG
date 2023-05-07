package Shaggy_Ans_Distances;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        int minlength=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map= new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(A.get(i))){
                int end=i;
                int start=map.get(A.get(i));
                minlength=Math.min(minlength,end-start);
            }else{
                map.put(A.get(i),i);
            }
        }
        //return minlength;
        return (minlength==Integer.MAX_VALUE)?-1:minlength;
    }
}
