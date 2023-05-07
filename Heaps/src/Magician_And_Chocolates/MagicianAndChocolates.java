package Magician_And_Chocolates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {
    public class Solution {
        public int magicChocolate(int A, ArrayList<Integer> B) {
            int MOD=1000*1000*1000+7;
            long ans=0;
            PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<B.size();i++){
                maxHeap.add(B.get(i));
            }

            for(int i=0;i<A;i++){
                int val=maxHeap.poll();
                ans=ans%MOD+val;
                maxHeap.add((int)Math.floor(val/2));
            }

            return (int)ans%MOD;
        }
    }

}
