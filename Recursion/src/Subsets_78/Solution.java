package Subsets_78;

/*


                             []
                 Exclude /        \ Include
                        []          [1]
                 Exclude /  \ Include  /  \
                   []      [2]      [1]  [1, 2]
           Exclude / \ Include  Exclude / \ Include
             []   [3] [2] [2, 3]   [1] [1, 3] [1, 2] [1, 2, 3]


 */

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void generateSubsets(int[] nums, List<List<Integer>> ans, List<Integer> current, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        //include
        current.add(nums[idx]);
        generateSubsets(nums,ans,current,idx+1);
        current.remove(current.size()-1);
        //exclude
        generateSubsets(nums,ans,current,idx+1);


    }

}
