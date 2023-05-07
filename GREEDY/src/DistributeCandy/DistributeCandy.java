package DistributeCandy;


import java.util.ArrayList;
import java.util.Collections;

//https://www.scaler.com/academy/mentee-dashboard/class/35027/assignment/problems/3/?navref=cl_pb_nv_tb
/// Think Better
public class DistributeCandy {
    public int candy(ArrayList<Integer> A) {
        int n=A.size();
        int ans=0;
        ArrayList<Integer> right= new ArrayList<>(Collections.nCopies(n,1));
        ArrayList<Integer> left= new ArrayList<>(Collections.nCopies(n,1));

        for(int i=1;i<n;i++){
            if(A.get(i)>A.get(i-1)){
                left.set(i,left.get(i-1)+1);
            }
        }

        for(int i=n-2;i>=0;i--){
            if(A.get(i)>A.get(i+1)){
                right.set(i,right.get(i+1)+1);
            }
        }

        for(int i=0;i<n;i++){
            ans=ans+Math.max(left.get(i),right.get(i));
        }

        return ans;
    }
}
