package All_Unique_Permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AllUniquePermutations {
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        ArrayList<Integer> curRes = new ArrayList<>();
        boolean[] choices = new boolean[A.size()];

        permutations(res, A, curRes, choices);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>(res);

        return ans;

    }

    public static void permutations(Set<ArrayList<Integer>> res, ArrayList<Integer> input,
                                    ArrayList<Integer> curRes, boolean[] choices) {

        if (curRes.size() == input.size()) {
            res.add(new ArrayList<>(curRes));
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            if (!choices[i]) {
                choices[i] = true;
                curRes.add(input.get(i));
                permutations(res, input, curRes, choices);
                //backtrack
                choices[i] = false;
                curRes.remove(curRes.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(1);
        input.add(2);
        System.out.println(permute(input));
    }
}
