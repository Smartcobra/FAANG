package check_palindrome;

public class Solution {
    public static boolean isPalindrome(String s){
        int n= s.length();
        int i=0;
        int j= n-1;

        while (i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("a"));
    }
}
