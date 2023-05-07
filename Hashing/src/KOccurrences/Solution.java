package KOccurrences;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int getSum(int A, int B, int[] C) {
            int sum=0;
            int flag=0;
            int MaxSum=Integer.MAX_VALUE;
            HashMap<Integer,Integer> map= new HashMap<>();
            for(int i=0;i<C.length;i++){
                map.put(C[i],map.getOrDefault(C[i],0)+1);
            }
            for(Map.Entry<Integer,Integer> entry :map.entrySet()){
                if(entry.getValue()==B){
                    flag=1;
                    sum +=entry.getKey();
                }
            }
            if(sum>MaxSum){
                return sum%10^9 +7;
            }else if(flag==0){
                return -1;
            }else{
                return sum;
            }

    }

    public static void main(String[] args) {
       int N=5;
       int K=2;
       int [] A={1,2,2,3,3};
        System.out.println(getSum(N,K,A));
    }
}
