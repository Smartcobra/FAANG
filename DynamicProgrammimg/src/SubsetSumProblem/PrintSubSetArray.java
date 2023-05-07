package SubsetSumProblem;

import java.util.ArrayDeque;

class Pair {
    int i;
    int j;
    String pathSoFar;

    Pair(int i, int j, String pathSoFar) {
        this.i = i;
        this.j = j;
        this.pathSoFar = pathSoFar;
    }
}

public class PrintSubSetArray {
    public void printSubSets(int arr[], int sum) {
        if (arr.length == 0 || arr == null || sum == 0) {
            System.out.println(" No elements availabe");
        }

        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println( dp[n][sum]);
        ArrayDeque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(n, sum, ""));  //adding the result to the queue

        while (deque.size() >0) {
            Pair remain = deque.removeFirst();

            if (remain.i == 0 || remain.j == 0) {
                System.out.println(remain.pathSoFar);
            } else {
                boolean exclude = dp[remain.i - 1][remain.j];
                if (exclude) {
                    deque.add(new Pair(remain.i - 1, remain.j, remain.pathSoFar));
                }
                if (remain.j >= arr[remain.i - 1]) {
                    boolean include = dp[remain.i - 1][remain.j - arr[remain.i - 1]];
                    if (include) {
                        //deque.add(new Pair(remain.i - 1, remain.j - arr[remain.i - 1], remain.pathSoFar + " " + (remain.i - 1)));
                        deque.add(new Pair(remain.i - 1, remain.j - arr[remain.i - 1],  arr[(remain.i - 1)] + " "+remain.pathSoFar  ));
                    }
                }
            }

        }


    }

    public static void main(String[] args) {
        //int arr[] = {1, 2, 4, 5, 8};
       int  arr[] = {2, 3, 5, 6, 8, 10};
       int sum = 10;
        PrintSubSetArray ssh = new PrintSubSetArray();
        ssh.printSubSets(arr, sum);
    }
}
