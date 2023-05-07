package Word_Break;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break/
public class WordBreak {

    public static  boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Set<String> set= new HashSet<>(wordDict);

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                String word2Check = s.substring(j,i+1);
                if(set.contains(word2Check)){
                    if(j>0){
                        dp[i] +=dp[j-1];
                    }else{
                        dp[i] =1;
                    }
                }
            }
        }
        return dp[s.length()-1]>0;
    }

    public static void main(String[] args) {
        String s="leetcode";
        String s1 = "leet";
        String s2 ="code";
        List<String> list= new ArrayList<>();
        list.add(s1);
        list.add(s2);

        System.out.println(wordBreak(s,list));

    }
}
