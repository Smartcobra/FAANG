package FreeCars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Scalar {

    class BuyCars{
        int time;
        int profit;

        BuyCars(int time,int profit){
            this.time=time;
            this.profit=profit;
        }
    }


    public class Solution {
        public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
            int MOD=1000*1000*1000+7;
            int n=A.size();
            ArrayList<BuyCars> cars= new ArrayList<>();
            for(int i=0;i<n;i++){
                BuyCars car=new BuyCars(A.get(i),B.get(i));
                cars.add(car);
            }
            Collections.sort(cars,  (c1, c2)->c1.time-c2.time);
            PriorityQueue<Integer> pq= new PriorityQueue<>();

            for(int i=0;i<n;i++){
                BuyCars c=cars.get(i);
                int time=c.time;
                int profit=c.profit;

                if(time>pq.size()){
                    pq.add(profit);
                } else if (profit> pq.peek()) {
                    pq.remove();
                    pq.add(profit);
                }
            }

            int ans=0;
            while (pq.size()>0){
                ans=ans%MOD+pq.peek()%MOD;
                pq.remove();
            }

            return ans%MOD;
        }
    }

}
