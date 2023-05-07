package Number_OF_Squareful_Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    static int count = 0;
    public static int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<>());
        return count;
    }

    private static void dfs(int[] nums, boolean[] visited, ArrayList<Integer> currAns) {
        if (currAns.size() == nums.length) {
            //System.out.println(currAns);
            count++;
            return;
        }

        for (int i = 0; i<nums.length; i++) {
            if (visited[i]) continue;
            if (i!=0 && nums[i-1] == nums[i] && !visited[i-1]) continue;
            if (currAns.size() > 0 && !perfectSquare(currAns.get(currAns.size()-1), nums[i])) continue;
            currAns.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, currAns);
            visited[i] = false;
            currAns.remove(currAns.size() - 1);
        }
    }

    private static  boolean perfectSquare(int a, int b) {
        int sqrt = (int) Math.sqrt(a+b);
        return a+b == sqrt * sqrt;
    }

    public static void main(String[] args) {
        int []  A={2262, 238, 123, 21, 15, 21, 4, 60, 40, 60, 40};

        System.out.println(numSquarefulPerms(A));
    }
}
