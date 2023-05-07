package Finish_Maximum_Jobs;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

//https://www.scaler.com/academy/mentee-dashboard/class/35027/assignment/problems/9291?navref=cl_tt_lst_nm


class Activity{
    int start;
    int end;
    public Activity(int start, int end){
        this.start=start;
        this.end=end;
    }
}

public class Finish_Maximum_Job {

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Activity>  activities= new ArrayList<>();
        int ans=1;
        int n=A.size();
        for(int i=0;i<n;i++){
            Activity activity= new Activity(A.get(i),B.get(i));
            activities.add(activity);
        }
        Collections.sort(activities, (a1, a2) -> a1.end-a2.end);
        int cur_end=activities.get(0).end;

        for(int i=1;i<activities.size();i++){
            if(activities.get(i).start>=cur_end){
                ans++;
                cur_end=activities.get(i).end;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a= new ArrayList<>();
        a.add(1);
        a.add(5);
        a.add(7);
        a.add(1);

        ArrayList<Integer> b= new ArrayList<>();
        b.add(7);
        b.add(8);
        b.add(8);
        b.add(8);

        System.out.println(solve(a,b));
    }

}



