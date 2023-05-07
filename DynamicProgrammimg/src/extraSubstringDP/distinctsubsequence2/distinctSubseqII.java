package extraSubstringDP.distinctsubsequence2;

import java.util.HashMap;

public class distinctSubseqII {
    public int findLength(String str){
        int dp[]= new int [str.length()+1];

        dp[0]=1;
        HashMap<Character,Integer> prevChar= new HashMap<Character,Integer>();

        for(int i=1;i<dp.length;i++){
            dp[i]=2*dp[i-1];
            char ch= str.charAt(i-1);
            if(prevChar.containsKey(ch)){
                int j= prevChar.get(ch); //finding the previous similar char position //lat occurance
                dp[i]=dp[i]-dp[j-1];   //
            }else{
                prevChar.put(ch,i);
            }

        }
        return dp[str.length()];
    }
}
