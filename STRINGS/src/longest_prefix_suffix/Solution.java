package longest_prefix_suffix;

public class Solution {

    public int[] computeLPSArray(String s){
        int n= s.length();
        int len=0;
        int idx=0;
        int []lps = new int[n];

        lps[0]=0;

        while(idx<n){
            if(s.charAt(idx) == s.charAt(len)){
                len++;
                lps[idx]= len;
                idx++;
            }else{
                if(len !=0){
                    len =lps[len-1];
                }else{
                    lps[idx] =0;
                    idx++;
                }
            }
        }

        return lps;
    }
}
