package Max_MinEvenOdd;

import java.util.ArrayList;

public class MaxMinCheck {
    public int solve(ArrayList<Integer> list) {

        int max_Even= list.stream().filter(e -> e % 2 == 0).max(Integer::compare).get();



       // int min_Even= list.stream().filter(e->e%2 !=0).min().getAsInt();

        //return max_Even-min_Even;
        return 0;
    }

    public static void main(String[] args) {

    }


}
