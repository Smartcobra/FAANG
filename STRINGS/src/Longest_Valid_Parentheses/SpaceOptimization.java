package Longest_Valid_Parentheses;

public class SpaceOptimization {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int max=0;
        int open=0;
        int close=0;

        for(int i=0;i<n;i++){
            char c= s.charAt(i);
            if(c=='('){
                open++;

            }else{
                close++;
            }

            if(open==close){
                max=Math.max(max,open+close);
            } else if (close>open) {
                open=0;
                close=0;
            }
        }
        open=0;
        close=0;
        for(int i=n-1;i>=0;i--){
            char c= s.charAt(i);
            if(c=='('){
                open++;

            }else{
                close++;
            }

            if(open==close){
                max=Math.max(max,open+close);
            } else if (open>close) {
                open=0;
                close=0;
            }
        }

        return max;

    }
}
