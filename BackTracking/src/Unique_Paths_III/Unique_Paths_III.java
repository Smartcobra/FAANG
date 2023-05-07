package Unique_Paths_III;

////https://www.scaler.com/academy/mentee-dashboard/class/35028/assignment/problems/4176?navref=cl_tt_lst_nm
public class Unique_Paths_III {

    public static int solve(int[][] A) {
        int zero = 0;
        int sx = 0;
        int sy = 0;
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                if (A[r][c] == 0) {
                    zero++;    ///counting total zero to insure all valid paths touched as per question
                } else if (A[r][c] == 1) {
                    sx = r;
                    sy = c;
                }
            }
        }
        return uniqPaths(A, sx, sy, zero);
    }

    public static int uniqPaths(int[][] A, int x, int y, int zeros) {
         ///// base case start
        if (x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] == -1) {
            return 0;
        }

        if (A[x][y] == 2) {
            return zeros == -1 ? 1 : 0;
        }
        ///// base case end

        A[x][y] = -1;
        zeros--;


        int paths = uniqPaths(A, x + 1, y, zeros) +
                uniqPaths(A, x, y + 1, zeros) +
                uniqPaths(A, x - 1, y, zeros) +
                uniqPaths(A, x, y - 1, zeros);

        A[x][y] = 0;    // backtrack
        zeros++;
        return paths;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}};
        System.out.println(solve(A));
    }
}
