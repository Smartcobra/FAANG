package Merge_Intervals;

import java.util.ArrayList;

public class Solution {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result= new ArrayList<>();
        int i=0;
        int n= intervals.size();

        while(i<n && intervals.get(i).end <newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }

        Interval mi= newInterval;

        while(i<n && intervals.get(i).start <= newInterval.end){
            mi.start=Math.min(mi.start,intervals.get(i).start);
            mi.end=Math.max(mi.end,intervals.get(i).end);
            i++;
        }
        result.add(mi);

        while(i<n) {
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }
}
