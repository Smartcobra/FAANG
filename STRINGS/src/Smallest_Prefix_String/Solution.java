package Smallest_Prefix_String;

///https://www.scaler.com/academy/mentee-dashboard/class/29548/homework/problems/884?navref=cl_tt_nv
public class Solution {
    public String smallestPrefix(String A, String B) {
        int lenA=A.length();

        String ans="";

        char a=A.charAt(0);
        char b=B.charAt(0);
        ans=ans+a;

        int i=1;

        while(i<lenA && A.charAt(i)<b){
            ans=ans+A.charAt(i);
            // if(A.charAt(i)==b){
            //     //return ans;
            //     break;
            // }
            i++;
        }
        ans=ans+b;
        return ans;

    }
}
