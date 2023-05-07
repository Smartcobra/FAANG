package FreeCars;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://www.scaler.com/academy/mentee-dashboard/class/35027/assignment/problems/9294/?navref=cl_pb_nv_tb

class BuyCars{
    int time;
    int profit;

    BuyCars(int time,int profit){
        this.time=time;
        this.profit=profit;
    }
}
public class FreeCars {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n=A.size();
        ArrayList<BuyCars> cars= new ArrayList<>();
        for(int i=0;i<n;i++){
            BuyCars car=new BuyCars(A.get(i),B.get(i));
            cars.add(car);
        }
        Collections.sort(cars,  (c1,c2)->c1.time-c2.time);
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
            ans=ans+pq.peek();
            pq.remove();
        }

        return ans;
    }
}
