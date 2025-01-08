package SubArray_Sum_Equal_to_Given_Sum_Return_Index;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/// subarraysum(i,j) = ps[j] - ps[i-1] ,
// target = ps[j] - ps[i-1] , =>    - ps[i-1] =  target - ps[j] => ps[i-1] = ps[j]-target
////// basically we need to find for a prefix value j- target , how many ps[i-1] , exists
//k=33
//[9 4 0 20 3 10 5] => [9 13 13 33 36 46 51]  => 46-13 =33,
//    i       i              i        j
///ans [9 4 0 20] , [0 20 3 10] , [0 20 3 10]  as 13 comes twice it will contribute 2 count, so we map will be used
// 46-13 , 13 in position 1 and 2 in prefix array
public class Solution_using_prefix_sum {
    public static List<int[]> subarraySum(int[] arr, int target) {
        int n = arr.length;
        int[] pfx = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        pfx[0] = arr[0];
        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            pfx[i] = pfx[i - 1] + arr[i];
        }

        for (int j = 0; j < n; j++) {
            if (pfx[j] == target) {
                result.add(new int[]{0, j});
            }

            int val = pfx[j] - target;    ///val is basically pfx[i-1]

            if (map.containsKey(val)) {
                for (int startIndex : map.get(val)) {
                    result.add(new int[]{startIndex + 1, j});
                }
            }
            map.computeIfAbsent(pfx[j], k -> new ArrayList<>()).add(j);

        }


        return result;
    }
    public static void main(String[] args) {
        int[] arr = {9, 4, 0, 20, 3, 10, 5};
        int target = 33;

        List<int[]> result =subarraySum(arr, target);

        for (int[] indices : result) {
            System.out.println("Subarray found from index " + indices[0] + " to " + indices[1]);
        }
    }

}
