package Sub_Array_Sum_Equal_to_Given_Sum;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution4 {

    public static void solve(ArrayList<Integer> arr, int sum) {

        int end = 0;
        int sum_till_now = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (end < arr.size()) {
            sum_till_now += arr.get(end);

            if (sum_till_now == sum) {
                System.out.println("start Index" + 0 + " end Index " + end);
                return;
            }

            //windowsum
            int window_sum = sum_till_now - sum;

            if (map.containsKey(window_sum)) {
                int start=map.get(window_sum)+1;
                System.out.println("start Index " +  start + " end index " + end);
                return;

            }

            map.put(sum_till_now, end);
            end++;

        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int B = 5;
        solve(list,B);
    }
}
