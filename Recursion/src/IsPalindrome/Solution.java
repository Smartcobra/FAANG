package IsPalindrome;

public class Solution {

    public static boolean isPalindrome(String str){
        if(str.length()==0){
            return true;
        }
        int start=0;
        int end=str.length()-1;

        return isPalindrome(str,start,end);

    }

    private static boolean isPalindrome(String str, int start, int end) {
        //base condition
        if(start >=end){
            return true;
        }

        if(str.charAt(start)==str.charAt(end)){
            if(isPalindrome(str,start+1,end-1)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str="naman";
        System.out.println(isPalindrome(str));
    }
}
