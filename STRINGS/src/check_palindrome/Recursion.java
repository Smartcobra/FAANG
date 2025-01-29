package check_palindrome;

public class Recursion {

    public static  boolean isPalindrome(String s){
        return solve(s,0,s.length()-1);
    }

    private static boolean solve(String s, int start, int end) {
        if(start>end){
            return true;
        }

        if(s.charAt(start) == s.charAt(end)){
           return solve(s,start+1,end-1);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("a"));
    }

}
