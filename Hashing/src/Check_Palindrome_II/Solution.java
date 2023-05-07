package Check_Palindrome_II;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solve(String A) {
        int n=A.length();
        int odd=0;
        HashMap<Character,Integer> map= new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(A.charAt(i),map.getOrDefault(A.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> mp: map.entrySet()){
            if((mp.getValue()&1)==1){
                odd++;
            }

            if(odd>1) return 0;
        }

        return 1;
    }
}
