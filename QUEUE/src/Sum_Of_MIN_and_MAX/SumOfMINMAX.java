package Sum_Of_MIN_and_MAX;

import java.util.*;

public class SumOfMINMAX {
    public static int solve(List<Integer> A, int B) {
        Deque<Integer> dqG = new LinkedList<>();
        Deque<Integer> dqS = new LinkedList<>();
        int n = A.size();
        int l = 1;
        int r = B;
        int ans = 0;

        for (int i = 0; i < B; i++) {
            while (!dqG.isEmpty() && dqG.getLast() <= A.get(i)) {
                dqG.removeLast();
            }
            dqG.offerLast(A.get(i));
        }

        for (int i = 0; i < B; i++) {
            while (!dqS.isEmpty() && dqS.getLast() >= A.get(i)) {
                dqS.removeLast();
            }
            dqS.offerLast(A.get(i));

        }

        while (r < n) {
            ans = ans + dqS.getFirst() + dqG.getFirst();

            if (!dqG.isEmpty() && dqG.getFirst() == A.get(l-1)) {
                dqG.removeFirst();
            }

            while (!dqG.isEmpty() && dqG.getLast() <= A.get(r)) {
                dqG.removeLast();
            }
            dqG.offerLast(A.get(r));

            ////////////
            if (!dqS.isEmpty() && dqS.getFirst() == A.get(l-1)) {
                dqS.removeFirst();
            }
            while (!dqS.isEmpty() && dqS.getLast() >= A.get(r)) {
                dqS.removeLast();
            }
            dqS.offerLast(A.get(r));

            l++;
            r++;
        }
        ans = ans + dqS.getFirst() + dqG.getFirst();
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 5, -1, 7, -3, -1, -2);
        System.out.println(solve(arr, 4));
    }
}
