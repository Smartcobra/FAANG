package Reverse_String;
/*
*
* You are given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

    A sequence of non-space characters constitutes a word.
    Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
    If there are multiple spaces between words, reduce them to a single space in the reversed string.
*/

public class Solution {

    public static String solve(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i =str.length-1; i>=0;i--){
            if(i!=0){
                sb.append(str[i]+" ");
            }else{
                sb.append(str[i]);  // this is to append the last word here "the" and we dont need space after that
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String  A = "the sky is blue";
        System.out.println(solve(A));
    }


}
