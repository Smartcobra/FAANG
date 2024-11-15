import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }


    public String minWindow(String s, String t) {
        int n= s.length();
        int reqCount=t.length();
        int minLen=Integer.MAX_VALUE;
        int startLeft=0;

        int right=0;
        int left=0;


        Map<Character,Integer> map= new HashMap<>();
        for(Character c: t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        while(right<n){
            char rc = s.charAt(right);

            if(map.containsKey(rc)){
                if(map.get(rc)>0){
                    reqCount--;
                }
                map.put(rc,map.get(rc)-1);
            }

            while(reqCount==0){
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    startLeft=left;
                }

                char lc= s.charAt(left);
                if(map.containsKey(lc)){
                    map.put(lc,map.get(lc)+1);
                    if(map.get(lc)>0){
                        reqCount++;
                    }
                }
                left++;
            }

            right++;

        }

        return minLen ==Integer.MAX_VALUE? "": s.substring(startLeft,startLeft+minLen);

    }
}