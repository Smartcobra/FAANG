package StringOperations;

/*
*
* Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:

Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.

You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.

NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.
*
* */

public class Solution {

    public static String  solve(String str){

        StringBuilder sb= new StringBuilder();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                    sb.append("#");
                }else{
                    sb.append(str.charAt(i));
                }
            }
        }
        sb.append(sb);

        return sb.toString();
    }

    public static void main(String[] args) {
        String str="AbcaZeoB";
        System.out.println(solve(str));
    }
}
