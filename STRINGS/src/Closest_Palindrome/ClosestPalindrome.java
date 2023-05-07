package Closest_Palindrome;

////https://www.scaler.com/academy/mentee-dashboard/class/29548/homework/problems/900?navref=cl_tt_lst_nm
public class ClosestPalindrome {

    public String solve(String A) {
        int n=checkPalindrome(A);

        if (n==0){
            return "NO";
        } else if (n==1) {
            return "YES";
        } else
            return "NO";
    }

    public int checkPalindrome(String str){
        int s=0;
        int e=str.length()-1;
        int count=0;

        while(s<e){
            if(str.charAt(s)!=str.charAt(e)){
               count++;
            }
            s++;
            e--;
        }
        return count ;
    }
}
