package Reverse_Words_in_a_String;

public class ReverseString {

    public static String reverseWords(String s) {
        StringBuilder sb=new StringBuilder("");
        for(int i=0,j=0;i<s.length();i++){
            if(j<s.length() && s.charAt(j)==' '){
                while(j<s.length() && s.charAt(j)==' '){
                    j++;
                    i=j-1;
                }
            }
            else if(j<s.length()){
                while(j<s.length() && s.charAt(j)!=' '){
                    j++;
                }
                sb.insert(0,s.substring(i,j)+" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";

        System.out.println(reverseWords(s));

    }
}
