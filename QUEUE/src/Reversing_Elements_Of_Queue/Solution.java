package Reversing_Elements_Of_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        Queue<Integer> q = new LinkedList<>(A);
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 1;

        while (count <= B) {
            int x = q.poll();
            stack.add(x);
            count++;
        }
        count = 1;
        while (!stack.isEmpty()) {
            int x = stack.pop();
            q.offer(x);
        }
        while (count <= n - B) {
            int x = q.poll();
            q.add(x);
            count++;
        }
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        return ans;
    }
}
