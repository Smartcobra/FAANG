package Number_OF_Squareful_Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Number_OF_Squareful_Arrays {


    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> input) {
        Set<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<Integer> cur = new ArrayList<>();
        boolean[] choices = new boolean[input.size()];
        getAllUniquPermutaion(set, input, cur, choices);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>(set);
        return result;
    }

    private static void getAllUniquPermutaion(Set<ArrayList<Integer>> result, ArrayList<Integer> input, ArrayList<Integer> cur, boolean[] choices) {
        if (input.size() == cur.size()) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            if (choices[i]) {
                continue;
            }
            if ( cur.size() > 0 && !isSquare(cur.get(cur.size()-1), input.get(i))) {
                continue;
            }
            choices[i] = true;
            cur.add(input.get(i));

            getAllUniquPermutaion(result, input, cur, choices);

            choices[i] = false;
            cur.remove(input.get(i));
        }
    }

    private static boolean isSquare(int a, int b) {
        int sqrt = (int) Math.sqrt(a+b);
        return a+b == sqrt * sqrt;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(17);
        input.add(8);
        System.out.println(permute(input));
    }

}
