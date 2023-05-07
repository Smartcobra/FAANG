package Replicating_Substring;

import java.util.HashMap;
import java.util.Map;

//https://www.scaler.com/academy/mentee-dashboard/class/29547/assignment/problems/960?navref=cl_tt_lst_nm
public class ReplicatingSubstring {
    public int solve(int A, String B) {
        int n=B.length();
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(B.charAt(i),map.getOrDefault(B.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> m:map.entrySet()){
            if(m.getValue()%A !=0) return -1;
        }

        return 1;
    }

}
